package com.tasksmanager.forWeb;

import com.tasksmanager.TasksEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {
    @GetMapping(value = "/")
    public ModelAndView main() {
        return new ModelAndView("tasks", "task", new TasksEntity());
    }

    @PostMapping(value = "/")
    public String addBook(@ModelAttribute TasksEntity task) {
        //add book here
        return "redirect:/";
    }
}
