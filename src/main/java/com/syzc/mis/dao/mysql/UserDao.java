package com.syzc.mis.dao.mysql;

import com.syzc.mis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseDao<User> {
    Boolean updateResetPassword(@Param("id") Long userId, @Param("password") String password);

    Boolean updatePassword(@Param("username") String username, @Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword);

    Boolean existsUsername(String username);

    User getLogin(@Param("username") String username, @Param("password") String password);
}