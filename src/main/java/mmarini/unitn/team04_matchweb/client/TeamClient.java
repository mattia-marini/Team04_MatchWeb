package mmarini.unitn.team04_matchweb.client;

import mmarini.unitn.team04_matchweb.model.RestDTO.Team;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "teamClient", url = "${api.base.url}")
public interface TeamClient {
    @GetMapping("/api/teams")
    List<Team> getAllTeams();
}