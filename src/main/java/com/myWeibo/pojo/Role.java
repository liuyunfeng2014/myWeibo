package com.myWeibo.pojo;

/**
 * 角色模型
 * 
 * @author StarZou
 * @since 2014年7月17日 下午1:02:25
 **/
public class Role {
    private int roleId;

    private String roleName;

    private String roleSign;

    private String description;



	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleSign() {
        return roleSign;
    }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign == null ? null : roleSign.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        return "Role [id=" + roleId + ", roleName=" + roleName + ", roleSign=" + roleSign + ", description=" + description + "]";
    }

}