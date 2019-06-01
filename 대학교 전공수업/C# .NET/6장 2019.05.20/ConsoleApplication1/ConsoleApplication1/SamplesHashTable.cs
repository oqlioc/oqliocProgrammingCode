using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class SamplesHashTable
    {
        public static void Main()
        {
            Hashtable myHT = new Hashtable();
            myHT.Add("First", "Hello");
            myHT.Add("Second", "World");
            myHT.Add("Third", "welcome");
            myHT.Add("Four", "!");
            Print("1, myHT 전체 목록 : ", myHT);
            bool IsContain = myHT.ContainsKey("First");
            Console.WriteLine("2. 키 값들만 출력\n\t");
            ICollection myKey = myHT.Keys;
            foreach (object obj in myKey)
            {
                Console.Write("{0}", obj);
            }
            Console.WriteLine();
            myHT.Remove("Four");
            Print("5. 데이터 삭제 : ", myHT);
            Console.WriteLine("6. Key First Value {0}", myHT["Second"]);
        }

        public static void Print(string info, Hashtable myList)
        {
            IDictionaryEnumerator myEnumerator = myList.GetEnumerator();

            Console.Write(info + "\n\t");

            while (myEnumerator.MoveNext())
            {
                Console.Write(" {0}:{1}, ", myEnumerator.Key, myEnumerator.Value);
            }

            Console.Write("요소의 갯수 : " + myList.Count + "\n");
        }
    }
}
