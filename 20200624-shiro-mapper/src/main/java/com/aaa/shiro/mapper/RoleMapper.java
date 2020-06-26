package com.aaa.shiro.mapper;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    /**
     *根据用户名查询该用户所拥有的角色
     */
    List<String> selectRoleByUsername(String userName);
}