package java_board;

import java.util.ArrayList;

public class MemberDao {
	
	private DBUtil2 db = new DBUtil2();
	
	public int insertSignin(String id, String pass, String nickname)
	{
		String sql = "insert into members set id = ?, pass = ?, nickname = ?";
		
		return db.updateQuery(sql, id, pass, nickname);
	}
	
	public Member getSignin(String id, String pass)
	{
		String sql = "SELECT * FROM members WHERE id = ? AND pass = ?";
		
		return db.getRow(sql, new MemberRowMapper(), id, pass);
	}
	
	public ArrayList<Member> getSigninByFind_User(int find_user)
	{
		String sql = "select * from mebers where num = ?";
				
		return db.getRows(sql, new MemberRowMapper(), find_user);
	}
	
	public Member getSigninWithNum(int find_user)
	{
		String sql = "select * from members where num = ?";
		return db.getRow(sql, new MemberRowMapper(), find_user);
	}
	
	public ArrayList<Member> getSignins()
	{
		String sql = "select * from members";
		return db.getRows(sql, new MemberRowMapper());
	}
}
