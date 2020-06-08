package io.matovic;

import io.matovic.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@ControllerAdvice
public class Common {

    @Autowired
    private UserRepository userRepository;

    @ModelAttribute
    public void sharedDate(HttpSession httpSession, Model model, Principal principal){

        if(principal != null){
            model.addAttribute("userNotLoggedIn", principal.getName());    // uzimamo ime ulogovanog usera
        }
    }
}
