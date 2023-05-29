package firstwebjavaproject.javawebproject.controller;

import firstwebjavaproject.javawebproject.model.Award;
import firstwebjavaproject.javawebproject.services.AwardService;
import firstwebjavaproject.javawebproject.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AwardController {

//    @Autowired
//    private AwardService awardService;
//
//    @Autowired
//    private PlayerService playerService;
//
//    @GetMapping("/create")
//    public String createAwardForm(Model model) {
//        model.addAttribute("award", new Award());
//        model.addAttribute("players", playerService.());
//        return "award-form";
//    }
//
//    @PostMapping("/create")
//    public String createAward(@ModelAttribute("award") Award award) {
//        awardService.save(award);
//        return "redirect:/awards";
//    }
}
