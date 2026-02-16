package com.example.demo.domain.entity.profile;

import java.sql.Timestamp;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "profiles_histories")
@Data
public class ProfileHistories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "profile_id")
    private Integer profileId;

    @LastModifiedDate
    @Column(name = "edited_date")
    private Timestamp editedDate;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private Profile profile;
}