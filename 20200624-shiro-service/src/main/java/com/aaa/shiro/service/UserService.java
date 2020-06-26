package com.aaa.shiro.service;

import com.aaa.shiro.mapper.PermissionMapper;
import com.aaa.shiro.mapper.RoleMapper;
import com.aaa.shiro.mapper.UserMapper;
import com.aaa.shiro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.Yu
 * @Date: 2020/6/24 11:43
 * @description
 * @Version 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * @author  Mr.Yu
     * @message 不在云端起舞，紧贴地面行走
     * @description
     *      通过用户查询用户信息
     *      规定:
     *      所有和业务逻辑有关的代码全部写在service层，controller不能出现任何一行
     *      ，controller只负责跳转，不负责处理业务逻辑
     *      以后的所有controller返回和service返回都必须要统一
     * @param
     * @return
     */
    public Map<String, Object> selectUserByUsername(String userName){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        User user = userMapper.selectUserByUsername(userName);
        // null:防止空指针异常
        // 使用包装类型也可以防止空指针异常(Integer == 1)
        if (null != user){
            resultMap.put("code", "200");
            resultMap.put("data", user);
        }else {
            resultMap.put("code", "400");
            resultMap.put("msg", "用户不存在");
        }
        return resultMap;
    }

    /**
     * @author  Mr.Yu
     * @message 不在云端起舞，紧贴地面行走
     * @description
     *      通过用户名查询该用户所拥有的角色
     * @param
     * @return
     */
    public Map<String, Object> selectRoleByUsername(String userName){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<String> roleList = roleMapper.selectRoleByUsername(userName);
        if (roleList.size() > 0){
            // 说明该登录用户有角色
            resultMap.put("code", "200");
            resultMap.put("data", roleList);
        }else {
            resultMap.put("code", "404");
            resultMap.put("msg", "该用户没有角色");
        }
        return resultMap;
    }

    /**
     * @author  Mr.Yu
     * @message 不在云端起舞，紧贴地面行走
     * @description
     *      通过用户名查出该用户的角色所拥有的权限
     * @param
     * @return
     */
    public Map<String, Object> selectPrimissionByUsername(String userName){
        Map<String, Object> resuleMap = new HashMap<String, Object>();
        List<String> permisiionList = permissionMapper.selectPrimissionByUsername(userName);
        if (permisiionList.size() > 0){
            // 说明该用户的角色拥有权限
            resuleMap.put("code", "200");
            resuleMap.put("data", permisiionList);
        }else {
            resuleMap.put("code", "404");
            resuleMap.put("msg", "该用户所拥有的角色没有权限");
        }
        return resuleMap;
    }
}

