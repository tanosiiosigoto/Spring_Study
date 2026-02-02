package com.example.demo.domain.service.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.profile.Profile;
import com.example.demo.domain.form.profile.ProfileForm;
import com.example.demo.domain.repository.ProfileRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public void create(ProfileForm form) {

        Profile profile = createProfile(form);
        profileRepository.save(profile);
    }

    private Profile createProfile(ProfileForm form) {

        Profile entity = new Profile();
        entity.setName(form.getName());
        entity.setGender(form.getGender());
        entity.setHobby(form.getHobby());
        entity.setIntroduction(form.getIntroduction());

        return entity;
    }
}
