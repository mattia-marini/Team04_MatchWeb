package mmarini.unitn.team04_matchweb.service;


import mmarini.unitn.team04_matchweb.repository.UserRepository;
import mmarini.unitn.team04_matchweb.model.MyUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository repo;

    public MyUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    //private final MyUser users[] = {
    //        new MyUser("admin", "1234", UserRole.ADMIN),
    //        new MyUser("user1", "u1", UserRole.USER),
    //        new MyUser("user2", "u2", UserRole.MODERATOR)
    //};

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Searching for user");
        MyUser user = repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        System.out.println("User with pwd: <" + user.getPassword() + ">");
        //MyUser user = Arrays.stream(users).filter(u -> u.getUsername().equals(username)).findFirst().orElseThrow(() -> new UsernameNotFoundException("User not found"));


        //System.out.println(user.getRole().toString());
        return User.withUsername(user.getUsername())
                .password(user.getPassword()) // already encrypted
                .roles(user.getRole().toString())
                .build();
    }
}
