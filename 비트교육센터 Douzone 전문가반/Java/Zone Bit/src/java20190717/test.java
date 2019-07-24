package java20190717;

class Ap {
	static void func1() { // 프로젝트 시작 시 메모리 생성
		System.out.println("Ap func1 call");
		func2();
	}

	static void func2() {
		System.out.println("Ap func2 call");
	}

	static void func3(int num) {
		String numString;
		numString = Integer.toBinaryString(num);

		int count = 0;
		int numStringLen = numString.length() / 4;

		for (int i = 0; i < numStringLen; i++) {
			if (i == 0) {
				System.out.print("00");
				for (int j = 0; j < 2; j++) {
					System.out.print(numString.charAt(count));
					count = count + 1;
				}
			}

			if (i != 0) {
				for (int j = 0; j < 4; j++) {
					System.out.print(numString.charAt(count));
					count = count + 1;
				}
			}

			System.out.print(" ");
		}

	}

	static void func4(int hexnum) {
		String hex = Integer.toHexString(hexnum);
		int num;

		for (int i = 0; i < hex.length(); i++) {
			num = 0;

			switch (hex.charAt(i)) {
			case 'a':
				num = 10;
				break;
			case 'b':
				num = 11;
				break;
			case 'c':
				num = 12;
				break;
			case 'd':
				num = 13;
				break;
			case 'e':
				num = 14;
				break;
			case 'f':
				num = 15;
				break;
			default:
				num = hex.charAt(i) - '0';
				break;
			}

			String bin = Integer.toBinaryString(num);
			if (bin.length() < 4) {
				for (int j = bin.length(); j < 4; j++) {
					bin = '0' + bin;
				}
			}
			System.out.println(bin);
		}
		System.out.println();
	}

	static void func5(int num) {
		String s = "호랑이"; // 데이터 갱신 불가
		System.out.println(s.hashCode());
		s = "코끼리"; // 객체 새로 생성
		System.out.println(s.hashCode());
		// ---------------------------------------------------------
		System.out.println(Integer.toBinaryString(num)); // 2진수로 만듬

		String s1 = Integer.toBinaryString(num);
		s1.length();

		char ar[] = new char[32 - s1.length()]; // 자릿수 만들 배열 생성

		for (int i = 0; i < ar.length; i++) { // 남은 자리에 0넣는다
			ar[i] = '0';
		}

		String s2 = new String(ar);
		System.out.println(s2);
		//String s3 = s1 + s2; // 32자리 생성

		StringBuffer s4 = new StringBuffer(s2 + s1);
		System.out.println(s4 + "  자릿수는 : " + s4.length());

		for (int i = 0; i < 7; i++) {
			s4.insert((7 - i) * 4, ' ');
		}

		System.out.println(s4);
	}

}

public class test {
	void func1() { // main에서 사용 불가능
		System.out.println("Ap func1 call");
	}

	static void func2() { // main에서 사용 가능
		System.out.println("Ap func1 call");
	}

	public static void main(String[] args) {
		//short a = 3;
		//b = (short) (a + 1); // 대입 연산자는 타입이 같아야한다
		// 사칙연산은 int로 취급한다
		// ---------------------------------------------------------
		// Example 1
		//long a1 = 10;
		//int b1 = 0;

		//b1 = (int) (a1 + 1);

		// System.out.println(Integer.MAX_VALUE);
		// System.out.println(Integer.toHexString(1234)); // 16진수
		// System.out.println(Integer.toHexString(Integer.MAX_VALUE));

		// 0011 1100 1001 0100 1010 1011 0111 0011
		// int a2 = 0376; // 0...가 8진수라서
		// int b2 = 00037; // 8진수로 인식
		// ---------------------------------------------------------
		// Ap.func3(0x3c94ab73);
		Ap.func5(0x3c94ab73);
	}
}