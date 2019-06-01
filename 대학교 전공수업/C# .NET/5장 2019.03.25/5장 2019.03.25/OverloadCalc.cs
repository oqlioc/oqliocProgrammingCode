using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._03._25
{
    class OverloadCalc
    {
        public int Plus(int a, int b)
        {
            return(a + b);
        }

        public float Plus(float a, float b)
        { 
            return(a + b);
        }

        public double Plus(double a, double b)
        {
            return (a + b);
        }

        static void Main(string[] args)
        {
            OverloadCalc oc = new OverloadCalc();
            int i = oc.Plus(3, 5);
            float j = oc.Plus(0.1f, 0.2f);
            double k = oc.Plus(0.5, 0.7);
            Console.WriteLine("int 합 : {0} ", i);
            Console.WriteLine("float 합 : {0} ", j);
            Console.WriteLine("double 합 : {0} ", k);
        }
    }
}