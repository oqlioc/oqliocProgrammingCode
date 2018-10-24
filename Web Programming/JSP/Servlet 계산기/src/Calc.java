
public class Calc {

   int num1;
   int num2;
   String op;
   
   Calc(int num1, int num2, String op) {   
      this.num1 = num1;
      this.num2 = num2;
      this.op = op;
   }
   
   int getResult() {
      
      int result = 0;
         if(op.equals("+")) {
            result = num1 + num2;
         } else if(op.equals("-")) {
            result = num1 - num2;
         } else if(op.equals("*")) {
            result = num1 * num2;
         } else if(op.equals("/")) {
            result = num1 / num2;
         }
         
         return result;
   }
}