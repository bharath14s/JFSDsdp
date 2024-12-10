package com.klef.jfsd.sdpproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.sdpproject.model.Voter;
import com.klef.jfsd.sdpproject.service.VoterService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class VoterController {
    @Autowired
    private VoterService voterService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @GetMapping("voterreg")
    public ModelAndView empreg() {
        return new ModelAndView("voterreg");
    }

    @PostMapping("insertvoter")
    public ModelAndView insertvoter(HttpServletRequest request) {
        String name = request.getParameter("vname");
        String gender = request.getParameter("vgender");
        String dob = request.getParameter("vdob");
        String maritalstatus = request.getParameter("vmartialstatus"); // corrected spelling
        String location = request.getParameter("vlocation");
        String email = request.getParameter("vemail");
        String password = request.getParameter("vpwd");
        String contact = request.getParameter("vcontact");

        Voter voter = new Voter();
        voter.setName(name);
        voter.setGender(gender);
        voter.setMartialstatus(maritalstatus); // corrected spelling
        voter.setDateofbirth(dob);
        voter.setLocation(location);
        voter.setEmail(email);
        voter.setPassword(password);
        voter.setContact(contact);

        String msg = voterService.VoterRegistration(voter);

        return new ModelAndView("regsuccess").addObject("message", msg);
    }

    @GetMapping("adminlogin")
    public ModelAndView adminlogin() {
        return new ModelAndView("adminlogin");
    }

    @GetMapping("voterlogin")
    public ModelAndView voterlogin() {
        return new ModelAndView("voterlogin");
    }
    
    @GetMapping("analystlogin")
    public ModelAndView analystlogin() {
        return new ModelAndView("analystlogin");
    }

    @PostMapping("checkvoterlogin")
    public ModelAndView checkvoterlogin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        
        String vemail = request.getParameter("vemail");
        String vpwd = request.getParameter("vpwd");

        Voter voter = voterService.checkvoterlogin(vemail, vpwd);
        
        if (voter != null) {
            HttpSession session = request.getSession();
            session.setAttribute("voter", voter); // "voter" is a session variable
            
            mv.setViewName("voterhome");
        } else {
            mv.setViewName("voterloginfail");
            mv.addObject("message", "Login Failed");
        }
        return mv;
    }


    @GetMapping("voterhome")
    public ModelAndView voterhome() {
        return new ModelAndView("voterhome");
    }

    @GetMapping("voterlogout")
    public ModelAndView voterlogout() {
        return new ModelAndView("voterlogin"); // Consider redirecting to a logout success page
    }
    
    @GetMapping("votersessionfail")
    public ModelAndView votersessionfail() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("votersessionfail"); 
        return mv;
    }
    
    @GetMapping("voterprofile")
    public ModelAndView voterprofile() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("voterprofile"); 
        return mv;
    }
    
    @GetMapping("updatevoter")
    public ModelAndView updatevoter() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("updatevoter"); 
        return mv;
    }
    
    @PostMapping("update")
    public ModelAndView update(HttpServletRequest request)
    {
       int id =Integer.parseInt(request.getParameter("vid"));
       String name = request.getParameter("vname");
       String gender = request.getParameter("vgender");
       String dob = request.getParameter("vdob");
       String martialstatus = request.getParameter("vmartialstatus");
       String location = request.getParameter("vlocation");
       String email = request.getParameter("vemail");
       String password = request.getParameter("vpwd");
       String contact = request.getParameter("vcontact");


       Voter voter = new Voter();
       voter.setId(id);
       voter.setName(name);
       voter.setGender(gender);
       voter.setMartialstatus(martialstatus);
       voter.setDateofbirth(dob);
       voter.setLocation(location);
       voter.setEmail(email);
       voter.setPassword(password);
       voter.setContact(contact);
       
       String msg = voterService.updatevoter(voter);
       
       ModelAndView mv = new ModelAndView("updatesuccess");
       mv.addObject("message", msg);
     
       return mv;

    }
    
}
