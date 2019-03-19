using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3장_2019._03._18
{
    class Person
    {
        public int age;
        public float height;
        private float weight;
    }

    class Program
    {
        static void Main(string[] args)
        {
            Person brother = new Person();

            brother.age = 100;
            brother.height = 170.0F;
            // brother.weight = 67.0F;  // private 멤버 접근 - 에러
            Console.WriteLine("age: " + brother.age);
            Console.WriteLine("height: " + brother.height);
            // Console.WriteLine("weight: " + brother.weight);  // private 멤버 접근 - 에러
        }
    }
}
