package guru.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by @author Kalmaasali on 25/04/2020.
 **/
@Controller
public class indexController {

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){
        System.out.println("hi hi hi hi");
        return "index";
    }
}
