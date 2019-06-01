using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class FinallyTest
    {
        static void Main(string[] args)
        {
            int[] exArray = new int[2];

            try
            {
                exArray[0] = 0;
                exArray[1] = 1;

                for (int i = 0; i < exArray.Length; i++)
                {
                    Console.WriteLine("exArray[" + i + "] = " + exArray[i]);
                }
            }
            catch (IndexOutOfRangeException e)
            {
                Console.WriteLine(e);
            }
            finally
            {
                Console.WriteLine("첫번째 finally문을 수행한다.");
                Console.WriteLine("");
            }
            
            try
            {
                exArray[2] = 2;
                Console.WriteLine("exArray[2] = " + exArray[2]);
            }
            catch (IndexOutOfRangeException e)
            {
                Console.WriteLine(e);
            }
            finally
            {
                Console.WriteLine("두번째 finally문 입니다.");
            }
        }
    }
}
