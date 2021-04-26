package com.infosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.model.Member;
import com.infosys.repo.IMember;

@Service
public class MemberService {

	@Autowired
	private IMember repoMember;

	public MemberService(IMember imember) {
		super();
		this.repoMember = imember;

	}

	public List<Member> findAllMembers() {
		return repoMember.findAll();

	}

	public Member createMember(Member member) {
		return repoMember.save(member);

	}

	public Member findMemberbyId(int id) {
		Optional<Member> member = repoMember.findById(id);
		if (member.isPresent()) {
			return member.get();

		} else {
			return null;
		}
	}

	public Member updateMember(Member member) {
		Optional<Member> member1 = repoMember.findById(member.getMemberId());

		if (member1.isPresent()) {
			member1.get().setMemberName(member.getMemberName());
			return repoMember.save(member1.get());
		} else {
			
			return null;
		}

	}
}