package com.euphoria.shop.security.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import java.util.Collection;

/**
 * @author: Euphoria
 * @description: 手机号登录token
 * @date: 2022/9/9 21:17
 */

@Setter
@Getter
public class MobileCodeLoginToken extends AbstractAuthenticationToken {
    private static final long serialVersionUID = 560L;
    private Object principal;
    private Object credentials;

    public MobileCodeLoginToken(Object mobile, Object code) {
        super(null);
        this.principal = mobile;
        this.credentials = code;
        this.setAuthenticated(false);
    }

    public MobileCodeLoginToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true);
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        Assert. isTrue(!isAuthenticated, "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        super.setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}
