using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace _5장_2019._04._16
{
    public class Shape
    {
        public virtual void Draw()
        {
            Console.WriteLine("모양없음");
        }
    }

    public class Circle : Shape
    {
        public override void Draw()
        {
            Console.WriteLine("원을 그립니다.");
        }
    }

    public class Rect : Shape
    {
        public override void Draw()
        {
            Console.WriteLine("사각형을 그립니다.");
        }
    }

    public class Tri : Shape
    {
        public override void Draw()
        {
            Console.WriteLine("삼각형을 그립니다.");
        }
    }

    public class ShapeSet
    {
        private ArrayList arList = new ArrayList();
        public void AddShape(Shape s)
        {
            arList.Add(s);
        }

        public void DrawAllShape()
        {
            foreach (Shape s in arList)
            {
                s.Draw();
            }
        }
    }

    class ShapeSetMain
    {
        static void Main(string[] args)
        {
            ShapeSet ss = new ShapeSet();
            ss.AddShape(new Circle());
            ss.AddShape(new Rect());
            ss.AddShape(new Circle());
            ss.AddShape(new Circle());
            ss.AddShape(new Rect());
            ss.AddShape(new Tri());
            ss.AddShape(new Tri());
            ss.DrawAllShape();
        }
    }
}