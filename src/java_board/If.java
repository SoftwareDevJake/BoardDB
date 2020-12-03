package java_board;

public class If {
	
	ArticleDao articleDao = new ArticleDao();
	MemberDao memberDao = new MemberDao();
	
	public boolean checkIfNotExits(int aid)
	{
		Article article = articleDao.getArticleById(aid);
		
		if(article == null)
		{
			System.out.println("게시물이 존재하지 않습니다.");
			System.out.println("다시 시도해 주세요.");
			return true;
		}
		
		return false;
	}
	
	public boolean ifSignin(int memberNum)
	{
		if(memberNum >= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean ifRightUser(Article article, Member member, int memberNum, int aid)
	{
		article = articleDao.getArticleById(aid);
		member = memberDao.getSigninWithNum(memberNum);

		if(article.getMemberNum() == member.getNum())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
