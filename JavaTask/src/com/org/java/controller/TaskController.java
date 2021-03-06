package com.org.java.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.java.bean.Task;
import com.org.java.bo.TaskBO;
import com.org.java.util.mail.Sendingmail;


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
		Task task2=new Task();
		task.setId(Integer.parseInt(id));
		try {
			 task2=taskBO.getTaskById(task);
			 model.addAttribute("task", task2);
			// System.out.println("Task : "+task2.getObjectiveOfTheTask()+" "+task2.getStartTime()+" "+task2.getEndTime()+" "+task2.getStatus()+" "+task2.getTaskDate()+" "+task2.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
			return new ModelAndView("edit");
		
	}
	
	@RequestMapping("updateTask")
	public ModelAndView updateTask(Model model,@RequestParam("id") String id,@RequestParam("stime") String stime,@RequestParam("etime") String etime,@RequestParam("objective") String objective,@RequestParam("status") String status,@RequestParam("date") String date,HttpSession session) {
		String returnMessage=null;
		Task task=new Task(date, stime, etime, objective, status);
		task.setId(Integer.parseInt(id));
		try {
			returnMessage=taskBO.updateTask(task);
		} catch (Exception e) {
			e.printStackTrace();
		}
			if(returnMessage.equals("SUCCESS")) {
				if(task.getStatus().equalsIgnoreCase("completed")) {
					String messageMail="Hi,\n\n Your task with objective \""+task.getObjectiveOfTheTask()+"\" has been completed.\n\n thank you,";
					Sendingmail.sendMail((String)session.getAttribute("email"), messageMail);
					model.addAttribute("message", "Task Updated and mail has been sent");
				}else {
					model.addAttribute("message", "Task Updated");
				}
				List<Task> l=taskBO.getAllTask();
				ArrayList<Task> al=new ArrayList<>();
				for (Task task2 : l) {
					al.add(task2);
				}
				model.addAttribute("l", al);
			return new ModelAndView("index");
			}else{
				model.addAttribute("message", "Task Update failed try again");
				return new ModelAndView("index");
			}
	}
	
	@RequestMapping("deleteTask")
	public ModelAndView deleteTask(Model model,@RequestParam("id") String id) {
		String returnMessage=null;
		Task task=new Task();
		task.setId(Integer.parseInt(id));
		try {
			returnMessage=taskBO.deleteTask(task);
			System.out.println(returnMessage+" rs");
		} catch (Exception e) {
			e.printStackTrace();
		}
			if(returnMessage.equals("SUCCESS")) {
				List<Task> l=taskBO.getAllTask();
				ArrayList<Task> al=new ArrayList<>();
				for (Task task2 : l) {
					al.add(task2);
				}
				model.addAttribute("l", al);
				model.addAttribute("message", "Task Deleted");
			return new ModelAndView("index");
			}else{
				List<Task> l=taskBO.getAllTask();
				ArrayList<Task> al=new ArrayList<>();
				for (Task task2 : l) {
					al.add(task2);
				}
				model.addAttribute("l", al);
				model.addAttribute("message", "Can not delete completed tasks");
				return new ModelAndView("index");
			}
	}
	
	@RequestMapping("searchTask")
	public ModelAndView searchTask(Model model,@RequestParam("q") String q) {
		//String returnMessage=null;
		Task task=new Task();
		Task task2=new Task();
		task.setObjectiveOfTheTask(q);
		try {
			task2=taskBO.getTaskByObjective(task);
			//System.out.println(returnMessage+" rs");
		} catch (Exception e) {
			e.printStackTrace();
		}
				model.addAttribute("l", task2);
			return new ModelAndView("index");
	}
	
}
