package test1;

import java.util.Scanner;

public class Room 
{
		private int csnum;
		Student std[];
		Scanner scan;
		
		Room()
		{
			scan = new Scanner(System.in);
			csnum = 0;
		}
		
		public void clscount()
		{
			System.out.println("���� �� : ");
			csnum = scan.nextInt();
			std = new Student[csnum];
		}
		
		public void clsname()
		{
			for(int i = 0; i < csnum; i++)
			{
				System.out.println(" �� �̸� : ");
//				String csname;
//				csname = scan.next();
				std[i].scan.next();
			}
		}
		
		public void print()
		{
			for(int i = 0; i < csnum; i++)
			{
				System.out.println(" �� �̸� : " + std[i]);
			}
		}
}

