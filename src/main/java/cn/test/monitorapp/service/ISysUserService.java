package cn.test.monitorapp.service;

import cn.test.monitorapp.Dto.SysUserDto;
import cn.test.monitorapp.entity.SysUser;
import cn.test.monitorapp.entity.qparam.QSysUser;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liumou
 * @since 2024-12-24
 */

public interface ISysUserService extends IService<SysUser> {


    boolean editPassword(Integer userId, String password);

    @Override
    boolean save(SysUser entity);

    @Override
    boolean removeById(Serializable id);

    Page<SysUserDto> pageUser(Page page, QSysUser qSysUser);
    boolean resetPwd(Integer userId);
}
