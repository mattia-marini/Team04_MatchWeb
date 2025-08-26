package mmarini.unitn.team04_matchweb.controller;

import mmarini.unitn.team04_matchweb.client.ChampionshipNewClient;
import mmarini.unitn.team04_matchweb.model.RestDTO.ChampionshipNew;
import mmarini.unitn.team04_matchweb.service.PartiteWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
public class ChampionshipNewController {

    private final PartiteWebService partiteWebService;

    public ChampionshipNewController(PartiteWebService partiteWebService) {
        this.partiteWebService = partiteWebService;
    }

    @GetMapping
    public ChampionshipNew getRandomChampionshipNew() {
        return partiteWebService.getRandomChampionshipNew();
    }
}
