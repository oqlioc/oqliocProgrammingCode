using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._04._08
{
    class ThisTest
    {
        private int number;
        private string name;

        public ThisTest(string name, int number)
        {
            this.name = name;
            this.number = number;
        }

        public void Print()
        {
            Console.WriteLine("-- this를 이용한 멤버 테스트---");
            Console.WriteLine("name:" + this.name + " number." + this.number);
        }

        public void MyPrint()
        {
            Console.WriteLine("-- this를 이용한 메서드 테스트 ---");
            this.Print();
        }

        public static void Main()
        {
            ThisTest th = new ThisTest("홍길동", 20);
            th.Print();
            th.MyPrint();
        }
    }
}
