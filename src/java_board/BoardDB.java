package java_board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardDB {
	static ArticleDao articleDao = new ArticleDao();
	static CommentDao commentDao = new CommentDao();
	static MemberDao memberDao = new MemberDao();
	static DBUtil2 db = new DBUtil2();
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();
			if(cmd.equals("list")) {
				ArrayList<Article> articles = articleDao.getArticles();
				for(int i = 0; i < articles.size(); i++)
				{
					System.out.println(articles.get(i).getTitle());
					System.out.println(articles.get(i).getBody());
					System.out.println(articles.get(i).getNickname());
					System.out.println(articles.get(i).getRegDate());
					System.out.println(articles.get(i).getHit());
					System.out.println();
				}
			} else if(cmd.equals("update")) {
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
			} else if(cmd.equals("delete")) {
				System.out.print("삭제할 게시물 번호 : ");
				int aid = Integer.parseInt(sc.nextLine());
				if(checkIfExits(aid)) {}
				else
				{
					articleDao.deleteArticle(aid);
				}
			} else if(cmd.equals("add")) {
				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String body = sc.nextLine();
				
				articleDao.insertArticle(title, body);
			} else if(cmd.equals("read")) {
				System.out.print("상세보기할 게시물 번호 : ");
				int aid = Integer.parseInt(sc.nextLine());
				
				if(checkIfExits(aid)) {}
				else
				{
					printArticle(aid);
					printComments(aid);
					
					while(true)
					{
						System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
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
							System.out.println("수정");
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
			
			else if(cmd.equals("sign up")) // 회원가입
			{
				Member member = new Member();
				
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
			
			else if(cmd.equals("sign in")) // 로그인
			{
				System.out.print("로그인 아이디를 입력해 주세요 : ");
				String id = sc.nextLine();
				
				System.out.print("로그인 비밀번호를 입력해 주세요 : ");
				String pass = sc.nextLine();
				
				Member member = memberDao.getSignin(id, pass);
				
				if(member.getId().equals(id) && member.getPass().equals(pass))
				{
					System.out.println("로그인 완료!");
				}
				
				else
				{
					System.out.println("다시 시도해 주십시오.");
				}
				
			}
			
		}
	}
	
	public static void printArticle(int aid)
	{
		Article article = articleDao.getArticleById(aid);
		System.out.println();
		System.out.println("=====" + aid + "번 게시물 =====");
		System.out.println(article.getTitle());
		System.out.println(article.getBody());
		System.out.println(article.getNickname());
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
}
