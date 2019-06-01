using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._04._15
{
    class Base
    {
        public void FuncA()
        {
            Console.WriteLine("Base.FuncA");
        }
        public virtual void FuncB()
        {
            Console.WriteLine("Base.FuncB");
        }
    }

    class Derived : Base
    {
        new public void FuncA()
        {
            Console.WriteLine("Derived.FuncA");
        }
        public override void FuncB()
        {
            Console.WriteLine("Derived.FuncB");
        }
    }
    class Upcassting
    {
        static void Main(string[] args)
        {
            Derived d = new Derived();
            d.FuncA();  // new를 이용하여 재정의
            d.FuncB();  // virtual과 override를 이용하여 재정의
            Base a = d;
            a.FuncA();  // new를 이용하여 재정의
            a.FuncB();  // virtual과 override를 이용하여 재정의
        }
    }
}