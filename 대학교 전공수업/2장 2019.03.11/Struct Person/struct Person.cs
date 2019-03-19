using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

struct Person
{
    public int num;
    public int age;
    public double height;
    public float weigth;
}

namespace Struct_Person
{
    class Program
    {
        static void Main(string[] args)
        {
            Person t;
            t.num = 1000;
            t.age = 20;
            t.height = 165.3D;
            t.weigth = 51.0F;
            Person s = t;

            Console.WriteLine("t.num = {0}", t.num);
            Console.WriteLine("t.age = {0}", t.age);
            Console.WriteLine("t.height = {0}", t.height);
            Console.WriteLine("t.weigth = {0}", t.weigth);

            Console.WriteLine("s.num = {0}", s.num);
            Console.WriteLine("s.age = {0}", s.age);
            Console.WriteLine("s.height = {0}", s.height);
            Console.WriteLine("s.weigth = {0}", s.weigth);
        }
    }
}
