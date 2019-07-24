package java20190711;

public class java20190711 {
	public static void main(String[] args) {

//		int a = 10;
//		int b;

//		if (a > 0) {
//			b = 3;
//		} else {
//			b = 4;
//		}
//		b = (a > 0) ? 3 : 4;
//		
//		if (a > 0){
//			System.out.println("ȣ����");
//		}else {
//			System.out.println("�ڳ���");
//		}
//		System.out.println( a > 0 ? "ȣ����" : "�ڳ���" );

//		int a = 1, b = 2, c = 3;
//		int a = 1, b = 3, c = 2;
		int a = 2, b = 1, c = 3;
//		int a = 2, b = 3, c = 1;
//		int a = 3, b = 1, c = 2;
//		int a = 3, b = 2, c = 1;

//		int x;
//		
//		if (a>b && b>c || a<b && b<c) {
//			System.out.println(b);
//		}else if(b>a && a>c || b<a && a<c){
//			System.out.println(a);
//		}else if(a>c && c>b || a<c && c<b){
//			System.out.println(c);
//		}
//		
//		x = a>b && b>c || a<b && b<c ? 
//				b :b>a && a>c || b<a && a<c ? 
//						a : a>c && c>b || a<c && c<b ? 
//								c : 0;
//		System.out.println(x);

		int n;

		if (a > b) { // a�� �ִ� �ƴϸ� �̵�
			if (a > c) { // a�� �ִ�
				if (b > c) { // b�� �̵�

				} else { // c�� �̵�

				}
			} else { // a�� �̵�

			}
		} else { // a�� �ּ� �ƴϸ� �̵�
			if (a > c) { // a�� �̵�

			} else { // a�� �ּ�
				if (b > c) { // c�� �̵�

				} else { // b�� �̵�

				}
			}
		}

		if (a > b) { // a�� �ִ� �ƴϸ� �̵�
			if (a > c) { // a�� �ִ�
//				if (b > c) { // b�� �̵�
//					n = b;
//				} else { // c�� �̵�
//					n = c;
//				}
//				n = b > c ? b:c;
				n = Math.max(b, c);
			} else { // a�� �̵�
				n = a;
			}
		} else { // a�� �ּ� �ƴϸ� �̵�
			if (a > c) { // a�� �̵�
				n = a;
			} else { // a�� �ּ�
//				if (b > c) { // c�� �̵�
//					n = c;
//				} else { // b�� �̵�
//					n = b;
//				}
				n = Math.min(b, c);
			}
		}

		if (a > b) { // a�� �ִ� �ƴϸ� �̵�
//			if (a > c) { // a�� �ִ�
////				if (b > c) { // b�� �̵�
////					n = b;
////				} else { // c�� �̵�
////					n = c;
////				}
////				n = b > c ? b:c;
//				n = Math.max(b, c);
//			} else { // a�� �̵�
//				n = a;
//			}
			n = a > b ? n = Math.max(b, c) : a;
		} else { // a�� �ּ� �ƴϸ� �̵�
//			if (a > c) { // a�� �̵�
//				n = a;
//			} else { // a�� �ּ�
////				if (b > c) { // c�� �̵�
////					n = c;
////				} else { // b�� �̵�
////					n = b;
////				}
//				n = Math.min(b, c);
//			}
			n = a > c ? a : Math.min(b, c);
		}
		
//		if (a > b) { // a�� �ִ� �ƴϸ� �̵�
////			if (a > c) { // a�� �ִ�
//////				if (b > c) { // b�� �̵�
//////					n = b;
//////				} else { // c�� �̵�
//////					n = c;
//////				}
//////				n = b > c ? b:c;
////				n = Math.max(b, c);
////			} else { // a�� �̵�
////				n = a;
////			}
//			n = a > c ? n = Math.max(b, c) : a;
//		} else { // a�� �ּ� �ƴϸ� �̵�
////			if (a > c) { // a�� �̵�
////				n = a;
////			} else { // a�� �ּ�
//////				if (b > c) { // c�� �̵�
//////					n = c;
//////				} else { // b�� �̵�
//////					n = b;
//////				}
////				n = Math.min(b, c);
////			}
//			n = a > c ? a : Math.min(b, c);
//		}
		
		n = (a > b) ? 
				(a > c ? n = Math.max(b, c) : a)
				: 
				(a > c ? a : Math.min(b, c));
				System.out.println(n);
		
	}
}
