
public class Member {
	
	private String id;
	private String pass;
	private String nickname;
	private int num;
	
	Member()
	{
		
	}
	
	public Member(String id, String pass, String nickname, int num) {
		this.id = id;
		this.pass = pass;
		this.nickname = nickname;
		this.num = num;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
