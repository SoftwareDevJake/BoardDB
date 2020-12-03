package java_board.article;

import java.sql.ResultSet;
import java.sql.SQLException;

import java_board.RowMapper;

public class ArticleRowMapper implements RowMapper<Article> {

	public Article getRow(ResultSet rs) throws SQLException
	{
		Article article = new Article();
		
		String title = rs.getString("title");
		int id = rs.getInt("id");
		String body = rs.getString("body");
		String regDate = rs.getString("regDate");
		int hit = rs.getInt("hit");
		int memberNum = rs.getInt("memberNum");

		article.setTitle(title);
		article.setBody(body);
		article.setId(id);
		article.setRegDate(regDate);
		article.setHit(hit);
		article.setMemberNum(memberNum);
		
		return article;
	}
	
}
