package java_board.member;

import java.util.ArrayList;
import java.util.Scanner;

import java_board.If;

public class MemberFunc {

	Scanner sc = new Scanner(System.in);
	Member member = new Member();
	MemberDao memberDao = new MemberDao();
	ArrayList<Member> members = new ArrayList<>();
	If ifs = new If();
	
	public void memberSignup()
	{
		System.out.print("회원 아이디를 입력해 주세요 : ");
		String id = sc.nextLine();
		member.setId(id);
		
		System.out.print("회원 비밀번호를 입력해 주세요 :");
		String pass = sc.nextLine();
		member.setPass(pass);
		
		System.out.print("회원 닉네임을 입력해 주세요 :");
		String nickname = sc.nextLine();
		
		memberDao.insertSignin(id, pass, nickname);
		
		members = memberDao.getSignins();
		members.add(member);
	}
	
	public int memberSignin(int memberNum)
	{
		members = memberDao.getSignins();
		
		System.out.print("로그인 아이디를 입력해 주세요 : ");
		String id = sc.nextLine();
		
		System.out.print("로그인 비밀번호를 입력해 주세요 : ");
		String pass = sc.nextLine();
		
		member = memberDao.getSignin(id, pass);
		
		if(member == null)
		{
			System.out.println("다시 시도해 주십시오.");
			return memberNum;
		}
		
		else
		{
			if(member.getId().equals(id) && member.getPass().equals(pass))
			{
				System.out.println("로그인 완료!");
				System.out.println(member.getNickname() + "님 환영합니다!");
				memberNum = member.getNum();
				members.add(member);
				
				members = memberDao.getSignins();
				
				return memberNum;
			}
			else
			{
				System.out.println("다시 시도해 주십시오.");
				return memberNum;
			}
		}
	}
	
	public void memberLogout(int memberNum)
	{
		if(ifs.ifSignin(memberNum))
		{
			System.out.println("로그아웃 되셨습니다.");
			memberNum = -1;
		}
	
		else
		{
			System.out.println("로그인 후 이용 가능합니다.");
		}
	}
	
}
