package com.tasksmanager.forWeb;

import com.tasksmanager.TasksEntity;
import com.tasksmanager.TasksModel;
import com.tasksmanager.TasksModelDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    private TasksModelDao tasksModel = new TasksModel();

    @GetMapping(value = "/")
    public String main(Model model) {
        model.addAttribute("task", new TasksEntity());
        model.addAttribute("tasks", tasksModel.getAllTasks());
        return "tasks";
    }

    @PostMapping(value = "/")
    public String addBook(@ModelAttribute TasksEntity task) {
        //add book here
        return "redirect:/";
    }
}
