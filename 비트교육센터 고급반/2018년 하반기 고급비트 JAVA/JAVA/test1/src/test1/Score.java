package test1;

import java.util.Scanner;

public class Score {
	
		public Scanner scan;
		public String name;
		public int kor;
		public int eng;
		public int math;
		public float avg;
		


		public void scrinput()
		{
			System.out.println("�л� �̸� : ");
			setname(scan.next());		//name = scan.next();
			
			System.out.println("���� ���� : ");
			setkor(scan.nextInt());		//kor = scan.nextInt();
			
			System.out.println("���� ���� : ");
			seteng(scan.nextInt());		//eng = scan.nextInt();
			
			System.out.println("���� ���� : ");
			setmath(scan.nextInt());	//math = scan.nextInt();
			
			setavg(kor, eng, math);
		}
		
		public void setname(String name)
		{
			this.name = name;
		}
		public String getname()
		{
			return name;
		}
		public void setkor(int kor)
		{
			this.kor = kor;
		}
		public int getkor()
		{
			return kor;
		}
		public void seteng(int eng)
		{
			this.eng = eng;
		}
		public int geteng()
		{
			return eng;
		}
		public void setmath(int math)
		{
			this.math = math;
		}
		public int getmath()
		{
			return math;
		}
		public void setavg(float kor, float eng, float math)
		{
			this.avg = (kor+eng+math)/3.f;
		}
		public float getavg()
		{
			return avg;
		}
	}

