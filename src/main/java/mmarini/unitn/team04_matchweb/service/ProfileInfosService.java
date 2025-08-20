package mmarini.unitn.team04_matchweb.service;

import mmarini.unitn.team04_matchweb.model.ProfileStats;
import mmarini.unitn.team04_matchweb.model.UserDetailsExtra;
import mmarini.unitn.team04_matchweb.repository.BetRepository;
import mmarini.unitn.team04_matchweb.repository.PrizeRepository;
import mmarini.unitn.team04_matchweb.repository.UserDetailsExtraRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileInfosService {

    private final JdbcTemplate jdbcTemplate;
    private final UserDetailsExtraRepository userDetailsExtraRepository;
    private final BetRepository betRepository;
    private final PrizeRepository prizeRepository;


    public ProfileInfosService(JdbcTemplate jdbcTemplate, BetRepository betRepository, UserDetailsExtraRepository userDetailsExtraRepository, PrizeRepository prizeRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.betRepository = betRepository;
        this.userDetailsExtraRepository = userDetailsExtraRepository;
        this.prizeRepository = prizeRepository;
    }


    public ProfileStats getProfileStats(String username) {
        ProfileStats profileStats = new ProfileStats();
        List<Object[]> ranking = betRepository.getRanking();

        int index = -2;
        for (int i = 0; i < ranking.size(); i++) {
            String curr_username = (String) ranking.get(i)[0];
            if (curr_username.equals(username)) {
                index = i;
                break;
            }
        }
        index++;

        profileStats.setRankingPosition(index);
        profileStats.setTotalBets(betRepository.getTotalBets(username));
        profileStats.setPointsToday(betRepository.getPointsToday(username));
        profileStats.setPrizes(prizeRepository.getPrizesByUsername(username));

        return profileStats;
    }


    public UserDetailsExtra getUserDetailsExtra(String username) {
        return userDetailsExtraRepository
                .getUserDetailsExtraByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

}
