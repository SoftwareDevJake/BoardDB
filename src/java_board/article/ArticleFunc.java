package java_board.article;

import java.util.ArrayList;
import java.util.Scanner;

import java_board.If;
import java_board.Print;
import java_board.comment.CommentDao;
import java_board.member.Member;
import java_board.member.MemberDao;

public class ArticleFunc {
	
	Scanner sc = new Scanner(System.in);
	ArrayList<Member> members = new ArrayList<>();
	ArrayList<Article> articles = new ArrayList<>();
	ArticleDao articleDao = new ArticleDao();
	CommentDao commentDao = new CommentDao();
	MemberDao memberDao = new MemberDao();
	Print print = new Print();
	Article article = new Article();
	Member member = new Member();
	If ifs = new If();
	
	public void articleAdd(int memberNum)
	{
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String body = sc.nextLine();
		
		
		articleDao.insertArticle(title, body, memberNum, 0);
	}
	
	public void updateArticle(int memberNum)
	{
		System.out.print("수정할 게시물 번호 : ");
		int aid = Integer.parseInt(sc.nextLine());
		
		article = articleDao.getArticleById(aid);
		member = memberDao.getSigninWithNum(memberNum);
		
		if(ifs.checkIfNotExits(aid)) {}
		
		else
		{
			if(ifs.ifRightUser(article, member, memberNum, aid))
			{
				System.out.print("수정할 제목 : ");
				String title = sc.nextLine();
				System.out.print("수정할 내용 : ");
				String body = sc.nextLine();
				articleDao.updateArticle(title, body, aid);
			}
			else
			{
				System.out.println("자신의 게시물만 수정 할 수 있습니다.");
			}
		}
	}
	
	public void articleDelete(int memberNum)
	{
		System.out.print("삭제할 게시물 번호 : ");
		int aid = Integer.parseInt(sc.nextLine());
		if(ifs.ifRightUser(article, member, memberNum, aid))
		{
			articleDao.deleteArticle(aid);
		}
		else
		{
			System.out.println("자신의 게시물만 삭제 할 수 있습니다.");
		}
	}
	
	public void articleRead(int memberNum)
	{
		System.out.print("상세보기할 게시물 번호 : ");
		int aid = Integer.parseInt(sc.nextLine());
		
		article = articleDao.getArticleById(aid);
		member = memberDao.getSigninWithNum(aid);
		
		if(ifs.checkIfNotExits(aid)) {}
		member = memberDao.getSigninWithNum(memberNum + 1);
		
		articleDao.hit(article.getHit() + 1, aid);
		article = articleDao.getArticleById(aid);
		
		if(ifs.checkIfNotExits(aid)) {}
		else
		{
			print.printArticle(article, member);
			print.printComments(article);
			
			while(true)
			{
				if(ifs.ifSignin(memberNum))
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
					member = memberDao.getSigninWithNum(memberNum + 1);
					commentDao.insertComment(comment, aid, member.getNickname());
					
					print.printArticle(article,member);
					print.printComments(article);
				}
				else if(choice == 2)
				{
					
					System.out.println("해당 게시물을 좋아합니다.");
				}
				else if(choice == 3)
				{
					if(ifs.ifRightUser(article, member, memberNum, aid))
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
					articleDao.deleteArticle(aid);
					System.out.println("삭제 되었습니다.");
				}
				else if(choice == 5)
				{
					break;
				}
			}
		}
	}
}
