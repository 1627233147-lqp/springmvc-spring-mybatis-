package com.panshi.controller;

import com.panshi.config.SpringConfig;
import com.panshi.service.UserService;
import com.panshi.service.impl.UserServiceImpl;
import com.panshi.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * @author lqp
 * @date 2021 6-20
 * @version 1.0
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;



@RequestMapping(value = "/findUser",produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
   public List<UserVo> findUser(@RequestBody UserVo userVo, HttpServletRequest req, HttpServletResponse rep){
        List<UserVo> userVos=userService.findUser(userVo);
    System.out.println(userVos);
    return userVos;
   }
       @RequestMapping(value = "/insertUser",produces = MediaType.APPLICATION_JSON_VALUE)
       @ResponseBody
   public Boolean insertUser(@RequestBody UserVo userVo){
      if (userVo!=null){
           userService.insertUser(userVo);
         return true;
      }
      return false;
   }
@RequestMapping(value = "/delUser/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
   public Boolean delUser(@PathVariable int id){
    userService.delUser(id);
     return true;
   }
}
