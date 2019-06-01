using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._04._08
{
    public class NewFather
    {
        public virtual void OverrideFunc()
        {
            Console.WriteLine("아버지의 함수");
        }
    }

    public class NewSon : NewFather
    {
        public override void OverrideFunc()
        {
            Console.WriteLine("아들의 재정의 함수");
        }

        public void TestFunc()
        {
            base.OverrideFunc();  // NewFather의 메서드 호출
        }

        public static void Main()
        {
            NewSon ns = new NewSon();
            ns.OverrideFunc(); // NewSon의 함수 호출
            ns.TestFunc();  // TestFunc() 내에서 NewFather의 함수 호출
        }
    }
}
