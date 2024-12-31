package cn.test.monitorapp.utils;


import cn.test.monitorapp.entity.SecurityUserDetails;
import cn.test.monitorapp.entity.SysUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 安全工具类
 */
@UtilityClass
public class SecurityUtils {
    /**
     * 获取Authentication
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     * @param authentication
     */
    public SysUser getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof SecurityUserDetails) {
            return ((SecurityUserDetails) principal).getUser();
        }
        return null;
    }

    /**
     * 获取用户
     */
    public SysUser getUser() {
        Authentication authentication = getAuthentication();
        return getUser(authentication);
    }

}
