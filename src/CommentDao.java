import java.util.ArrayList;

public class CommentDao {
	
	private DBUtil db = new DBUtil();
	
	public ArrayList<Comment> getComments()
	{
		
		String sql = "select * from comments";
		
		return db.getCommentRows(sql);
	}
	
	public int insertComment(String comment)
	{
		String sql = "INSERT INTO comments SET `comment` = ?, nickname = '익명', regDate = NOW()";
		
		return db.updateQuery(sql, comment);
	}
	
}
