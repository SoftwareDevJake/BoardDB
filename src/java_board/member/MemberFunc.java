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
	
	public ArrayList<Member> memberSignup()
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
		
		System.out.println("1멤버 리스트 추가 확인 : " + members.size());
		
		System.out.println("2멤버 리스트 추가 확인 : " + members.size());
		
		return members;
	}
	
	public Member memberSignin(ArrayList<Member> members)
	{
		System.out.print("로그인 아이디를 입력해 주세요 : ");
		String id = sc.nextLine();
		
		System.out.print("로그인 비밀번호를 입력해 주세요 : ");
		String pass = sc.nextLine();
		System.out.println("5멤버 리스트 추가 확인 : " + members.size());
		member = memberDao.getSignin(id, pass);
		
		if(member == null)
		{
			System.out.println("다시 시도해 주십시오.");
			return member;
		}
		
		else
		{
			if(member.getId().equals(id) && member.getPass().equals(pass))
			{
				System.out.println("로그인 완료!");
				System.out.println(member.getNickname() + "님 환영합니다!");
				System.out.println("6멤버 리스트 추가 확인 : " + members.size());
				
				return member;
			}
			else
			{
				System.out.println("다시 시도해 주십시오.");
				return member;
			}
		}
	}
	
	public int memberLogout(int memberNum)
	{
		if(ifs.ifSignin(memberNum))
		{
			System.out.println("로그아웃 되셨습니다.");
			memberNum = -1;
			return memberNum;
		}
	
		else
		{
			System.out.println("로그인 후 이용 가능합니다.");
			return memberNum;
		}
	}
	
	public void memberInfo()
	{
		members = memberDao.getSignins();
		
		for(int i = 0; i < members.size(); i++)
		{
			System.out.println();
			System.out.println("Member id : " + members.get(i).getId());
			System.out.println("Member pass : " + members.get(i).getPass());
			System.out.println("Member nickname : " + members.get(i).getNickname());
			System.out.println("Member num : " + members.get(i).getNum());
		}
		System.out.println("Members size : " + members.size());
		System.out.println();
	}
}
