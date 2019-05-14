package com.example.springboot.audit;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
public abstract class AuditableMongo<T> {

    @CreatedBy
    protected T createBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createDate;

    @LastModifiedBy
    protected T lastUpdateBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastUpdateDate;

    public T getCreateBy() {
        return createBy;
    }

    public void setCreateBy(T createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public T getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(T lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
