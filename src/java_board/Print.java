package java_board;

import java.util.ArrayList;

import java_board.article.Article;
import java_board.article.ArticleDao;
import java_board.comment.Comment;
import java_board.member.Member;
import java_board.member.MemberDao;

public class Print {
	
	ArticleDao articleDao = new ArticleDao();
	MemberDao memberDao = new MemberDao();
	ArrayList<Article> articles = new ArrayList<>();
	ArrayList<Member> members = new ArrayList<>();
	ArrayList<Comment> comments = new ArrayList<>();
	Article article = new Article();
	Member member = new Member();
	
	public void articleList()
	{
		articles = articleDao.getArticles();
		members = memberDao.getSignins();

		for(int i = 0; i < articles.size(); i++)
		{
			System.out.println("id : " + articles.get(i).getId());
			System.out.println("title : " + articles.get(i).getTitle());
			System.out.println("body : " + articles.get(i).getBody());
			System.out.println("nickname : " + members.get(articles.get(i).getMemberNum()-1).getNickname());
			System.out.println("date : " + articles.get(i).getRegDate());
			System.out.println("hit : " + articles.get(i).getHit());
			System.out.println();
		}
	}
	
	public void printArticle(Article article, Member member)
	{	
		member = memberDao.getSigninWithNum(article.getMemberNum());
		System.out.println();
		System.out.println("=====" + article.getId() + "번 게시물 =====");
		System.out.println("title : " + article.getTitle());
		System.out.println("body : " + article.getBody());
		System.out.println("nickname : " + member.getNickname());
		System.out.println("regDate : " + article.getRegDate());
		System.out.println("hit : " + article.getHit());
		System.out.println("==================");
	}
	
	public void printComments(Article article)
	{
		comments = articleDao.getCommentById(article.getId());
		for(int i = 0; i < comments.size(); i++)
		{
//			해당 게시물의 댓글 찾아서 프린트
			System.out.println();
			System.out.println("번호 : " + comments.get(i).getId());
			System.out.println("내용 : " + comments.get(i).getComment());
			System.out.println("장성자 : " + comments.get(i).getNickname());
			System.out.println("작성일 : " + comments.get(i).getRegDate());
			System.out.println("===============================================");
		}
	}
	
}
