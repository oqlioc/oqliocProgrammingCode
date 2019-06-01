using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ConsoleApplication1
{
    class PathTest
    {
        static void Main(string[] args)
        {
            string E = "hello";
            string F = "hello";
            Console.WriteLine(E.Equals(F)); //True 
            Console.WriteLine(Object.Equals(E, F)); //True 
            Console.WriteLine(Object.ReferenceEquals(E, F)); //True 
        }
    }
}
