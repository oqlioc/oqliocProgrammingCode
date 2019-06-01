using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._03._25
{
    public class GrandFather
    {
        public GrandFather()
        {
            Console.WriteLine("I an a GrandFather");
        }

        public void SayGrandFather()
        {
            Console.WriteLine("SayGrandFather()");
        }
    }

    public class Father : GrandFather
    {
        public Father()
        {
            Console.WriteLine("I an a Father");
        }

        public void SayFather()
        {
            Console.WriteLine("SayFather()");
        }
    }

    public class Child : Father
    {
        public Child()
        {
            Console.WriteLine("I an a Child");
        }

        public void SayChild()
        {
            Console.WriteLine("SayChild()");
        }
    }

    class InheritanceTest
    {
        public static void Main()
        {
            Child C = new Child();
            C.SayGrandFather();  // 할아버지의 메서드 호출
            C.SayFather();  // 아버지의 메서드 호출
            C.SayChild();  // 아드르이 메서드 호출
        }
    }
}
