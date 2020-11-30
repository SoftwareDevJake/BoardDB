import java.util.ArrayList;
import java.util.Scanner;

public class BoardDB {

	public static void main(String[] args) {
		ArticleDao articleDao = new ArticleDao();
		CommentDao commentDao = new CommentDao();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();
			if(cmd.equals("list")) {
				ArrayList<Article> articles = articleDao.getArticles();
				for(int i = 0; i < articles.size(); i++)
				{
					System.out.println(articles.get(i).getTitle());
					System.out.println(articles.get(i).getBody());
					System.out.println(articles.get(i).getNickname());
					System.out.println(articles.get(i).getRegDate());
					System.out.println(articles.get(i).getHit());
				}
			} else if(cmd.equals("update")) {
				System.out.print("수정할 게시물 번호 : ");
				int aid = Integer.parseInt(sc.nextLine());
				
				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String body = sc.nextLine();
				articleDao.updateArticle(title, body, aid);
			} else if(cmd.equals("delete")) {
				System.out.print("삭제할 게시물 번호 : ");
				int aid = Integer.parseInt(sc.nextLine());
				articleDao.deleteArticle(aid);
			} else if(cmd.equals("add")) {
				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String body = sc.nextLine();
				
				articleDao.insertArticle(title, body);
			} else if(cmd.equals("read")) {
				System.out.print("상세보기할 게시물 번호 : ");
				int aid = Integer.parseInt(sc.nextLine());
				
				Article article = articleDao.getArticleById(aid);
				System.out.println();
				System.out.println("=====" + aid + "번 게시물 =====");
				System.out.println(article.getTitle());
				System.out.println(article.getBody());
				System.out.println(article.getNickname());
				System.out.println(article.getRegDate());
				System.out.println(article.getHit());
				System.out.println("==================");
				
				while(true)
				{
					System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
					int choice = Integer.parseInt(sc.nextLine());
					
					if(choice == 1)
					{
						ArrayList<Comment> comments = commentDao.getComments();
//						Comment c = 
						System.out.print("댓글 내용을 입력해주세요 : ");
						String comment = sc.nextLine();
						
						commentDao.insertComment(comment);
						
						articleDao.getArticleById(aid);
						
						for(int i = 0; i < comments.size(); i++)
						{
//							해당 게시물의 댓글 찾아서 프린트
							System.out.println("내용 : " + comments.get(i).getComment());
							System.out.println("장성자 : " + comments.get(i).getNickname());
							System.out.println("작성일 : " + comments.get(i).getRegDate());
							System.out.println("===============================================");
						}
						
					}
					else if(choice == 2)
					{
						System.out.println("좋아요");
					}
					else if(choice == 3)
					{
						System.out.println("수정");
					}
					else if(choice == 4)
					{
						System.out.println("삭제");
					}
					else if(choice == 5)
					{
						break;
					}
				}
			}
			
		}
	}
	
	
}
