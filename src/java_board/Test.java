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
			System.out.print("��ɾ� �Է� : ");
			
			String s = sc.next(); // �Է�
			
			
			if(s.equals("add"))
			{
				//a.add(title, body);
				System.out.print("�Խù� ������ �Է����ּ��� : ");
				title.add(sc.nextLine());
				
				System.out.print("�Խù� ������ �Է����ּ��� : ");
				body.add(sc.nextLine());
				
				System.out.println("�Խù��� ��� �Ǿ����ϴ�.");
				//System.out.println("title = " + title.get() + "body = " + body);
			}
			
			else if(s.equals("list"))
			{
				//List l = new List(title, body);
				//l.show_list();
				for(int i = 0; i < title.size(); i++)
					{
						System.out.println("���� : " + title.get(i));
						System.out.println("���� : " + body.get(i));
					}
			}
			
			else if(s.equals("exit"))
			{
				Exit e = new Exit();
				loop = e.exit(s, loop); // ����
			}
			
		}
		
		
		
	}

}

class Exit {
	boolean exit (String s, boolean loop)
	{
		if(s.equals("exit"))
		{
			System.out.println("����");
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
		System.out.print("�Խù� ������ �Է����ּ��� : ");
		title = sc2.nextLine();
		
		System.out.print("�Խù� ������ �Է����ּ��� : ");
		body = sc2.nextLine();
		
		System.out.println("�Խù��� ��� �Ǿ����ϴ�.");
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
//			System.out.println("���� : " + title.get(i));
//			System.out.println("���� : " + body.get(i));
//		}
//	}
//}