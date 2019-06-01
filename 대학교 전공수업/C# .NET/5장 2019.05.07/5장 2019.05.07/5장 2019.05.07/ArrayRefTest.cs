using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._05._07
{
    class ArrayRefTest
    {
        public void Print(String arrayName, int index, int value)
        {
            Console.WriteLine(arrayName + "[" + index + "] : " + value + '\t');
        }

        public static void Main()
        {
            ArrayRefTest a = new ArrayRefTest();
            int[] mydream = new int[] { 1, 2, 3, 4, 5, 6 };
            int[] myref1 = mydream;
            int[] myref2 = myref1;
            myref1[2] = 30;
            myref1[3] = 40;
            myref2[4] = 500;
            myref2[5] = 600;

            for (int i = 0;  i < 6; i++)
            {
                a.Print("mydream : ", i, mydream[i]);
                a.Print("myref1 : ", i, myref1[i]);
                a.Print("myref2 : ", i, myref2[i]);
                Console.WriteLine();
            }
        }
    }
}
