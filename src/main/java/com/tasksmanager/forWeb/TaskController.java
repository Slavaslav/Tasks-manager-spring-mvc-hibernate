package com.tasksmanager.forWeb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {
    @RequestMapping(value = "/")
    public ModelAndView main() {
        return new ModelAndView("tasks");
    }

    @RequestMapping(value = "/login")
    public ModelAndView test1() {
        return new ModelAndView("login");
    }
}
