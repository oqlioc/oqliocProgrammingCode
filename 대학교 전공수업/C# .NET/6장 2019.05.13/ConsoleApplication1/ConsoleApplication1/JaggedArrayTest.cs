using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class JaggedArrayTest
    {
        public static void Main()
        {
            int[][,] jagArray = new int[3][,];
            jagArray[0] = new int[2, 2] { { 3, 4 }, { 5, 6 } };

            jagArray[1] = new int[3, 2];
            jagArray[1][0, 0] = -1;
            jagArray[1][1, 0] = -3;
            jagArray[1][2, 0] = -5;
            jagArray[1][0, 1] = -2;
            jagArray[1][1, 1] = -4;
            jagArray[1][2, 1] = -6;

            jagArray[2] = new int[3, 3] { { 3, 4, 6 }, { 4, 5, 7 }, { 7, 8, 6 } };

            for (int a = 0; a < jagArray.Length; a++)
            {
                for (int b = 0; b < jagArray[a].GetLength(0); b++)
                {
                    for (int c = 0; c < jagArray[a].GetLength(1); c++)
                    {
                        Console.WriteLine("jagArray[" + a + "][" + b + "," + c + "]:" + jagArray[a][b, c] + '\t');
                    }
                    Console.WriteLine();
                }
                Console.WriteLine();
            }
        }
    }
}
