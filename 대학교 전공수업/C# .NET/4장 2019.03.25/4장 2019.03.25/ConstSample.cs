using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _4장_2019._03._25
{
    class ConstSample
    {
        public const int BOY = 8, MAN = BOY + 12;
    }

    public class ConstTest
    {
        public static void Main()
        {
            Console.WriteLine("BOY = " + ConstSample.BOY);
            Console.WriteLine("MAN = " + ConstSample.MAN);
        }
    }
}
