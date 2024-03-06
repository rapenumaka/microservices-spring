package com.mdk.app.entity;

import com.mdk.app.audit.AuditAwareImpl;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditAwareImpl.class)
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false) // Dont update this column when running a update sql stmt
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @CreatedBy
    @Column(insertable = false ) // Dont update this column when running a insert sql stmt
    private String updatedBy;

    @LastModifiedDate
    @Column(insertable = false )
    private LocalDateTime updatedAt;
}