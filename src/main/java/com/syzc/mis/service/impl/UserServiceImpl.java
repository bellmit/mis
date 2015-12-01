package com.syzc.mis.service.impl;

import com.syzc.mis.dao.mysql.BaseDao;
import com.syzc.mis.dao.mysql.UserDao;
import com.syzc.mis.entity.User;
import com.syzc.mis.service.UserService;
import com.syzc.util.LocalAcUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserDao> implements UserService {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    private UserDao userDao;

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public BaseDao<User> getDao() {
        return this.userDao;
    }

    @Override
    public User add(User user) {
/*
        if (userDao.existUsername(user.getUsername())) {
            return null;
        }
*/
        if (!userDao.add(user)) {
            return null;
        }
        user = userDao.get(user.getId());
        return user;
    }

/*
    @Override
    public Boolean remove(Long id) {
        return userDao.remove(id);
    }
*/

/*
    @Override
    public Boolean update(User user) {
        return userDao.update(user);
    }
*/

/*
    @Override
    public User get(Long userId) {
        return userDao.get(userId);
    }
*/

    /*
        @Override
        public Page<User> list(Long pageNo, Byte size) {
            Long total = userDao.count();
            Page<User> page = PageUtil.make(pageNo, size, total);
            page.setList(userDao.list(page.getRowOffset(), page.getPageSize()));
            return page;
        }
    */

    @Override
    public Boolean updateInfo(User user) {
        return userDao.updateInfo(user);
    }

    @Override
    public Boolean updatePassword(Long userId, String oldPassword, String newPassword) {
        return userDao.updatePassword(userId, oldPassword, newPassword);
    }

    @Override
    public Boolean updateResetPassword(Long userId, String newPassword) {
        return userDao.updateResetPassword(userId, newPassword);
    }

    public Boolean exist(String username) {
        return userDao.existUsername(username);
    }

    @Override
    public User login(String userName, String password, String ip) {
        return userDao.login(userName, password, ip);
    }

    public static void main(String[] args) {
        ApplicationContext ac;
        ac = LocalAcUtil.getAc();
        UserService s = (UserService) ac.getBean("userService");
        System.out.println(s);
//        System.out.println(JSON.toJSONString(s.login("abc2", "abc2"), true));
//        System.out.println(JSON.toJSONString(s.get(3L), true));

//        System.out.println(JSON.toJSONString(s.list(0L, (byte) 10), true));
//        System.out.println(JSON.toJSONString(s.listByGroup(1L, 0L, (byte) 10), true));

//        System.out.println(JSON.toJSONString(s.listByRole(Role.DIRECTOR, 1L, (byte) 10)));
    }
}