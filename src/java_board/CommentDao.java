package java_board;

public class CommentDao {
	
	private DBUtil2 db = new DBUtil2();
	
	public int insertComment(String comment, int aid)
	{
		String sql = "INSERT INTO comments SET `comment` = ?, nickname = '익명', regDate = NOW(), articleNo = ?";
		
		return db.updateQuery(sql, comment, aid);
	}
	
	
	
}
