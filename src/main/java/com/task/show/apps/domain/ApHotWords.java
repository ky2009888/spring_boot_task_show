package com.task.show.apps.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

/**
 * 搜索热词表
 * @TableName ap_hot_words
 */
@TableName(value ="ap_hot_words")
@Data
public class ApHotWords  implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Object id;

    /**
     * 热词
     */
    private String hotWords;

    /**
     * 0:热,1:荐,2:新,3:火,4:精,5:亮
     */
    private Integer type;

    /**
     * 热词日期
     */
    private String hotDate;

    /**
     * 创建时间
     */
    private Date createdTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ApHotWords other = (ApHotWords) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHotWords() == null ? other.getHotWords() == null : this.getHotWords().equals(other.getHotWords()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getHotDate() == null ? other.getHotDate() == null : this.getHotDate().equals(other.getHotDate()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHotWords() == null) ? 0 : getHotWords().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getHotDate() == null) ? 0 : getHotDate().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hotWords=").append(hotWords);
        sb.append(", type=").append(type);
        sb.append(", hotDate=").append(hotDate);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}