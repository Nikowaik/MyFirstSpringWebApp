package firstwebjavaproject.javawebproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamController {
    @Autowired
    @GetMapping("/teams.html")
    public String viewTeamsPage()
    {
        return "teams";
    }
}
