package com.wizinno.lims.user.service.dto;

/**
 * @author LiuMei on 2017-06-21.
 */
public class UserSimpleDto {

    private Long id;

    private String username;

    private String nickname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
