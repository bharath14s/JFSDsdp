package com.klef.jfsd.sdpproject.service;

import java.util.List;

import com.klef.jfsd.sdpproject.model.Analyst;
import com.klef.jfsd.sdpproject.model.Voter;

public interface AnalystService 
{
	List<Voter> ViewAllByAnalyst();
	Analyst checkanalystlogin(String uname, String pwd);
}
