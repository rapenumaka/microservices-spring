package com.mdk.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass // Leverage this class as the base entity for all the other entity classes - This acts as a super entity
@EntityListeners(AuditingEntityListener.class)
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
