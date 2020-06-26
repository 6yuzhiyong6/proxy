package com.aaa.shiro.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper  {

    /**
     通过用户名查出该用户的角色所拥有的权限
     */
    List<String> selectPrimissionByUsername(String userName);
}