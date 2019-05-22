package ro.ale.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.ale.finalproject.model.User;
import ro.ale.finalproject.service.AutoLoginService;
import ro.ale.finalproject.service.UserService;
import ro.ale.finalproject.validator.UserValidation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * User Controller handle the request for
 * login, signUp and editProfile page
 *
 *@author Alexandra Buda
 */
@Controller
public class UserController {

    @Autowired
    UserValidation userValidation;

    @Autowired
    UserService userService;

    @Autowired
    AutoLoginService autoLoginService;

    @GetMapping(path = "/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping(path = "/signUp")
    public String showSignUpPage(Model model) {
        model.addAttribute("user", new User());
        return "signUp";
    }

    /**
     * saves the user details
     *
     * @param user
     * @param bindingResult the argument used to validate the entered data
     * @return redirect to the login page
     */
    @PostMapping(path = "/signUp")
    public String saveUser(@Valid User user, BindingResult bindingResult) {
        userValidation.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "signUp";
        }
        userService.saveUser(user);
        autoLoginService.autoLogin(user.getUsername(), user.getPassword());
        return "redirect:/login";
    }

    @GetMapping("/editProfile")
    public ModelAndView showProfile() {
        ModelAndView mv = new ModelAndView("editProfile");
        String loggedInUsername = userService.findLoggedInUser();
        User user = userService.findByUsername(loggedInUsername);
        mv.addObject("user", user);
        return mv;
    }

    @PostMapping("/editProfile")
    public String editProfile(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/editProfile";
        }
        userService.saveUser(user);
        return "editProfile";
    }


    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
