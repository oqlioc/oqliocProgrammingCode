using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._04._15
{
    class Shape
    {
        public virtual void Draw() { }
        public virtual void Delete() { }
    }

    class Circle : Shape
    {
        public override void Draw()
        {
            Console.WriteLine("원을 그립니다.") ;
        }
        public override void Delete()
        {
            Console.WriteLine("원을 지웁니다.");
        }
        public void SayCircle()
        {
            Console.WriteLine("안녕하세요. 원입니다.");
        }
    }

    class Triangle : Shape
    {
        public override void Draw()
        {
            Console.WriteLine("삼각형을 그립니다.");
        }
        public override void Delete()
        {
            Console.WriteLine("삼각형을 지웁니다.");
        }
        public void SayTriangle()
        {
            Console.WriteLine("안녕하세요. 삼각형입니다.");
        }
    }

    class Upcasting_Test
    {
        static void Main(string[] args)
        {
            Shape c1 = new Circle();
            c1.Draw();
            c1.Delete();
            //c1.SayCircle();  에러가 발생합니다.
            Circle c2 = (Circle)c1;
            c2.SayCircle();
            Console.WriteLine();

            Shape t1 = new Triangle();
            t1.Draw();
            t1.Delete();
            //c1.SayTriangle();  에러가 발생합니다.
            Triangle t2 = (Triangle)t1;
            t2.SayTriangle();
            Console.WriteLine();
        }
    }

}
