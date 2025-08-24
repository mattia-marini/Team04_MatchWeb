package mmarini.unitn.team04_matchweb.service;

import mmarini.unitn.team04_matchweb.model.Prize;
import mmarini.unitn.team04_matchweb.repository.PrizeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class PrizeService {

    private final PrizeRepository prizeRepository;

    public PrizeService(PrizeRepository prizeRepository) {
        this.prizeRepository = prizeRepository;
    }

    @Transactional
    public void assignAwards(List<String> usernames, List<String> awards) {
        if (usernames.size() != awards.size()) {
            throw new IllegalArgumentException("Usernames and awards must have the same size");
        }

        for (int i = 0; i < usernames.size(); i++) {
            Prize prize = new Prize(
                    usernames.get(i),
                    awards.get(i),
                    LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)
            );
            prizeRepository.save(prize);
        }
    }

}
