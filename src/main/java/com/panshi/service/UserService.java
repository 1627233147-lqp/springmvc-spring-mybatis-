package com.panshi.service;

import com.panshi.vo.UserVo;

import java.util.List;

public interface UserService {
    List<UserVo> findUser(UserVo userVo);
    void insertUser(UserVo userVo);
    void delUser(int id);
}
