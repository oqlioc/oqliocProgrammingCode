using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class MultiCatchTest
    {
        public static void Main()
        {
            int[] a = { 1, 11, 22, 33};
            int[] b = { 0, 1, 2};

            for (int y = 0;  y < a.Length; y++ )
            {
                try
                {
                    Console.WriteLine(a[y] + " / " + b[y] + " = " + a[y] / b[y]);
                }
                catch (DivideByZeroException)
                {
                    Console.WriteLine("0으로 나눌 수 없습니다!");
                }
                catch (Exception e)
                {
                    Console.WriteLine(e);
                }
            }
        }
    }
}
