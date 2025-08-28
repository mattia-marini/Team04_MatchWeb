package mmarini.unitn.team04_matchweb.client;


import mmarini.unitn.team04_matchweb.model.dto.rest.ChampionshipNew;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "championshipNewClient", url = "${api.base.url}")
public interface ChampionshipNewClient {
    @GetMapping("/api/news")
    ChampionshipNew getRandomChampionshipNew();
}
