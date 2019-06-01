using System;
using System.Collections;
using System.Collections.Specialized;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class NameValueCollectionTest
    {
        static void Main(string[] args)
        {
            NameValueCollection dic = new NameValueCollection();
            dic.Set("이름", "김삿갓");
            dic.Set("나이", "24");
            dic.Set("성별", "남");

            string name = dic.Get("이름");
            string age = dic.Get("나이");
            string sex = dic.Get("성별");

            Console.WriteLine("이름 = {0}, 나이 = {1}, 성별 = {2}", name, age, sex);

            for (int i = 0; i < dic.Count; i++)
            {
                Console.Write("{0} = {1}\n", dic.Keys[i], dic[i]);
            }
        }
    }
}
