package com.syzc.mis.service;

import com.syzc.mis.dao.mysql.UserDao;
import com.syzc.mis.entity.User;

public interface UserService extends BaseService<User, UserDao> {
    Boolean updateInfo(User user);

    Boolean updatePassword(String username, String oldPassword, String newPassword);

    Boolean updateResetPassword(Long userId, String newPassword);

    User login(String userName, String password);

    Boolean exists(String username);
}