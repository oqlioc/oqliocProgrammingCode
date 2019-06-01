using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._04._08
{
    class Base
    {
        public void Method()
        {
            Console.WriteLine("Base Method()");
        }
    }

    class MethodHide: Base
    {
        new public void MethodA()
        {
            Console.WriteLine("MethodHide Method()");  //Warning, hiding an inherited name
        }

        static void Main(string[] args)
        {
            MethodHide m = new MethodHide();
            m.MethodA();
        }
    }

}
