package com.example.demo.domain.service.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.repository.ProfileRepository;

@Service
public class ProfileDeleteService {

    @Autowired
    private ProfileRepository profileRepository;

    public void delete(int id) {
        profileRepository.deleteById(id);
    }
}