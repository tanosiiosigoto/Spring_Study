package com.example.demo.domain.service.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.profile.Profile;
import com.example.demo.domain.entity.profile.ProfileHistories;
import com.example.demo.domain.form.ProfileEditForm;
import com.example.demo.domain.repository.ProfileHistoriesRepository;
import com.example.demo.domain.repository.ProfileRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProfileEditService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile findProfile(int id) {
        return profileRepository.findById(id).get();
    }

    public void edit(int id, ProfileEditForm form) {
        Profile profile = profileRepository.findById(id).get();

        profile.setName(form.getName());
        profile.setGender(form.getGender());
        profile.setHobby(form.getHobby());
        profile.setIntroduction(form.getIntroduction());

        profileRepository.save(profile);
        registerHistory(profile.getId());
    }
    
    @Autowired
    private ProfileHistoriesRepository profileHistoriesRepository;
    private void registerHistory(Long id) {
        ProfileHistories entity = new ProfileHistories();
        entity.setProfileId(id);
        profileHistoriesRepository.save(entity);
    }


}