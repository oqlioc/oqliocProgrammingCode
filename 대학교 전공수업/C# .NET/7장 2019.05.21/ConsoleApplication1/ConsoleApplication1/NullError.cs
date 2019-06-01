using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class NullError
    {
        static void Main(string[] args)
        {
            string str = null;

            try
            {
                Console.WriteLine(str.ToString());  // str이 null이기 때문에 에러 발생
            }
            catch (NullReferenceException e)  // NullReferenceException이 발생하면 처리
            {
                Console.WriteLine(e.ToString());
            }

            Console.WriteLine("프로그램을 무사히 마칩니다.");
        }
    }
}