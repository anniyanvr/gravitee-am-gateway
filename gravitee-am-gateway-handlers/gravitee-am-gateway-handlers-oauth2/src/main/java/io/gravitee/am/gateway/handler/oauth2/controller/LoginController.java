package io.gravitee.am.gateway.handler.oauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }
}
