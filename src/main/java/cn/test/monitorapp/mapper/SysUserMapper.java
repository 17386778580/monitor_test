package cn.test.monitorapp.mapper;

import cn.test.monitorapp.Dto.SysUserDto;
import cn.test.monitorapp.entity.SysUser;
import cn.test.monitorapp.entity.qparam.QSysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liumou
 * @since 2024-12-24
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    @Update("update sys_user set password = #{password} where user_id = #{userId}")
    int updatePassword(@Param("userId") Integer userId, @Param("password") String password);

    Page<SysUserDto> pageUser(Page page, @Param("param") QSysUser qSysUser);

    @Update("update sys_user set password = #{pwd} where user_id = #{userId}")
    int resetPwd(Integer userId, String pwd);
}
