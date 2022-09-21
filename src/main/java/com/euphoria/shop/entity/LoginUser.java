package com.euphoria.shop.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @package: com.euphoria.shop.entity
 * @className: LoginUser
 * @author: Euphoria
 * @description: 实现UserDetails
 * @date: 2022/8/6 10:45
 */
@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {

    private User user;
    private List<String> permissions;

    @JSONField(serialize = false)
    private List<SimpleGrantedAuthority> authorities;

    public LoginUser(User user,List<String> list){
        this.user =user;
        this.permissions = list;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(authorities !=null){
            return authorities;
        }
        List<SimpleGrantedAuthority> newList = permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return newList;
    }

    @Override
    public String getPassword() {
        return user.getUserPwd();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
