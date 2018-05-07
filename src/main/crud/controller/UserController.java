package main.crud.controller;

import main.crud.model.User;
import main.crud.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {

    private final DBService dbService;

    @Autowired
    public UserController(DBService dbService) {
        this.dbService = dbService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String listUser(Model model, HttpServletRequest req){

        model.addAttribute("userLists", dbService.listUser());

        return "admin";
    }

    @RequestMapping("/admin/{error}")
    public String listUser(Model model, @PathVariable("error") String error, HttpServletRequest req){

        model.addAttribute("error", "Введите все параметры!");
        model.addAttribute("userLists", dbService.listUser());

        return "admin";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Model model, HttpServletRequest req){

        return "user";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(Model model, HttpServletRequest req){

        return "error";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, HttpServletRequest req){

        dbService.addUser(user);

        return "redirect:/admin";
    }

    @RequestMapping("admin/delete/{id}")
    public String removeUser(@PathVariable("id") int id, HttpServletRequest req) {

        dbService.removeUser(id);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, Model model) {

        return "login";
    }


    @RequestMapping(value = "admin/update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model, HttpServletRequest req) {

        User userdb = dbService.getUser(id);

        model.addAttribute("user", userdb);

        return "update";
    }

    @RequestMapping(value = "/updateuser/{id}", method = RequestMethod.POST)
    public String loginUser(@ModelAttribute("user") User user, @PathVariable("id") int id, HttpServletRequest request) {

        User userdb = dbService.getUser(id);

        if (userdb != null || userdb.validParametrs()) {
            userdb.setName(user.getName());
            userdb.setPassword(user.getPassword());
            userdb.setEmail(user.getEmail());
            userdb.setRole(user.getRole());
            dbService.udpateUser(userdb);
        }

        return "redirect:/admin";
    }

}
