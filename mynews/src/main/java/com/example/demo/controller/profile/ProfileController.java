package com.example.demo.controller.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.entity.profile.Profile;
import com.example.demo.domain.form.ProfileEditForm;
import com.example.demo.domain.form.profile.ProfileForm;
import com.example.demo.domain.service.profile.ProfileDeleteService;
import com.example.demo.domain.service.profile.ProfileEditService;
import com.example.demo.domain.service.profile.ProfileListService;
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
    
    @Autowired
    private ProfileListService profileListService;

    @GetMapping("/profile/list")
    public String list(
            @RequestParam(name = "name", required = false) String name,
            Model model) {

        List<Profile> profileList = profileListService.list(name);
        model.addAttribute("profileList", profileList);
        model.addAttribute("name", name);

        return "profile/list";
    }
    
    @Autowired
    private ProfileEditService profileEditService;

    @Autowired
    private ProfileDeleteService profileDeleteService;

    @GetMapping("/profile/edit/{id}")
    public String edit(@ModelAttribute("form") ProfileEditForm form,
                       @PathVariable int id,
                       Model model) {

        model.addAttribute("profile", profileEditService.findProfile(id));
        return "profile/edit";
    }

    @PostMapping("/profile/edit/{id}")
    public String edit(@PathVariable int id,
                       @Validated @ModelAttribute("form") ProfileEditForm form,
                       BindingResult result,
                       Model model) {

        if (result.hasErrors()) {
            return edit(form, id, model);
        }

        profileEditService.edit(id, form);
        return "redirect:/profile/edit/complete";
    }

    @GetMapping("/profile/{action}/complete")
    public String actionComplete() {
        return "profile/complete";
    }

    @PostMapping("/profile/delete")
    public String delete(@RequestParam int id) {
        profileDeleteService.delete(id);
        return "redirect:/profile/list";
    }

}