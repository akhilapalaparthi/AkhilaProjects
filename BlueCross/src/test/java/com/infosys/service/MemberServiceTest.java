package com.infosys.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.model.Member;
import com.infosys.repo.IMember;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {
	
	@Mock
	private IMember mockedMemberRepo;
	private Member member;
	private Member invalidMember;
	private MemberService memberService;

	@Before
	public void setUp() throws Exception {
		// this is a valid memberId in the DB.
		member = new Member(2, "John");
		this.memberService = new MemberService(this.mockedMemberRepo);
	}

	@Test
	public void testcreateMember() {
		Member newmember = new Member(5, "different member");
		when(mockedMemberRepo.save(newmember)).thenReturn(newmember);
		assertEquals(memberService.createMember(newmember), newmember);
	}

	@Test
	public void testfindAllMembersSuccess() {

		List<Member> value = Arrays.asList(member, new Member(1, "Bob"), new Member(7, "Billy"));
		when(mockedMemberRepo.findAll()).thenReturn(value);
		assertTrue(!memberService.findAllMembers().isEmpty());

	}

	@Test
	public void testfindAllMembersFail() {
		List<Member> value = new ArrayList<>();
		when(mockedMemberRepo.findAll()).thenReturn(value);
		assertTrue(memberService.findAllMembers().isEmpty());

	}

	@Test
	public void testupdateMemberSuccess() {

		int memberId = 2;// it is a valid memberId in the database.
		Member updatedMember = new Member(2, "New Name");
		when(mockedMemberRepo.findById(member.getMemberId())).thenReturn(Optional.of(member));
		when(mockedMemberRepo.save(Optional.of(updatedMember).get())).thenReturn(updatedMember);
		System.out.println("It is " + memberService.updateMember(updatedMember));
		System.out.println("member is " + mockedMemberRepo.findById(member.getMemberId()));
		assertTrue(memberService.updateMember(updatedMember).equals(updatedMember));
		// memberService.updateMember(member)).thenReturn(Optional.of(member));

	}

	@Test
	public void testupdateMemberFail() {
		// int memberId = 2;// it is a valid memberId in the database.
		Member updatedMember = new Member(2, "New Name");
		Member member1 = new Member(3, "Some Name");
		when(mockedMemberRepo.findById(member1.getMemberId())).thenReturn(Optional.empty());
		// when(mockedMemberRepo.save(Optional.of(updatedMember).get())).thenReturn(updatedMember);
		System.out.println("It is " + memberService.updateMember(updatedMember));
		System.out.println("member is " + mockedMemberRepo.findById(member.getMemberId()));
		assertNull(memberService.updateMember(member1)); // updatedMember));

	}

	// Let us assume that memberId = -2 doesn't exit in the database.It will throw
	// an 404 HTTP status code.
	// So if the user enters memberId=-2, then the test should fail.
	@Test
	public void testfindMemberbyIdFail() {

		invalidMember = new Member(-2, "Invalid Member");
		when(mockedMemberRepo.findById(-2)).thenReturn(Optional.empty());
		assertNull(memberService.findMemberbyId(invalidMember.getMemberId()));
	}

	@Test
	public void testfindMemberbyIdSuccess() {
		when(mockedMemberRepo.findById(2)).thenReturn(Optional.of(member));
		assertNotNull(memberService.findMemberbyId(2));

	}
}
