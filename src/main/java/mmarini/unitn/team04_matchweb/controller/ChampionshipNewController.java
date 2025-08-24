package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.client.ChampionshipNewClient;
import mmarini.unitn.team04_matchweb.model.RestDTO.ChampionshipNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
public class ChampionshipNewController {

    private final ChampionshipNewClient championshipNewClient;

    @Autowired
    public ChampionshipNewController(ChampionshipNewClient championshipNewClient) {
        this.championshipNewClient = championshipNewClient;
    }

    @GetMapping
    public ChampionshipNew getRandomChampionshipNew() {
        return championshipNewClient.getRandomChampionshipNew();
    }
}
