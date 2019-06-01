using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._03._26
{
    class Base
    {
        public void MethodA()
        {
            Console.WriteLine("Base Method()");
        }
    }

    class MethodHide : Base
    {
        new public void MethodA()
        {
            Console.WriteLine("MethodHide Method()");  // Warning, Hiding an inherited name  :  new를 추가하면 오류가 사라짐
        }

        public static void Main()
        {
            MethodHide m = new MethodHide();
            m.MethodA();
        }
    }
}
