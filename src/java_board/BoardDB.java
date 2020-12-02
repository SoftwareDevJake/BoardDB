package java_board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardDB {
	static ArticleDao articleDao = new ArticleDao();
	static CommentDao commentDao = new CommentDao();
	static MemberDao memberDao = new MemberDao();
	static DBUtil2 db = new DBUtil2();
	public static void main(String[] args) {
		
		int find_user = -1;
		Scanner sc = new Scanner(System.in);
		Article article = new Article();
		Member member = new Member();
		ArrayList<Member> members = new ArrayList<>();

		while (true) {
			
			if(ifSignin(find_user))
			{
				System.out.print("명령어를 입력해주세요 [" + members.get(find_user-1).getId() + "(" + members.get(find_user-1).getNickname() + ")] : ");
			}
			
			else
			{
				System.out.print("명령어를 입력해주세요 : ");
			}
			
			String cmd = sc.nextLine();
			
			if(cmd.equals("article list")) {
				ArrayList<Article> articles = articleDao.getArticles();
				members = memberDao.getSignins();
				for(int i = 0; i < articles.size(); i++)
				{
					System.out.println(articles.get(i).getTitle());
					System.out.println(articles.get(i).getBody());
					
					System.out.println(members.get(articles.get(i).getMemberNum()-1));
					System.out.println(articles.get(i).getRegDate());
					System.out.println(articles.get(i).getHit());
					System.out.println();
				}
			} else if(cmd.equals("article update")) {
				if(ifSignin(find_user))
				{
					System.out.print("수정할 게시물 번호 : ");
					int aid = Integer.parseInt(sc.nextLine());
					
					if(checkIfExits(aid)) {}
					
					else
					{
						System.out.print("제목 : ");
						String title = sc.nextLine();
						System.out.print("내용 : ");
						String body = sc.nextLine();
						articleDao.updateArticle(title, body, aid);
					}
				}
				
				else
				{
					System.out.println("로그인 후 이용 가능합니다.");
				}
				
			} 
			else if(cmd.equals("article delete")) 
			{
				if(ifSignin(find_user))
				{
					System.out.print("삭제할 게시물 번호 : ");
					int aid = Integer.parseInt(sc.nextLine());
					if(checkIfExits(aid)) {}
					else
					{
						articleDao.deleteArticle(aid);
					}
				}
				else
				{
					System.out.println("로그인 후 이용 가능합니다.");
				}
			}
			else if(cmd.equals("article add"))
			{
				if(ifSignin(find_user))
				{
					System.out.print("제목 : ");
					String title = sc.nextLine();
					System.out.print("내용 : ");
					String body = sc.nextLine();
					
//					String nickname = members.get(find_user-1).getNickname();
					int memberNum = members.get(find_user-1).getNum();
					
					articleDao.insertArticle(title, body, memberNum);
				}
				else
				{
					System.out.println("로그인 후 이용 가능합니다.");
				}
			} 
			else if(cmd.equals("article read")) 
			{
				System.out.print("상세보기할 게시물 번호 : ");
				int aid = Integer.parseInt(sc.nextLine());
				
				if(checkIfExits(aid)) {}
				else
				{
					printArticle(aid);
					printComments(aid);
					
					while(true)
					{
						if(ifSignin(find_user))
						{
							System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
							
						}
						
						else
						{
							System.out.println("로그인 후 이용 가능합니다.");
							break;
						}
						
						int choice = Integer.parseInt(sc.nextLine());
						
						if(choice == 1)
						{
							System.out.print("댓글 내용을 입력해주세요 : ");
							String comment = sc.nextLine();
							
							commentDao.insertComment(comment, aid);
							
							printArticle(aid);
							
							printComments(aid);
							
						}
						else if(choice == 2)
						{
							System.out.println("좋아요");
						}
						else if(choice == 3)
						{
							if(ifRightUser(article, member, find_user))
							{
								System.out.print("수정할 제목을 입력해 주십시오 : ");
								String title = sc.nextLine();
								
								System.out.print("수정할 내용을 입력해 주십시오 : ");
								String body = sc.nextLine();
								
								articleDao.updateArticle(title, body, aid);
							}
							else
							{
								System.out.println("본인 게시물만 수정 가능합니다.");
							}
						}
						else if(choice == 4)
						{
							System.out.println("삭제");
						}
						else if(choice == 5)
						{
							break;
						}
					}
				}
			}
			
			else if(cmd.equals("member sign up")) // 회원가입
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
			}
			
			else if(cmd.equals("member sign in")) // 로그인
			{
				System.out.print("로그인 아이디를 입력해 주세요 : ");
				String id = sc.nextLine();
				
				System.out.print("로그인 비밀번호를 입력해 주세요 : ");
				String pass = sc.nextLine();
				
				member = memberDao.getSignin(id, pass);
				
				if(member.getId().equals(id) && member.getPass().equals(pass))
				{
					System.out.println("로그인 완료!");
					System.out.println(member.getNickname() + "님 환영합니다!");
					find_user = member.getNum();
					
					members.add(member);
				}
				
				else
				{
					System.out.println("다시 시도해 주십시오.");
				}	
			}
			
			else if(cmd.equals("member log out"))
			{
				if(ifSignin(find_user))
				{
					System.out.println("로그아웃 되셨습니다.");
					find_user = -1;
				}
				
				else
				{
					System.out.println("로그인 후 이용 가능합니다.");
				}
			}
			
			else if(cmd.equals("help"))
			{
				System.out.println("article [add: 게시물 추가 / list : 게시물 목록 조회 / read : 게시물 조회 / search : 검색]\r\n" + 
						"member [signup : 회원가입 / signin : 로그인 / findpass : 비밀번호 찾기 / findid : 아이디 찾기 / logout : 로그아웃 / myinfo : 나의 정보 확인및 수정]");
			}
		}
	}
	
	public static void printArticle(int aid)
	{
		Article article = articleDao.getArticleById(aid);
		Member member = memberDao.getSigninWithNum(aid);
		
		System.out.println();
		System.out.println("=====" + aid + "번 게시물 =====");
		System.out.println(article.getTitle());
		System.out.println(article.getBody());
		System.out.println(member.getNickname());
		System.out.println(article.getRegDate());
		System.out.println(article.getHit());
		System.out.println("==================");
	}
	
	public static void printComments(int aid)
	{
		Article article = articleDao.getArticleById(aid);
		ArrayList<Comment> comments = articleDao.getCommentById(article.getId());
		for(int i = 0; i < comments.size(); i++)
		{
//			해당 게시물의 댓글 찾아서 프린트
			System.out.println("번호 : " + comments.get(i).getId());
			System.out.println("내용 : " + comments.get(i).getComment());
			System.out.println("장성자 : " + comments.get(i).getNickname());
			System.out.println("작성일 : " + comments.get(i).getRegDate());
			System.out.println("===============================================");
		}
	}
	
	public static boolean checkIfExits(int aid)
	{
		Article article = articleDao.getArticleById(aid);
		
		if(article == null)
		{
			System.out.println("게시물이 존재하지 않습니다.");
			System.out.println("다시 시도해 주세요.");
			return true;
		}
		
		return false;
	}
	
	public static boolean ifSignin(int find_user)
	{
		if(find_user >= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean ifRightUser(Article article, Member member, int find_user)
	{
		article = articleDao.getArticleById(find_user);
		member = memberDao.getSigninWithNum(find_user);

		if(article.getMemberNum() == (member.getNum()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
