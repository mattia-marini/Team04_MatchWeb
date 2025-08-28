package mmarini.unitn.team04_matchweb.service;

import mmarini.unitn.team04_matchweb.model.entity.Authority;
import mmarini.unitn.team04_matchweb.model.entity.UserDetailsExtra;
import mmarini.unitn.team04_matchweb.repository.AuthorityRepository;
import mmarini.unitn.team04_matchweb.repository.UserDetailsExtraRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    AuthorityRepository authorityRepository;
    UserDetailsExtraRepository userDetailsExtraRepository;
    BetService betService;

    public UserService(AuthorityRepository authorityRepository, UserDetailsExtraRepository userDetailsExtraRepository, BetService betService) {
        this.authorityRepository = authorityRepository;
        this.userDetailsExtraRepository = userDetailsExtraRepository;
        this.betService = betService;
    }

    public Map<String, String> getAuthorityMap() {
        List<Authority> authorities = authorityRepository.findAll();
        Map<String, String> authoritiesMap = new LinkedHashMap<>();
        authorities.forEach(authority -> {
            authoritiesMap.put(authority.getUsername(), authority.getAuthority());
        });
        return authoritiesMap;
    }

    public Map<String, Long> getTotalScorePerUser() {
        return betService.getTotalScorePerUserMap();
    }

    public List<UserDetailsExtra> getAllUsernameAsc() {
        return userDetailsExtraRepository.findAllByOrderByUsernameAsc();
    }

    public Optional<UserDetailsExtra> getUserDetailsExtraByUsername(String username) {
        return userDetailsExtraRepository.getUserDetailsExtraByUsername(username);
    }

    public boolean updateUsersRole(String newRole, List<String> usernames) {
        Map<String, String> authMap = this.getAuthorityMap();
        for (String username : usernames) {
            String authority = authMap.get(username);
            if (authority == null || authority.equals("ROLE_ADMIN")) return false;
        }
        authorityRepository.updateRolesForUsers(newRole, usernames);
        return true;
    }

}
