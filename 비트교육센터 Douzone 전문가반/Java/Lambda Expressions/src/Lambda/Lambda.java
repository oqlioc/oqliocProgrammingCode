package Lambda;

@FunctionalInterface
interface CustomOper {
	public int operate(int a, int b);
}

public class Lambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 자체 생성한 ArithmeticOperator 인터페이스를 사용하는 경우
		CustomOper plusOperator = (a, b) -> a + b;
		
		CustomOper minusOperator = (a, b) -> a - b;
		
		CustomOper multiplyOperator = (a, b) -> a * b;
		
		CustomOper divideOperator = (a, b) -> {
			if (b == 0) {
				b = 1;
			}
			return a / b;
		};
		
		CustomOper spareOperator = (a, b) -> {
			if (b == 0) {
				b = 1;
			}
			return a % b;
		};
		
		int a = 100;
		int b = 10;

		System.out.println(plusOperator.operate(a, b));
		System.out.println(minusOperator.operate(a, b));
		System.out.println(multiplyOperator.operate(a, b));
		System.out.println(divideOperator.operate(a, b));
		System.out.println(spareOperator.operate(a, b));
	}

}
