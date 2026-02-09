package com.example.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.entity.profile.ProfileHistories;

public interface ProfileHistoriesRepository
        extends JpaRepository<ProfileHistories, Integer> {
}