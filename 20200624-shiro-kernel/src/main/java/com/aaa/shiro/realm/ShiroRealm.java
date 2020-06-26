package com.aaa.shiro.realm;

import com.aaa.shiro.model.User;
import com.aaa.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Map;


/**
 * @Author: Mr.Yu
 * @Date: 2020/6/24 12:16
 * @description
 * @Version 1.0
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * @author  Mr.Yu
     * @message 不在云端起舞，紧贴地面行走
     * @description
     *      认证方法
     * @param
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取用户名
        String userName = (String) authenticationToken.getPrincipal();
        //.从数据库中查询该用户是否存在，如果不存在直接抛出异常
        Map<String, Object> resultMap = userService.selectUserByUsername(userName);
        if ("400".equals((String) resultMap.get("code"))){
            // 说明数据库中没有数据
            throw new UnknownAccountException("用户不存在");
        }
        // 3.判断密码是否正确(需要创建SimpleAuthenticationInfo对象)
        /**
         * 第一个参数:用户名/用户对象(从页面上获取的username，还有一个是从数据库中查询出来的用户对象)
         *              要求必须要传从数据库中查询出来的对象
         * 第二个参数:密码
         *          必须是从数据库中查询出的密码
         *          shiro已经获取到从页面上传递的密码了，需要和数据库中密码进行匹配
         * 第三个参数:盐值
         *      参数类型为ByteSource
         * 第四个参数:传递自己通过class.forName获取类的对象信息
         */
        User user = (User) resultMap.get("data");
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
        // 4.返回SimpleAuthenticationInfo对象
        return info;
    }

    /**
     * @author  Mr.Yu
     * @message 不在云端起舞，紧贴地面行走
     * @description
     *      授权方法
     *           授权方法是和角色和权限有关
     *           shiro必须要获取到当前登录用户的角色信息以及权限信息
     *           可以用户获取角色
     *          角色对应又是权限
     * @param
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 1.获取用户名/用户信息
        // 根据认证方法的第一个参数决定
        // 如果在认证方法的第一个参数传递的是user对象getPrimaryPrincipal()获取的就是对象
        // ，如果传的是用户名获取的就是用户名
        String userName = (String) principalCollection.getPrimaryPrincipal();
        // 2.通过用户名查询角色信息
        Map<String, Object> roleResultMap = userService.selectRoleByUsername(userName);
        // 3.创建SimpleAuthorizationInfo对象，不要初始化
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if ("200".equals((String) roleResultMap.get("code")) && null != roleResultMap.get("data")){
            //该用户有角色
            info.addRoles((List<String>) roleResultMap.get("data"));
        }
        Map<String, Object> primission = userService.selectPrimissionByUsername(userName);
        if ("200".equals((String) roleResultMap.get("code")) && null != primission.get("data")){
            info.addStringPermissions((List<String>) primission.get("data"));
        }
        // 4.返回SimpleAuthorizationInfo对象
        /**
         * 用户和角色是多对多的关系
         *      user:
         *          id
         *          username
         *          password
         *          salt
         *
         *     role:
         *          id
         *          role_name:角色名称(book_manager)
         *          role_chinese_name:角色中文名称(图书管理员)
         *
         *     user_role:
         *          关联表中不要出现主键(inner join)
         *              阿里巴巴代码规约明确表示一个sql中最多只能出现两次join
         *          user_id
         *          role_id
         *
         *          select * from book
         *          book表中：
         *              5个字段
         *          book表中：
         *              6个字段
         *
         *     permission:
         *          id
         *          permission_name
         *          permission_chinese_name
         *
         *     role_permission
         *          role_id
         *          permission_id
         */
        return info;
    }
}

