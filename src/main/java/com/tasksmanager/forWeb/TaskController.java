package com.tasksmanager.forWeb;

import com.tasksmanager.TasksEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {
    @RequestMapping(value = "/")
    public ModelAndView main() {
        return new ModelAndView("tasks");
    }

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("login", "task", new TasksEntity());
    }

    @RequestMapping(value = "/login-result")
    public ModelAndView loginResult(@ModelAttribute("task") TasksEntity task) {
        return new ModelAndView("login-result", "task", task);
    }
}
