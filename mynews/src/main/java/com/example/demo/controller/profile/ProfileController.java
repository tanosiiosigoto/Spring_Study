package com.example.demo.controller.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.form.profile.ProfileForm;
import com.example.demo.domain.service.profile.ProfileService;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profile/create")
    public String create(@ModelAttribute("form") ProfileForm form) {
        return "profile/create";
    }

    @PostMapping("/profile/create")
    public String create(
            @Validated @ModelAttribute("form") ProfileForm form,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "profile/create";
        }

        profileService.create(form);

        return "redirect:/profile/create/complete";
    }

    @GetMapping("/profile/create/complete")
    public String complete() {
        return "profile/complete";
    }
}