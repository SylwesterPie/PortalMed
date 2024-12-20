package pietakiewicz.sylwester.ZajavkaMed.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@AllArgsConstructor
@Controller
public class LoginController {

    private final String LOGIN = "/login";

    @RequestMapping(value = LOGIN, method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
}
