using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._04._08
{
    class ThisSelf
    {
        private string name;
        private int age;

        public ThisSelf()  : this("이름 없음")
        {
            Console.WriteLine("매개변수가 없는 생성자");
        }

        public ThisSelf(string name) : this(name, -1)
        {
            Console.WriteLine("매개변수가 1개 있는 생성자");
        }

        public ThisSelf(string name, int age)
        {
            this.name = name;
            this.age = age;
            Console.WriteLine("name: " + name + " number: " + age);
            Console.WriteLine("매개변수가 2개있는 생성자");
        }

        public static void Main()
        {
            ThisSelf ts1 = new ThisSelf();
            ThisSelf ts2 = new ThisSelf("홍길동");
            ThisSelf ts3 = new ThisSelf("김삿갓", 50);
        }
    }
}
