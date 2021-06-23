package com.panshi.service.impl;

import com.panshi.dao.IUserDao;
import com.panshi.service.UserService;
import com.panshi.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resources;
import java.util.List;
/**
 * @author lqp
 * @date 2021 6-20
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public List<UserVo> findUser(UserVo userVo) {
        return userDao.findUser(userVo);
    }

    @Override
    public void insertUser(UserVo userVo) {
        userDao.insertUser(userVo);
    }

    @Override
    public void delUser(int id) {
        userDao.delUser(id);
    }


}
