package com.org.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.java.bean.Task;
import com.org.java.bo.TaskBO;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TaskController {
	
	private TaskBO taskBO;
    
	public void setTaskBO(TaskBO taskBO) {
		this.taskBO = taskBO;
	}

	@RequestMapping("addTask")
	public ModelAndView addTask(@ModelAttribute("task") Task task,Model model) {
		String returnString=null;
		String message=null;
		try {
			 returnString=taskBO.addNewTask(task);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(returnString.equals("SUCCESS")) {
			message="New task is created";
		}else {
			message="Failed to create new task please try again later";
		}
		model.addAttribute("message", message);
		return new ModelAndView("index","command",new Task());
	}
	
}
