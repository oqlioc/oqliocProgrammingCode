using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._03._26
{
    class ConstructorDirect
    {
        private string name = null;
        private string address = null;
        private int age = 0;

        public ConstructorDirect(string sname, string saddress, int sage)
        {
            this.name = sname;
            this.address = saddress;
            this.age = sage;
        }

        public void SetList(string sname, string saddress, int sage)
        {
            this.name = sname;
            this.address = saddress;
            this.age = sage;
        }

        public string GetList()
        {
            string str = name + " " + address + " " + age;
            return str;
        }

        public static void Main(){
            //에러 디폴트 생성자는 사용할 수 없다.
            //ConstructorDirect ct = new ConstructorDirect();
            ConstructorDirect ct = new ConstructorDirect("홍길동", "서울시 중구", 25);
            string s;
            s = ct.GetList();
            Console.WriteLine(s);
        }
    }
}
