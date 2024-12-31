package cn.test.monitorapp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author liumou
 * @since 2024-12-25
 */
@Data
@TableName("sys_dept")
public class SysDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    @TableId(value = "dept_id", type = IdType.AUTO)
    private Long departmentId;

    /**
     * 部门名称
     */
    @TableField("dept_name")
    private String name;

    /**
     * 父部门id
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 负责人id
     */
    @TableField("leader_user_id")
    private Long leaderUserId;

    /**
     * 联系电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("worker_count")
    private  Integer workerCount;
}
