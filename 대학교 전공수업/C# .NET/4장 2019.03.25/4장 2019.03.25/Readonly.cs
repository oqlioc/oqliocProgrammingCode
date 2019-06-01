using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _4장_2019._03._25
{
    class ReadonlyTest
    {
        public readonly static int STATIC_READONLY = 1;
        public readonly int NORMAL_READONLY = 1;

        static ReadonlyTest()
        {
            STATIC_READONLY = 100;
        }

        public ReadonlyTest()
        {
            NORMAL_READONLY = 10000;
        }

        public static void Main()
        {
            Console.WriteLine("STATIC_READONLY = " + ReadonlyTest.STATIC_READONLY);
            ReadonlyTest rt1 = new ReadonlyTest();
            Console.WriteLine("NORMAL_READONLY  = " + rt1.NORMAL_READONLY);
        }
    }
}
