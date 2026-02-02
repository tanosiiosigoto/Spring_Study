package com.example.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.profile.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}