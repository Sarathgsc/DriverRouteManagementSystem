package com.amdocs2.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.amdocs2.entity.DriverEntity;
import com.amdocs2.service.impl.DriverServiceImpl;


@Controller
public class DriverController {
	
	
	private DriverServiceImpl dvrService;
	
	
	@Autowired
	public DriverController(DriverServiceImpl dvrService) {
		//super();
		this.dvrService = dvrService;
	}
	@RequestMapping("/")
	public String mainload() {
		return "Main";
	}
	@RequestMapping("/start")
	public String loadForm(Model model) {
		DriverEntity dvr=new DriverEntity();
		model.addAttribute("dvr",dvr);
		return "adddriver";
	}
	@RequestMapping("/insert")
	public String handleDvrForm(@ModelAttribute("dvr")DriverEntity dvr,Model model)
	{
		// this to intract to service layer
		boolean registerDriver = dvrService.registerDriver(dvr);
		
		String msg="";
		
		if(registerDriver)
			msg="Data Inserted SuccessFully";
		else
			msg="Data Not Inserted SuccessFully";
		
		model.addAttribute("msg", msg);
		return "adddriver";
	}
	@RequestMapping("/viewAll")
	public String viewAllDrivers(Model model) {
		List<DriverEntity> allDrivers = dvrService.getAllDrivers();
		
		model.addAttribute("driver",allDrivers);
		return "views";
	
	}
	
	@RequestMapping("/deleteDvr")
	public String deleteDriver(@RequestParam("did") int id) {
		boolean flag = dvrService.deleteDriver(id);
		if(flag)
			return "redirect:/viewAll";
		else
			return "redirect:/viewAll";
	}
	
	@RequestMapping("/editDvr")
	public String editDriver(@RequestParam("did") int id,Model model)
	{
		DriverEntity dvr = dvrService.getDriverId(id);
		model.addAttribute("dvr",dvr);
		return "editdriver";
	}
	@RequestMapping("/update")
	public String updateDriver(DriverEntity dvr)
	{
		boolean update = dvrService.update(dvr);
		
		return "redirect:/viewAll";

	}
	
}
