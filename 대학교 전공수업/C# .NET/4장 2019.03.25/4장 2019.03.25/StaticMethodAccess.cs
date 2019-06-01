using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _4장_2019._03._25
{
    class StaticMethodAccess
    {
        private static int sint = 100;
        public int nint = 0;

        public static void SetStaticInt(int x)
        {
            sint = x;
        }

        public static int GetStaticInt()
        {
            return sint;
        }

        static void Main(string[] args)
        {
            StaticMethodAccess.SetStaticInt(33333);
            int s = StaticMethodAccess.GetStaticInt();
            Console.WriteLine("static값은 : " + s);
        }
    }
}
