using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3장_2019._03._19
{
    class Program
    {
        static void CallByVal(int x)
        {
            x = 10000;
        }

        static void Main(string[] args)
        {
            int x1 = 10;
            CallByVal(x1);
            Console.WriteLine("Call-By-Value : {0}", x1);
        }
    }
}
