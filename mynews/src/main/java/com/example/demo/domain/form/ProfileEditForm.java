package com.example.demo.domain.form;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProfileEditForm {

    @NotEmpty(message = "＊名前は必須です")
    @Size(max = 20, message = "＊名前は20文字以内")
    private String name;

    @NotEmpty(message = "＊性別は必須です")
    private String gender;

    @Size(max = 140, message = "＊趣味は140文字以内")
    private String hobby;

    @Size(max = 140, message = "＊自己紹介は140文字以内")
    private String introduction;
}