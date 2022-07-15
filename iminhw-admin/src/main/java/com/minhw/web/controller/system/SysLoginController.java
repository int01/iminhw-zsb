package com.minhw.web.controller.system;

import com.minhw.common.constant.Constants;
import com.minhw.common.core.domain.AjaxResult;
import com.minhw.common.core.domain.entity.SysMenu;
import com.minhw.common.core.domain.entity.SysUser;
import com.minhw.common.core.domain.model.LoginBody;
import com.minhw.common.core.domain.model.LoginUser;
import com.minhw.common.utils.SecurityUtils;
import com.minhw.framework.web.service.SysLoginService;
import com.minhw.framework.web.service.SysPermissionService;
import com.minhw.system.service.ISysConfigService;
import com.minhw.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

import static com.minhw.common.core.domain.AjaxResult.error;

/**
 * 登录验证
 *
 * @author minhw
 */
@RestController
public class SysLoginController {
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private ISysConfigService configService;

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
//        if (!("true".equals(configService.selectConfigByKey("sys.login:restriction")))) {
////            LoginUser user = redisCache.getCacheObject(key);
//            return error("当前系统没有开启注册功能！");
//        }
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo() {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters() {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}
