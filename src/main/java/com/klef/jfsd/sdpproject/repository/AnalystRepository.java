package com.klef.jfsd.sdpproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klef.jfsd.sdpproject.model.Analyst;

public interface AnalystRepository extends JpaRepository<Analyst, String>
{
	@Query("select a from Analyst a where a.username=?1 and a.password=?2")
	public Analyst checkanalystlogin(String uname, String pwd);
}
