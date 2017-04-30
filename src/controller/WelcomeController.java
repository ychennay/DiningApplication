package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.GenericWelcomeService;
import service.WelcomeService;

import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    private GenericWelcomeService welcomeService;

    // this maps to http://localhost:8080/dining/
    @RequestMapping("/")
    public String doWelcome(Model model){

        List<String> welcomeMessage = welcomeService.getWelcomeMessage("Yu Chen");

        model.addAttribute("myWelcomeMessage", welcomeMessage);

        return "welcomeNew";
        // this returns the context data to welcomeNew.jsp using the view resolver
        // /WEB-INF/views/welcomeNew.jsp

    }


}
