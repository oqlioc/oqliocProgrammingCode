package test1;

import java.util.Scanner;

public class Test1 {
	
@SuppressWarnings("null")
	public static void main(String[] args) {
		//	TODO Auto-generated method stub
		
	Room room = new Room();
	room.clscount();
	room.clsname();
	room.print();
		/*
		Scanner scan = new Scanner(System.in);
		int csnum;
		int psnum;
		
		System.out.println("교실 수 : ");
		csnum = scan.nextInt();
		
		System.out.println("학생 수 : ");
		psnum = scan.nextInt();
		
		String name[][] = new String[csnum][psnum]; //{null, null, null};
		int kor[][] = new int[csnum][psnum]; //{0, 0, 0};
		int eng[][] = new int[csnum][psnum]; //{0, 0, 0};
		int math[][] = new int[csnum][psnum]; //{0, 0, 0};
		float avg[][] = new float[csnum][psnum]; //{0, 0, 0};
		
		for(int i = 0; i < csnum; i++)
		{
			for(int j = 0; j < psnum; j++)
			{
				System.out.println("학생 이름 : ");
				name[i][j] = scan.next();
				System.out.println("국어 점수 : ");
				kor[i][j] = scan.nextInt();
				System.out.println("영어 점수 : ");
				eng[i][j] = scan.nextInt();
				System.out.println("수학 점수 : ");
				math[i][j] = scan.nextInt();
				
				avg[i][j] = (kor[i][j]+eng[i][j]+math[i][j])/3.f;
			}
			
		}
		
		for(int i = 0; i < csnum; i++)
		{
			System.out.println((i+1)+"반");
			for(int j = 0; j < psnum; j++)
			{
				System.out.println("학생 이름 : "+name[i][j]);
				System.out.println("국어 점수 : "+kor[i][j]);
				System.out.println("영어 점수 : "+eng[i][j]);
				System.out.println("수학 점수 : "+math[i][j]);
				System.out.println("평       균: "+avg[i][j]);
			}
		}*/
	}
}

