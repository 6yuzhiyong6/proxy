package com.aaa.shiro.model;


import java.io.Serializable;

public class Role implements Serializable {

    private Long id;


    private String roleName;


    private String roleChineseName;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * @return role_chinese_name
     */
    public String getRoleChineseName() {
        return roleChineseName;
    }

    /**
     * @param roleChineseName
     */
    public void setRoleChineseName(String roleChineseName) {
        this.roleChineseName = roleChineseName == null ? null : roleChineseName.trim();
    }
}