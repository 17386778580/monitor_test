package cn.test.monitorapp.service.impl;

import cn.test.monitorapp.Dto.SysUserDto;
import cn.test.monitorapp.entity.SysUser;
import cn.test.monitorapp.entity.qparam.QSysUser;
import cn.test.monitorapp.mapper.SysDepartmentMapper;
import cn.test.monitorapp.mapper.SysUserMapper;
import cn.test.monitorapp.service.ISysUserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liumou
 * @since 2024-12-24
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;
    @Override
    @Transactional
    public boolean save(SysUser entity) {
        boolean result = super.save(entity);
        if (result) {
            sysDepartmentMapper.updateWorkerCount(entity.getDepartmentId(), 1);
        }
        return result;
    }

    @Override
    public boolean removeById(Serializable id) {
        SysUser user = getById(id);
        boolean result = super.removeById(id);
        if (result) {
            sysDepartmentMapper.updateWorkerCount(user.getDepartmentId(), -1);
        }
        return result;

    }

    @Override
    public Page<SysUserDto> pageUser(Page page, QSysUser qSysUser) {
        return baseMapper.pageUser(page, qSysUser);
    }

    private static final PasswordEncoder Encoder = new BCryptPasswordEncoder();
    @Override
    public boolean resetPwd(Integer userId) {
        String pwd = Encoder.encode("123456");
        return baseMapper.resetPwd(userId, pwd) > 0;
    }

    @Override
    public boolean editPassword(Integer userId, String password) {
        return baseMapper.updatePassword(userId, password) > 0;
    }
}
