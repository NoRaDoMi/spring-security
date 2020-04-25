package me.noradomi.springsecurity.repository;

import me.noradomi.springsecurity.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Asus on 4/24/2020.
 */
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
