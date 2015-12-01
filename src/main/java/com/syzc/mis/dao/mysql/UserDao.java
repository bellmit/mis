package com.syzc.mis.dao.mysql;

import com.syzc.mis.dao.mysql.BaseDao;
import com.syzc.mis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends BaseDao<User> {
    List<User> listByGroup(@Param("groupId") Long groupId, @Param("offset") Long offset, @Param("size") Byte size);

    Long countByGroup(Long groupId);

//    Boolean updateInfo(@Param("user") User user);

    Boolean updateResetPassword(@Param("id") Long userId, @Param("password") String password);

    Boolean updatePassword(@Param("id") Long userId, @Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword);

    /**
     * 判断用户存不存在； 读取新加入的用户.
     *
     * @param username 用户名
     * @return 用户entiry
     */
    User getByUserName(String username);

    Boolean existUsername(String username);

    User login(@Param("username") String userName, @Param("password") String password, @Param("ip") String ip);

    User login2(@Param("username") String userName, @Param("password") String password, @Param("ip") byte[] ip);

    Boolean updateGroup(@Param("userId") Long userId, @Param("groupId") Long groupId);

    Boolean updateLimitedIp(@Param("userId") Long userId, @Param("ip") String ip);

    Boolean updateInfo(@Param("entity") User user);

    Long countUserLogonByUser(@Param("id") Long id);

    // limit 1000
    List<User> listAllByGroup(Long groupId);

    Object qqq(@Param("ip") byte[] ip);

    Integer qqq2(@Param("ip") byte[] ip);

    Integer qqq3(@Param("ip") byte[] ip);
}