package java_board;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> title = new ArrayList<>();
		ArrayList<String> body = new ArrayList<>();
		boolean loop = true;
		Add a = new Add();
		
		
		while(loop)
		{
			System.out.print("명령어 입력 : ");
			
			String s = sc.next(); // 입력
			
			
			if(s.equals("add"))
			{
				//a.add(title, body);
				System.out.print("게시물 제목을 입력해주세요 : ");
				title.add(sc.nextLine());
				
				System.out.print("게시물 내용을 입력해주세요 : ");
				body.add(sc.nextLine());
				
				System.out.println("게시물이 등록 되었습니다.");
				//System.out.println("title = " + title.get() + "body = " + body);
			}
			
			else if(s.equals("list"))
			{
				//List l = new List(title, body);
				//l.show_list();
				for(int i = 0; i < title.size(); i++)
					{
						System.out.println("제목 : " + title.get(i));
						System.out.println("내용 : " + body.get(i));
					}
			}
			
			else if(s.equals("exit"))
			{
				Exit e = new Exit();
				loop = e.exit(s, loop); // 종료
			}
			
		}
		
		
		
	}

}

class Exit {
	boolean exit (String s, boolean loop)
	{
		if(s.equals("exit"))
		{
			System.out.println("종료");
			loop = false;
		}
		return loop;
	}
}

class Add {
//	String title;
//	String body;
	Scanner sc2 = new Scanner(System.in);
	
	void add (String title, String body)
	{
		System.out.print("게시물 제목을 입력해주세요 : ");
		title = sc2.nextLine();
		
		System.out.print("게시물 내용을 입력해주세요 : ");
		body = sc2.nextLine();
		
		System.out.println("게시물이 등록 되었습니다.");
	}
}

//class List {
//	ArrayList<String> title = new ArrayList<>();
//	ArrayList<String> body = new ArrayList<>();
//	List(String t, String s)
//	{
//		title.add(t);
//		body.add(s);
//		
//	}
//	
//	void show_list()
//	{
//		for(int i = 0; i < title.size(); i++)
//		{
//			System.out.println("제목 : " + title.get(i));
//			System.out.println("내용 : " + body.get(i));
//		}
//	}
//}