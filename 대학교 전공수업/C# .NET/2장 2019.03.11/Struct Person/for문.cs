using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Struct_Person
{
    class for문
    {
        static void Main(string[] args)
        {
            int i = 0;
            int sum = 0;

            for (i = 0; i < 100; i++)
            {
                sum += i;
            }
            Console.WriteLine("sum = " + sum);
        }
    }
}
