package com.example.demo.domain.entity.profile;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "profiles")
@Data
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String gender;
    private String hobby;
    private String introduction;

    private LocalDateTime registeredDate;
    private LocalDateTime updatedDate;
    
    @OneToMany(mappedBy = "profile")
    private List<ProfileHistories> histories;
}