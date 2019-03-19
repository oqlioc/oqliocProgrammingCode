using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Struct_Person
{
    class Class1
    {
        static void Main(string[] args)
        {
            Console.WriteLine("알고 싶은 등급은? : ");
            int age = Int32.Parse(Console.ReadLine());

            if ((age >= 10) && (age < 20))
            {
                Console.WriteLine("10대 입니다.");
            }
            else if ((age >= 20) && (age < 30))
            {
                Console.WriteLine("20대 입니다.");
            }
            else if ((age >= 30) && (age < 40))
            {
                Console.WriteLine("30대 입니다.");
            }
            else if ((age >= 40) && (age < 50))
            {
                Console.WriteLine("40대 입니다.");
            }
            else
            {
                Console.WriteLine("기타 입니다.");
            }
        }
    }
}
