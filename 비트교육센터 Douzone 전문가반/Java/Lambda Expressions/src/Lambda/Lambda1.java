package Lambda;

import java.util.Comparator;

public class Lambda1 {

	public static void main(String[] args) {
		int a=10;
		int b=11;
		Comparator<Integer> comparator = new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
			
		};
		System.out.println(comparator.compare(a, b));
		
	}

}
