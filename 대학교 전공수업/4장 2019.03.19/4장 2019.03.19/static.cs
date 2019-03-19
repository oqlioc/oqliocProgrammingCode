using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _4장_2019._03._19
{
    public class StaticTest
    {
        private static int sint = 0;
        private int nint = 0;

        public StaticTest(){
            sint = sint + 1;
            nint = nint + 1;
        }

        public void SayMember(){
            Console.WriteLine("sint : {0}, nint : {1}", sint, nint);
        }

        static void Main()
        {
            for(int i = 0; i < 10; i++){
                StaticTest s = new StaticTest();
                s.SayMember();
            }
        }
    }
}
