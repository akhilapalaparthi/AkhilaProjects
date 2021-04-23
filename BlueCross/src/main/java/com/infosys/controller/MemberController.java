package com.infosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.model.Member;
import com.infosys.service.MemberService;

@RestController
@RequestMapping("/member")
@CrossOrigin
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("")
	public List<Member> getAllMembers() {
		return memberService.findAllMembers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable int id) {
		try {
			if (memberService.findMemberbyId(id) != null) {
				return new ResponseEntity<Member>(memberService.findMemberbyId(id), HttpStatus.CREATED);

			} else {
				return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {

			return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
			// return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
		}

		// return memberService.findMemberbyId(id);
	}

	@PostMapping("")
	public ResponseEntity<Member> createMemberById(@RequestBody Member member) {
		try {
			if (member.getMemberId() != 0 && member.getMemberName() != null) {

				return new ResponseEntity<Member>(memberService.createMember(member), HttpStatus.CREATED);
			} else
				return new ResponseEntity<Member>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Member>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Member> updateMemberById(@RequestBody Member member, @PathVariable int id) {

		if (memberService.findMemberbyId(id) != null) {

			member.setMemberId(id);
			Member mat = memberService.updateMember(member);

			return new ResponseEntity<Member>(mat, HttpStatus.OK);

		} else {
			return new ResponseEntity<Member>(HttpStatus.BAD_REQUEST);
		}
	}

}
