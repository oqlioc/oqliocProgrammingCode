package test1;

import java.util.Scanner;

public class Student {
	
		private int psnum;
		Scanner scan;
		String stdname;
		Score scr[];
		
		
		Student()
		{
			scan = new Scanner(System.in);
			psnum = 0;
		}
		
		public void stucount()
		{
			System.out.println("ÇÐ»ý ¼ö : ");
			psnum = scan.nextInt();
			
			scr = new Score[psnum];
		}
		
		public void stdinput()
		{
			for(int i = 0; i < psnum; i++)
			{
				scr[i].scrinput();
			}
		}
		
		
	}

