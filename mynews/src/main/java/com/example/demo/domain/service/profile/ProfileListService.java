package com.example.demo.domain.service.profile;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.profile.Profile;
import com.example.demo.domain.repository.ProfileRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProfileListService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> list(String name) {

        if (Objects.isNull(name) || name.isEmpty()) {
            return profileRepository.findAllByOrderById();
        } else {
            return profileRepository.findByNameLike(createLikeParam(name));
        }
    }

    private String createLikeParam(String param) {
        return "%" + param + "%";
    }
}
