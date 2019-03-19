using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Struct_Person
{
    class do_while문
    {
        static void Main(string[] args)
        {
            int i;

            do
            {
                Console.WriteLine("1 ~ 9 사이의 수를 입력하시오?");
                i = int.Parse(Console.ReadLine());
            }
            while (i <= 0 | i >= 10);

            Console.WriteLine("당신이 입력한 수는 {0}\n", i);
        }
    }
}
