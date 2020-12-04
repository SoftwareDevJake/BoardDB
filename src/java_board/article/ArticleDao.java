package java_board.article;

import java.util.ArrayList;

import java_board.DBUtil2;
import java_board.comment.Comment;
import java_board.comment.CommentRowMapper;

public class ArticleDao {

	private DBUtil2 db = new DBUtil2();
	
	public ArrayList<Article> getArticles() {
		String sql = "select * from article";
		return db.getRows(sql, new ArticleRowMapper());
	}
	
	public int updateArticle(String title, String body, int aid) {
		String sql = "update article set title = ?, body = ? where id = ?";
		return db.updateQuery(sql, title, body, aid);
	}
	
	public int deleteArticle(int aid) {
		String sql = "delete from article where id = ?";
		return db.updateQuery(sql, aid);
	}
	
	public int insertArticle(String title, String body, int memberNum, int hit) {
		String sql = "insert into article set title = ?, body = ?, regDate = NOW(), hit = ?, memberNum = ?";
		return db.updateQuery(sql, title, body, hit, memberNum);
	}
	
	public Article getArticleById(int aid) {
		String sql = "select * from article where id = ?";
		return db.getRow(sql, new ArticleRowMapper(), aid);
	}
	
	public ArrayList<Comment> getCommentById(int aid)
	{
		String sql = "select * from comments where articleNo = ?";
		
		return db.getRows(sql, new CommentRowMapper() ,aid);
	}
	
	public int hit(int hit, int aid)
	{
		String sql = "UPDATE article SET hit = ? WHERE id = ?";
		
		return db.updateQuery(sql, hit, aid);
	}
}
