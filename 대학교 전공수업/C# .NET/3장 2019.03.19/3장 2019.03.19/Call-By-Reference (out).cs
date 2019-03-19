using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3장_2019._03._19
{
    class Call_By_Reference__out_
    {
        static void CallByVal(out int x)
        {
            x = 10000;
        }

        static void Main(string[] args)
        {
            int x1;  // 참조할 변수가 초기화되어있을 필요가 없다.
            CallByVal(out x1);
            Console.WriteLine("Call-By-Value : {0}", x1);
        }
    }
}
