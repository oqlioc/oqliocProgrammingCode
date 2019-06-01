using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Animal
    {
        private string kind;
        private string name;

        public Animal(string kind, string name)
        {
            this.kind = kind;
            this.name = name;
        }

        public override string ToString()
        {
            return kind + ":" + name;
        }

    }

    class ObjectArray
    {
        static void Main(string[] args)
        {
            Animal[] a = new Animal[3];

            a[0] = new Animal("개", "진돌이");
            a[1] = new Animal("고양이", "나비");
            a[2] = new Animal("돼지", "꿀꿀이");

            for (int i = 0; i < a.Length; i++)
                try
                {
                    Console.WriteLine("Animal[{0}] : {1}, HashCode : {2}", i, a[i], a[i].GetHashCode());
                }
                catch (NullReferenceException e)
                {
                    Console.WriteLine(e);
                }
        }
    }
}