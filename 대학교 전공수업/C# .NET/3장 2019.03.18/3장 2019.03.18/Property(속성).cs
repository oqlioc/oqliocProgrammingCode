using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class PropTest
{
    private string name;

    public string Name
    {
        get
        {
            return name;
        }

        set
        {
            name = value + " 님 반갑습니다.";
        }
    }
}

namespace _3장_2019._03._18
{
    class Class1
    {
        static void Main(string[] args)
        {
            PropTest pt = new PropTest();
            pt.Name = "홍길동";
            string na = pt.Name;
            Console.WriteLine("이름 : {0}", na);
        }
    }
}
