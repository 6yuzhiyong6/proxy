package com.aaa.shiro.model;


import java.io.Serializable;

public class Permission implements Serializable {

    private Long id;


    private String permissionName;


    private String permissionChineseName;

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
     * @return permission_name
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * @param permissionName
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    /**
     * @return permission_chinese_name
     */
    public String getPermissionChineseName() {
        return permissionChineseName;
    }

    /**
     * @param permissionChineseName
     */
    public void setPermissionChineseName(String permissionChineseName) {
        this.permissionChineseName = permissionChineseName == null ? null : permissionChineseName.trim();
    }
}