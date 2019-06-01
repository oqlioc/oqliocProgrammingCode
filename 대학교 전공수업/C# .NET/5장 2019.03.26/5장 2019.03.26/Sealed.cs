using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._03._26
{
       sealed class SayFather
       {
           private int i = 0;
           public void SayFather()
           {
               Console.Write(i + "\t");
           }
       }

    class Sealed  // : Father
    {
        static void Main(string[] args)
        {
        }
    }
}
