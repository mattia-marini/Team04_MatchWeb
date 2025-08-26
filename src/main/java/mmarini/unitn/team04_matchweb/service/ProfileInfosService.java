package mmarini.unitn.team04_matchweb.service;

import mmarini.unitn.team04_matchweb.model.ProfileStats;
import mmarini.unitn.team04_matchweb.model.UserDetailsExtra;
import mmarini.unitn.team04_matchweb.repository.BetRepository;
import mmarini.unitn.team04_matchweb.repository.PrizeRepository;
import mmarini.unitn.team04_matchweb.repository.UserDetailsExtraRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.data.util.Pair;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProfileInfosService {

    private final JdbcTemplate jdbcTemplate;
    private final UserDetailsExtraRepository userDetailsExtraRepository;
    private final BetService betService;
    private final PrizeRepository prizeRepository;

    public ProfileInfosService(JdbcTemplate jdbcTemplate, UserDetailsExtraRepository userDetailsExtraRepository, BetService betService, PrizeRepository prizeRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDetailsExtraRepository = userDetailsExtraRepository;
        this.betService = betService;
        this.prizeRepository = prizeRepository;
    }

    public ProfileStats getProfileStats(String username) {
        ProfileStats profileStats = new ProfileStats();
        List<Pair<String, Long>> ranking = betService.getRanking();

        int index = -2;
        for (int i = 0; i < ranking.size(); i++) {
            String curr_username = ranking.get(i).getFirst();
            if (curr_username.equals(username)) {
                index = i;
                break;
            }
        }
        index++;

        profileStats.setRankingPosition(index);
        profileStats.setTotalBets(betService.getTotalBets(username));
        profileStats.setPointsToday(betService.getUserPointsByDate(username, LocalDate.now()));
        profileStats.setPrizes(prizeRepository.getPrizesByUsername(username));

        return profileStats;
    }


    public UserDetailsExtra getUserDetailsExtra(String username) {
        return userDetailsExtraRepository
                .getUserDetailsExtraByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

}
