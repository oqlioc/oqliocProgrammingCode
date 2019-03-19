using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Struct_Person
{
    class switch문
    {
        static void Main(string[] args)
        {
            int btn;
            btn = 2;
            switch (btn)
            {
                case 1:
                    //Console.WriteLine("btn 1");
                    //break;
                case 2:
                    //Console.WriteLine("btn 2");
                    //break;
                case 3:
                    Console.WriteLine("btn 1, 2, 3일 경우");
                    //Console.WriteLine("btn 3");
                    break;
                default:
                    Console.WriteLine("btn이 1, 2, 3이 아닐 경우 ");
                    break;
            }
        }
    }
}
