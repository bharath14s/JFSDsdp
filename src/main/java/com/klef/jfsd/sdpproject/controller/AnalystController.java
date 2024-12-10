package com.klef.jfsd.sdpproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.sdpproject.model.Analyst;
import com.klef.jfsd.sdpproject.model.Voter;
import com.klef.jfsd.sdpproject.service.AnalystService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AnalystController {
    
    @Autowired
    private AnalystService analystService;

    @GetMapping("/analysthome")
    public ModelAndView analysthome() {
        ModelAndView mv = new ModelAndView("analysthome");
        return mv;
    }

    @GetMapping("/viewallbyanalyst")
    public ModelAndView viewallbyanalyst() {
        ModelAndView mv = new ModelAndView("viewallbyanalyst");
        List<Voter> voterlist = analystService.ViewAllByAnalyst();
        mv.addObject("emplist", voterlist);
        return mv;
    }

    @PostMapping("/checkanalystlogin")
    public ModelAndView checkanalystlogin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        String username = request.getParameter("auname");
        String password = request.getParameter("apwd");

        Analyst analyst = analystService.checkanalystlogin(username, password);

        if (analyst != null) {
            mv.setViewName("analysthome");
        } else {
            mv.setViewName("analystloginfail");
            mv.addObject("message", "Login Failed");
        }
        return mv;
    }
}
