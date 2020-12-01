
public class MemberDao {
	
	private DBUtil2 db = new DBUtil2();
	
	public int insertSignin(String id, String pass, String nickname)
	{
		String sql = "insert into members set id = ?, pass = ?, nickname = ?";
		
		return db.updateQuery(sql, id, pass, nickname);
	}
	
	public Member getSignin(String id, String pass)
	{
		String sql = "SELECT id, pass FROM members WHERE id = ?, pass = ?";
		
		return db.getRow(sql, new MemberRowMapper(), id, pass);
	}
}
