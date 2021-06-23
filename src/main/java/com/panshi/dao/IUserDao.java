package com.panshi.dao;

import com.panshi.vo.UserVo;

import java.util.List;

public interface IUserDao {
    List<UserVo> findUser(UserVo userVo);
    void insertUser (UserVo userVo);
    void delUser(int id);
}
