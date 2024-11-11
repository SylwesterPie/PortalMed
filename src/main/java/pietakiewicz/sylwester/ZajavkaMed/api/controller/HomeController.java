package pietakiewicz.sylwester.ZajavkaMed.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
public class HomeController {

    static final String HOME = "/";
    static final String OFFER = "/offer";
    static final String ABOUT_US = "/about_ud";

    @RequestMapping(value = HOME, method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }
}
