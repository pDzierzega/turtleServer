package com.pDzierzega.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data
public abstract class BaseEntity {

    @Id
    @Column(unique = true)
    private String uuid = UUID.randomUUID().toString();

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
        lastUpdate = new Date();
    }

    @PreUpdate
    public void preUpdate(){
        lastUpdate= new Date();
    }
}
