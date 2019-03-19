using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3장_2019._03._18
{
    class Stack_Frame
    {
        public static int Sum(int a, int b)
        {
            int c = a + b;
            return c;
        }

        public static void Main()
        {
            int x = 10;
            int y = 20;
            int z = Sum(x, y);
            Console.WriteLine("z = {0}", z);
        }
    }
}
