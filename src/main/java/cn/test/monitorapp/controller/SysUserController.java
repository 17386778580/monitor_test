package cn.test.monitorapp.controller;

import cn.test.monitorapp.Dto.SysUserDto;
import cn.test.monitorapp.entity.R;
import cn.test.monitorapp.entity.SysUser;
import cn.test.monitorapp.entity.qparam.QSysUser;
import cn.test.monitorapp.service.ISysUserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  前端控制器
 *
 * @author liumou
 * @since 2024-12-24
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private ISysUserService userService;
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<SysUser> getById(@PathVariable(name = "id") Integer id){
        SysUser user = userService.getById(id);
        return R.ok(user);
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping("/save")
    public R<SysUser> save(@RequestBody SysUser user){
        userService.save(user);
        return R.ok(user);
    }

    @GetMapping("/page")
    public R<Page<SysUserDto>> page(Page page, QSysUser qSysUser){
        return R.ok(userService.pageUser(page,qSysUser));
    }
    /**
     * 删除数据
     *
     * @param id 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public R<SysUser> delete(@PathVariable(name = "id") Integer id){
        SysUser user = userService.getById(id);
        userService.removeById(id);
        return R.ok(user);
    }
    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    public R<SysUser> update(@RequestBody SysUser user){
        userService.updateById(user);
        return R.ok(user);
    }
    /**
     * 修改密码
     * @param user
     * @return
     */
    @PutMapping("/editPassword")
    public R<SysUser> editPassword(@RequestBody SysUser user){
        boolean result = userService.editPassword(user.getUserId(), user.getPassword());
        if (result){
            return R.ok(user);
        }
        return R.failed("修改密码失败");
    }
    @PutMapping("/resetPwd")
    public R resetPwd(Integer userId){
        SysUser user = userService.getById(userId);
        boolean result = userService.resetPwd(user.getUserId());
        if (result){
            return R.ok(user);
        }
        return R.failed("重置密码失败");
    }


}
