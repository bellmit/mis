package com.syzc.mis.entity.dto;

import com.syzc.mis.entity.UserLogon;
import com.syzc.sseip.entity.User;

public class UserLogonDto extends UserLogon {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}