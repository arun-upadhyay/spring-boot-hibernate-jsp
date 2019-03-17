package com.example.demo;

import com.example.demo.service.UserService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("user", new User());
        List<User> listUser = userService.getUsers();
        model.addAttribute("users", listUser);
        return "index";
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getSingleUser(@PathVariable("id") String id, Model model) {
        List<User> listUser = userService.findUserById(id);
        model.addAttribute("users", listUser);
        return "index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") String id, Model model) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable("id") String id, Model model) {
        User u = userService.editUserById(id);
        model.addAttribute("user", u);
        return "index";
    }

    @RequestMapping(value = "/user-add", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user, Model model) {
        User obj = null;
        List<User> listUser = userService.getUsers();
        for(User u : listUser){
            if(user.getId() == u.getId()){
                obj = user; break;
            }
        }
        if(obj == null){
            obj = user;
        }
        userService.saveUser(user);
        return "redirect:/";
    }


}
