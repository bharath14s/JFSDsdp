package com.klef.jfsd.sdpproject.service;

import com.klef.jfsd.sdpproject.model.Voter;

public interface VoterService 
{
	public String VoterRegistration(Voter voter);
	public Voter checkvoterlogin(String vemail,String vpwd);
	public String updatevoter(Voter v);
}
