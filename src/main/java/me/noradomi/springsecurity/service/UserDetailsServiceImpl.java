package me.noradomi.springsecurity.service;

import me.noradomi.springsecurity.domain.Role;
import me.noradomi.springsecurity.domain.User;
import me.noradomi.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Asus on 4/24/2020.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u = userRepository.findByEmail(s);
        if(u == null){
            throw new UsernameNotFoundException("User not found");
        }

//        Nếu tìm thấy, truy xuất các quyền (GrantedAuthority) của user
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        Set<Role> roles = u.getRoles();

        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
//      Trả về 1 implementation của UserDetails : Ở đây dùng User thì khỏi tạo thêm class CustomUserDetails
        return new org.springframework.security.core.userdetails.User(s,u.getPassword(),grantedAuthorities);
    }
}
