using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Struct_Person
{
    class continue문
    {
        static void Main(string[] args)
        {
            int i, sum = 0;

            for (i = 0; i < 100; i++)
            {
                if (i % 2 == 0)
                    continue;
                sum += i;
            }

            Console.WriteLine("홀수들의 합 = {0}\n", sum);
        }
    }
}
