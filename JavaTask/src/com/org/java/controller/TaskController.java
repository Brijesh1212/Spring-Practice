package com.org.java.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.java.bean.Task;
import com.org.java.bo.TaskBO;


@Controller
public class TaskController {
	
	private TaskBO taskBO;
    
	public void setTaskBO(TaskBO taskBO) {
		this.taskBO = taskBO;
	}

	@RequestMapping("addTask")
	public ModelAndView addTask(@RequestParam("stime") String startTime,@RequestParam("etime") String endTime,@RequestParam("date") String date,@RequestParam("objective") String objective ,Model model) {
		//SimpleDateFormat sdf=new SimpleDateFormat("HH:mm a");
		Task task=new Task(date, startTime, endTime, objective, "new");
		String returnString=null;
		String message=null;
		System.out.println("in add task");
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
		List<Task> l=taskBO.getAllTask();
		ArrayList<Task> al=new ArrayList<>();
		for (Task task2 : l) {
			al.add(task2);
		}
		model.addAttribute("l", al);
		model.addAttribute("message", message);
		return new ModelAndView("index","command",new Task());
	}
	
	@RequestMapping("getTask")
	public ModelAndView getTask(Model model) {
		//SimpleDateFormat sdf=new SimpleDateFormat("HH:mm a");
		List<Task> l=null;
		String message=null;
		//System.out.println("in add task");
		try {
			 l=taskBO.getAllTask();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(l.isEmpty()) {
			model.addAttribute("message", "No tasks available please add task");
			return new ModelAndView("index");
		}else {
			model.addAttribute("list", l);
			return new ModelAndView("index");
		}
		
	}
	
	@RequestMapping("editTask")
	public ModelAndView editTask(Model model,@RequestParam("id") String id) {
		//SimpleDateFormat sdf=new SimpleDateFormat("HH:mm a");
		//List<Task> l=null;
		//String message=null;
		//System.out.println("in add task");
		Task task=new Task();
		Task task2=null;
		task.setId(Integer.parseInt(id));
		try {
			 task2=taskBO.getTaskById(task);
		} catch (Exception e) {
			e.printStackTrace();
		}
			model.addAttribute("id", task2.getId());
			model.addAttribute("stime", task2.getStartTime());
			model.addAttribute("etime", task2.getEndTime());
			model.addAttribute("obj", task2.getObjectiveOfTheTask());
			model.addAttribute("st", task2.getStatus());
			model.addAttribute("d", task2.getTaskDate());
			return new ModelAndView("edit");
		
	}
}
