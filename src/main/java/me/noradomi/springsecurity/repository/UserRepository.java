package me.noradomi.springsecurity.repository;

import me.noradomi.springsecurity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Asus on 4/24/2020.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
