using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class NewExceptionTest
    {
        public static void Main()
        {
            Console.WriteLine("1. 프로그램 시작");

            try
            {
                throw new BadImageFormatException();
            }
            catch (Exception e)
            {
                Console.WriteLine("2. 예외 정보 출력");
                Console.WriteLine(e);
            }

            Console.WriteLine("3. 프로그램 종료");
        }
    }
}
