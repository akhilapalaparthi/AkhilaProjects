package com.infosys.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.model.Member;


@Repository
public interface IMember extends JpaRepository<Member, Integer> {
	
	//public Optional<Member> findMemberById(int id);

}
