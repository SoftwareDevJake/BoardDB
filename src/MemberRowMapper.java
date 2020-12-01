import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRowMapper implements RowMapper<Member> {
	
	public Member getRow(ResultSet rs) throws SQLException
	{
		Member member = new Member();
		
		String id = rs.getString("id");
		String pass = rs.getString("pass");
		String nickname = rs.getString("nickname");
		int num = rs.getInt("num");
		
		member.setId(id);
		member.setPass(pass);
		member.setNickname(nickname);
		member.setNum(num);
		
		
		return member;
	}
	
}
