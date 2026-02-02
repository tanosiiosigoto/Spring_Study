package com.example.demo.domain.form.profile;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ProfileForm {

    @NotEmpty(message = "＊名前を入力してください。")
    private String name;

    @NotEmpty(message = "＊性別を入力してください。")
    private String gender;
    
    @NotEmpty(message = "＊趣味を入力してください。")
    private String hobby;
    
    @NotEmpty(message = "＊自己紹介を入力してください。")
    private String introduction;

    private MultipartFile image;
}