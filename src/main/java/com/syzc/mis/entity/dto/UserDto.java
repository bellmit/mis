package com.syzc.mis.entity.dto;

import com.syzc.mis.entity.UserLogon;
import com.syzc.sseip.entity.Group;
import com.syzc.sseip.entity.User;

import java.io.Serializable;

public class UserDto extends User implements Serializable {
    private static final long serialVersionUID = 2042209216352215111L;
    private Group group;
    private UserLogon lastUserLogon;

    public UserDto() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public UserLogon getLastUserLogon() {
        return lastUserLogon;
    }

    public void setLastUserLogon(UserLogon lastUserLogon) {
        this.lastUserLogon = lastUserLogon;
    }
}