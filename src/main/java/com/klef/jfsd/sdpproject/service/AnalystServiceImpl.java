package com.klef.jfsd.sdpproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.klef.jfsd.sdpproject.model.Analyst;
import com.klef.jfsd.sdpproject.model.Voter;
import com.klef.jfsd.sdpproject.repository.AnalystRepository;
import com.klef.jfsd.sdpproject.repository.VoterRepository;

@Service
public class AnalystServiceImpl implements AnalystService
{
	@Autowired
	private AnalystRepository analystRepository; 

	@Autowired
    private VoterRepository voterRepository;
	
	@Override
	public List<Voter> ViewAllByAnalyst() 
	{		
		return voterRepository.findAll();
	}

	@Override
	public Analyst checkanalystlogin(String uname, String pwd) 
	{	
		return analystRepository.checkanalystlogin(uname, pwd);
	}

}
