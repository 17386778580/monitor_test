package cn.test.monitorapp.entity.qparam;

import lombok.Data;

@Data
public class QSysUser {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 部门id
     */
    private Integer departmentId;
    /**
     * 角色id
     */
    private Integer roleId;
}
