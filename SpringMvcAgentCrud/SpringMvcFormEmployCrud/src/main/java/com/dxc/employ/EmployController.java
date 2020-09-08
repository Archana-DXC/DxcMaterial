package com.dxc.employ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/employ")
@Controller
public class EmployController {
	
	@Autowired
	EmployDAO dao;
	
	@RequestMapping("/saveEmploy") 
	public String saveData(@ModelAttribute("emp") Employ emp, Model m) {
		dao.insert(emp);
		List<Employ> list=dao.getEmployees();  
        m.addAttribute("list",list);
		return "show-employ";
	}
	@RequestMapping("/editsave")
	public String editData(@ModelAttribute("emp") Employ emp, Model m) {
		int res = dao.update(emp);
		List<Employ> list=dao.getEmployees();  
        m.addAttribute("list",list);
		return "show-employ";
	}
	@RequestMapping("/employForm")
	public String addEmploy(Model m) {
		m.addAttribute("command", new Employ());
		return "add-employ";
	}
	@RequestMapping("/viewemploy")
	public String showEmploy(Model m) {
		List<Employ> list=dao.getEmployees();  
        m.addAttribute("list",list);
		return "show-employ";
	}
	@RequestMapping("/editemploy/{empno}")
	public String editEmploy(@PathVariable int empno, Model m) {
		Employ result = dao.searchByEmpno(empno);
		m.addAttribute("command",result);
		return "edit-employ";
	}
	 @RequestMapping("/deleteemploy/{id}")  
	    public String delete(@PathVariable int id, Model m){  
	        dao.delete(id);  
	       // return "redirect:/viewemp";  
	        List<Employ> list=dao.getEmployees();  
	        m.addAttribute("list",list);
			return "show-employ";
	    }   
}
