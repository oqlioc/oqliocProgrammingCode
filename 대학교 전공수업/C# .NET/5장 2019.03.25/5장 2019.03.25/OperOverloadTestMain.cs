using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._03._25
{
    class Top
    {
        public int a = 0;
        public int b = 0;

        public Top(int a, int b)
        {
            this.a = a;
            this.b = b;
        }
        public static Top operator +(Top t1, Top t2)
        {
            int m = t1.a + t2.a;
            int n = t1.b + t2.b;
            return new Top(m, n);
        }
    }

    class OperOverloadTestMain
    {
        public static void Main()
        {
            Top s1 = new Top(3, 5);
            Top s2 = new Top(7, 16);
            Top s3 = s1 + s2;
            Console.WriteLine("a값의 합은 " + s3.a + "입니다");
            Console.WriteLine("b값의 합은 " + s3.b + "입니다");
        }
    }
}
