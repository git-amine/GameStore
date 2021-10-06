package com.gamestore.gamestore.webcontroller;


import com.gamestore.gamestore.entities.Jeu;
import com.gamestore.gamestore.repositories.JeuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JeuController {

    @Autowired
    JeuRepo jeuRepo;

    @GetMapping("/")
    public String index(){
        return "GameStore";
    }


    @GetMapping("/jeux")
    public String getGames(Model model){

        model.addAttribute("jeux",jeuRepo.findAll());

        return "GameStore";
    }

    @PostMapping("/New")
    public String addNewGame(Jeu jeu){

        System.out.println(jeu.toString());

        jeuRepo.save(jeu);

        return "GameForm";

    }

    @GetMapping("/New")
    public String NewGame(Jeu jeu){

        return "GameForm";

    }


}
