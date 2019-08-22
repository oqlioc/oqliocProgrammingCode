package java20190718;
//-------------------------------------------------------------------------------------------------

//Example 1
//인터페이스 익명클래스 생성
//interface Apple{
//   void func1();
//}
//
//public class Lambda {
//   public static void main(String args[]) {
//      Apple a = new Apple() {
//         
//         @Override
//         public void func1() {
//            // TODO Auto-generated method stub
//            System.out.println("Apple func1 Call.");
//         }
//      };
//      
//      a.func1();
//   }
//}
//-------------------------------------------------------------------------------------------------
//Example 2
//인터페이스 익명클래스를 람다식으로 변경 1
//interface Apple{
//   void func1();
//}
//
//public class Lambda {
//   public static void main(String args[]) {
//      // 기존모양.
//      Apple a = /* new Apple */() -> {
////         @Override
////         public void func1() {
//            // TODO Auto-generated method stub
//            System.out.println("Apple func1 a Call.");
////         }
//      };
//      
//      //줄인모양
//      Apple b = () -> {
//         System.out.println("Apple func1 b Call.");
//      };
//      
//      a.func1();
//   }
//}
//-------------------------------------------------------------------------------------------------
//Example 3
//interface Apple{
//   void func1(int num);
//}
//
//public class Lambda {
//   public static void main(String args[]) {
//      //인수 전달시 기본적으로 Interface상 인자이름과 동일하게 하는게 법칙.
//      Apple a = (num) -> {
//         System.out.println("Get Data : " + num);
//      };
//      
//      //전달 인수가 한 개일 때만, 괄호를 생략할 수 있다.
//      //인수전달이 없거나, 2개 이상일 경우 괄호를 해야한다.
//      //이러한 형태가 주로 나온다.
//      Apple b = num -> {
//         System.out.println("Get Data : " + num);
//      };
//      
//      //실행되는 소스코드가 단문장일 경우 {}(Scope)를 생략할 수 있다.
//      Apple c = num -> System.out.println("Get Data : " + num);
//      
//      a.func1(10);
//   }
//}
//-------------------------------------------------------------------------------------------------
//Example 4
//Labmda에서 인수가 2개일 때
//interface Apple{
//   void func1(int num, String s);
//}
//
//public class Lambda {
//   public static void main(String args[]) {
//      Apple a = (num, s) -> {
//         System.out.println("Get Integer : " + num);
//         System.out.println("Get String : " + s);
//      };
//      
//      a.func1(10, "Hellow Wolrd!");
//      
//   }
//}
//-------------------------------------------------------------------------------------------------
//Example 5
//interface Apple{
//   int func1();
//}
//
//public class Lambda {
//   public static void main(String args[]) {
//      Apple a = () ->{
//         return 100;
//      };
//      
//      //단문장일 때 Scope를 생략할 수 있는 return까지 같이 없애햐 가능하다.
//      //실전에선 이러한 형태가 주로 사용된다.
//      Apple b = () -> 100;
//      
//      //IIFE 함수안에 함수가 표함됨.
//      //Apple c = () -> 100 -> 200;
//   }
//}
//-------------------------------------------------------------------------------------------------
//Example 6
//interface Apple{
//   int func1(int num);
//}
//
//public class Lambda {
//   public static void main(String args[]) {
//      Apple a = (num) ->{
//         return 200;
//      };
//      
//      //이러한 형태는 다른 Language에서 자주나오기 때문에 잘 익혀두어야 한다.
//      Apple b = num -> 200;
//   }
//}
//-------------------------------------------------------------------------------------------------
//Example 7
// interface Apple {
//       void func01(int n, String s);
// }

// class Banana {
//       void func02(Apple apple) {
//          apple.func01(10, "Hello");
//          }
// }

// public class test {
//       public static void main(String[] args) {
//          Banana b = new Banana();

//          //익명 객체로 구현한 방식
//          b.func02(new Apple() {
//             @Override
//             public void func01(int n, String s) {
//                System.out.println("Get Data : " + n + " " + s);
//             }
//          });

//          //Lambda 방식으로 구현
//          b.func02((n, s) -> {
//             System.out.println("Banana func2 Call.");
//          });
//    }
// }
//-------------------------------------------------------------------------------------------------
//Example 8
// interface A {
//    void func1();
// }
// interface B {
//    A func2();
// }
// public class test {
//    public static void main(String[] args) {
//       // 1단계
//       B b1 = new B() {

//          @Override
//          public A func2() {
//             return new A() {

//                @Override
//                public void func1() {
//                   System.out.println("A func1 11111111111111111");
//                }
//             };
//          }
//       };
//       b1.func2().func1();

//       // 2단계
//       B b2 = () -> {
//          return new A() {

//             @Override
//             public void func1() {
//                System.out.println("A func1 22222222222222222");
//             }
//          };
//       };
//       b2.func2().func1();

//       // 3단계
//       B b3 = () -> () -> System.out.println("A func1 33333333333333333");
//       b3.func2().func1();
//    }
// }
//-------------------------------------------------------------------------------------------------
public interface T {
   void func1();
}

public class test {
   public static void main(String[] args) {
      System.out.println("11111111111111111");

      try {
         Thread.sleep(2000);
         System.out.println("호랑이");
      } catch (Exception e) {
      }

      System.out.println("22222222222222222");

      System.out.println("11111111111111111");

      try {
         Thread.sleep(2000);
         System.out.println("코끼리");
      } catch (Exception e) {
      }

      System.out.println("22222222222222222");

      System.out.println("11111111111111111");

      try {
         Thread.sleep(2000);
         System.out.println("독수리");
      } catch (Exception e) {
      }

      System.out.println("22222222222222222");

      // System.out.println("11111111111111111");

      // try {
      // Thread.sleep(2000);
      // System.out.println("호랑이");
      // } catch (Exception e) {
      // }

      // System.out.println("22222222222222222");

      // System.out.println("11111111111111111");

      // try {
      // Thread.sleep(2000);
      // System.out.println("코끼리");
      // } catch (Exception e) {
      // }

      // System.out.println("22222222222222222");

      // System.out.println("11111111111111111");

      // try {
      // Thread.sleep(2000);
      // System.out.println("독수리");
      // } catch (Exception e) {
      // }

      // System.out.println("22222222222222222");

   }
}
