
public class Comment {
	
	private int id;
	private String comment;
	private String nickname;
	private String regDate;
	private int articleNo;
	
	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public Comment()
	{
		
	}
	
	public Comment(int id, String comment, String nickname, String regDate, int articleNo) {
		this.id = id;
		this.comment = comment;
		this.nickname = nickname;
		this.regDate = regDate;
		this.articleNo = articleNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}
