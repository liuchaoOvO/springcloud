package lc.controller;

/**
 * @author liuchaoOvO on 2019/3/15
 */

import com.lc.entity.SysUser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public boolean addUser(@RequestBody SysUser user){
        boolean flag = service.addUser(user);
        return flag;
    }

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod="hystrixGetUser") //一旦服务调用失败，就调用hystrixGetUser方法
    public SysUser getUser(@PathVariable("id") int id){
        SysUser user = service.getUser(id);
        if(user == null){
            throw new RuntimeException("不存在id=" + id + "对应的用户信息");
        }
        System.out.println("microservice-provider微服务在响应客户端请求……");
        System.out.println("user : " + user);
        return user;
    }

    @RequestMapping(value="/getUser/list", method=RequestMethod.GET)
    public List<SysUser> getUsers(){
        List<SysUser> users = service.getUsers();
        return users;
    }

    // 服务调用失败 请求结果找不到时，执行
    public SysUser hystrixGetUser(@PathVariable("id") int id){
        SysUser user = new SysUser(id, "hystrixGetUser==不存在该用户", "0");
        return user;
    }
}
