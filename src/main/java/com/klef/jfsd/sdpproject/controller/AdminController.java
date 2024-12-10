package com.klef.jfsd.sdpproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.sdpproject.model.Admin;
import com.klef.jfsd.sdpproject.model.Voter;
import com.klef.jfsd.sdpproject.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Display the admin home page
    @GetMapping("adminhome")
    public ModelAndView adminHome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminhome");
        return mv;
    }

    // View all voters
    @GetMapping("viewallvoters")
	public ModelAndView viewallvoters() 
	{
	    ModelAndView mv = new ModelAndView();
        List<Voter> voterlist = adminService.ViewAllVoters();
        mv.setViewName("viewallvoters");
	    mv.addObject("emplist", voterlist);
	    return mv;
	}
    // Check admin login credentials
    @PostMapping("checkadminlogin")
    public ModelAndView checkAdminLogin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        
        String username = request.getParameter("auname");
        String password = request.getParameter("apwd");
        
        Admin admin = adminService.checkadminlogin(username, password);
        
        if (admin != null) {
            mv.setViewName("adminhome"); // Redirect to admin home on successful login
        } else {
            mv.setViewName("adminloginfail");
            mv.addObject("message", "Login Failed");
        }
        return mv;
    }

    // Delete a voter
    @GetMapping("deletevoter")
    public ModelAndView deleteVoter() {
        ModelAndView mv = new ModelAndView();
        List<Voter> voterList = adminService.ViewAllVoters();
        mv.setViewName("deletevoter");
        mv.addObject("emplist", voterList);
        return mv;
    }
    
    @GetMapping("delete")
	public String  delete(@RequestParam("id") int eid)
	{
		adminService.deletevoter(eid);
		return "redirect:/deletevoter";
	}

    // Admin logout
    @GetMapping("adminlogout")
    public ModelAndView adminLogout() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminlogin");
        return mv;
    }
    
}
