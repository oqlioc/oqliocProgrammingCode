using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3장_2019._03._19
{
    class Call_By_Reference
    {
        static void CallByVal(ref int x)
        {
            x = 10000;
        }

        static void Main(string[] args)
        {
            int x1 = 10;  // 참조할 변수는 초기화가 되어있어야한다.
            CallByVal(ref x1);  // ref : 값이 아닌 주소
            Console.WriteLine("Call-By-Value : {0}", x1);
        }
    }
}
