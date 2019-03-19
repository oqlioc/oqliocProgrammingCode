using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Struct_Person
{
    class break문
    {
        static void Main(string[] args)
        {
            int i, j;

            for (i = 1; i < 10; i++)
            {
                for (j = 1; j < 10; j++)
                {
                    Console.Write("{0} * {1} = {2} \n", i, j, i * j);

                    if (i == j)
                    {
                        break;
                    }
                }
                Console.WriteLine();
            }
        }
    }
}
