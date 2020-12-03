package java_board;

public class Likes {
	
	private int id;
	private int articleId;
	private int memberNum;
	private String regDate;
	
	Likes()
	{
		
	}
	
	public Likes(int id, int articleId, int memberNum, String regDate) {
		this.id = id;
		this.articleId = articleId;
		this.memberNum = memberNum;
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
