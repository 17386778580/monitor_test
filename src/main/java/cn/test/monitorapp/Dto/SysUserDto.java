package cn.test.monitorapp.Dto;


import cn.test.monitorapp.entity.SysUser;
import lombok.Data;

@Data
public class SysUserDto extends SysUser {
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 角色名称
     */
    private String roleName;

}
