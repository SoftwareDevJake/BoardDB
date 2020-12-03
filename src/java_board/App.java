package java_board;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	Scanner sc = new Scanner(System.in);
	MemberDao memberDao = new MemberDao();
	ArticleFunc articleFunc = new ArticleFunc();
	MemberFunc memberFunc = new MemberFunc();
	Print print = new Print();
	If ifs = new If();
	int aid = -1;
	int memberNum = -1;
	Member member = new Member();
	Article article = new Article();
	
	ArrayList<Member> members = memberDao.getSignins();
	
	public void start()
	{
		
		while (true) {
			if(ifs.ifSignin(memberNum)){
				System.out.print("명령어를 입력해주세요 [" + members.get(memberNum).getId() + "(" + members.get(memberNum).getNickname() + ")] : ");
			} else{
				System.out.print("명령어를 입력해주세요 : ");
			}
			
			String cmd = sc.nextLine();
			
			if(cmd.equals("article list")) { // 게시물 리스트 프린트
				print.articleList();
			} else if(cmd.equals("article update")) // 게시물 수정
			{
				if(ifs.ifSignin(memberNum)){
					articleFunc.updateArticle(memberNum);
				} else {
					System.out.println("로그인 후 이용 가능합니다.");
				}
			} else if(cmd.equals("article delete")) { // 게시물 삭제
				if(ifs.ifSignin(memberNum)){
					articleFunc.articleDelete(memberNum);
				} else{
					System.out.println("로그인 후 이용 가능합니다.");
				}
			} else if(cmd.equals("article add")) { // 게시물 추가
				if(ifs.ifSignin(memberNum)) {
					articleFunc.articleAdd(memberNum);
				} else {
					System.out.println("로그인 후 이용 가능합니다.");
				}
			} else if(cmd.equals("article read")) { // 게시물 상세 읽기
				articleFunc.articleRead(memberNum);
			} else if(cmd.equals("member sign up")) { // 회원가입
				memberFunc.memberSignup();
			} else if(cmd.equals("member sign in")) { // 로그인
				memberNum = memberFunc.memberSignin(memberNum);
			} else if(cmd.equals("member log out")) { // 로그아웃
				memberFunc.memberLogout(memberNum);
			} else if(cmd.equals("exit")) { // 종료
				System.out.println("종료 되었습니다.");
				break;
			} else if(cmd.equals("help")) { // 도움말
				System.out.println("article [add: 게시물 추가 / list : 게시물 목록 조회 / read : 게시물 조회 / search : 검색]\r\n" + 
						"member [signup : 회원가입 / signin : 로그인 / findpass : 비밀번호 찾기 / findid : 아이디 찾기 / logout : 로그아웃 / myinfo : 나의 정보 확인및 수정]");
			}
		}
	}
}
