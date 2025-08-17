/*
package mmarini.unitn.team04_matchweb.repository;

import mmarini.unitn.team04_matchweb.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByUsername(String username);
}



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository<User> extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

public interface AuthoritiesRepository extends JpaRepository<Authority, Long> {
    List<Authorities> findByUserId(Long userId);
}
 */
