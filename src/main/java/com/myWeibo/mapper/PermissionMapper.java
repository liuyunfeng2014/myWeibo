package com.myWeibo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.myWeibo.pojo.Permission;


/**
 * 权限 Dao 接口
 * 
 * @author StarZou
 * @since 2014年7月5日 上午11:59:03
 **/
public interface PermissionMapper  {

    /**
     * 通过角色id 查询角色 拥有的权限
     * 
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionsByRoleId(int roleId);
}