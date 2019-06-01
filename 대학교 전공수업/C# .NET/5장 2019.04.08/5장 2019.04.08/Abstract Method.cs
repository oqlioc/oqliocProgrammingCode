using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._04._08
{
    abstract class A
    {
        public abstract void F1();
        public abstract void F2();
    }

    class B : A  // 추상클래스를 상속 받으면 추상메서드를 재정의 해야함 (오버라이딩)
    {
        public override void F1()
        {
            Console.WriteLine("B클래스 F2()");
        }

        public override void F2()
        {
            Console.WriteLine("B클래스 F1()");
        }
    }

    class Abstract_Method
    {
        public static void Main()
        {
            B b = new B();
            b.F1();
        }
    }
}
