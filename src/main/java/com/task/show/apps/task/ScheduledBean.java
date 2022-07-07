package com.task.show.apps.task;

import cn.hutool.core.date.DateUtil;
import cn.hutool.log.StaticLog;
import com.task.show.apps.domain.ApHotWords;
import com.task.show.apps.service.ApHotWordsService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

@Component
public class ScheduledBean {
    /**
     * 注入热门关键词句柄.
     */
    @Resource
    private ApHotWordsService apHotWordsService;
    /**
     * 注入jdbcTemplate.
     */
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 每隔5秒钟执行一次
     */
    //@Scheduled(cron = "0/5 * * * * ?")
    @Scheduled(cron = "0/5 * * * * ?")
    public void printLog() {
        List<ApHotWords> list = apHotWordsService.list();
        ApHotWords apHotWords = list.get(0);
        StaticLog.info("执行时间:{},查询到的关键词:{}", DateUtil.now(), apHotWords.getHotWords());
        String sql = "select *  from ap_hot_words where id = 5 ";
        List<ApHotWords> apHotWordsList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            ApHotWords temp = new ApHotWords();
            temp.setId(rs.getInt("id"));
            temp.setHotWords(rs.getString("hot_words"));
            temp.setType(rs.getInt("type"));
            temp.setHotDate(rs.getString("hot_date"));
            Date createdTime = rs.getDate("created_time");
            temp.setCreatedTime(createdTime);
            return temp;
        });
        if (apHotWordsList != null) {
            StaticLog.info("总共查询的记录数量是:{}", apHotWordsList.size());
        }
        //检查字段名称
        /*jdbcTemplate.query(sql,(rs, rowNum) -> {

        });*/
    }

    /**
     * 每隔5秒钟执行一次
     * 0 0 * * * ? 每天每1小时触发一次
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void taskByHour() {
        List<ApHotWords> list = apHotWordsService.list();
        ApHotWords apHotWords = list.get(0);
        StaticLog.info("每小时执行一次，执行时间:{},查询到的关键词:{}", DateUtil.now(), apHotWords.getHotWords());
    }
}
