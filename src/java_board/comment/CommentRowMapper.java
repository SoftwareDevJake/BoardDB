package java_board.comment;

import java.sql.ResultSet;
import java.sql.SQLException;

import java_board.RowMapper;

public class CommentRowMapper implements RowMapper<Comment> {
	
	public Comment getRow(ResultSet rs) throws SQLException
	{
		String comment = rs.getString("comment");
		int id = rs.getInt("id");
		String nickname = rs.getString("nickname");
		String regDate = rs.getString("regDate");
		int articleNo = rs.getInt("articleNo");
		
		Comment c = new Comment();
		
		c.setId(id);
		c.setComment(comment);
		c.setNickname(nickname);
		c.setRegDate(regDate);
		c.setArticleNo(articleNo);
		
		return c;
	}
	
}
