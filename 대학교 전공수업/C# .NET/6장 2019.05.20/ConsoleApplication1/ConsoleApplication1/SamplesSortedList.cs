using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class SamplesSortedList
    {
        public static void Main()
        {
            SortedList mySL = new SortedList();
            mySL.Add(76, "four");
            mySL.Add(100, "tree");
            mySL.Add(2, "two");
            mySL.Add(8, "zero");
            mySL.Add(5, "one");
            Print("1. SortedList의 목록", mySL);

            bool IsContains = mySL.Contains(2);
            Console.WriteLine("2. Key '2'가 존재하는가? {0}", IsContains);

            IsContains = mySL.ContainsValue("tree");
            Console.WriteLine("3. Value 'tree'가 존재하는가? {0}", IsContains);

            object obj = mySL.GetKey(3);
            Console.WriteLine("4. Index 3 위치의 Key는? {0}", obj);

            obj = mySL.GetByIndex(3);
            Console.WriteLine("5. Index 3 위치의 Value는? {0}", obj);

            mySL.RemoveAt(4);
            Print("6. 데이터 제거 후의 목록", mySL);

            Console.WriteLine("7. Key 76의 Value {0}", mySL[76]);
            Console.WriteLine("8. Key 2의 Value {0}", mySL[2]);
        }

        public static void Print(string info, SortedList myList)
        {
            Console.WriteLine(info);
            Console.WriteLine("\t - INDEX - \t - KEY - \t - VALUE");

            for (int i = 0;  i < myList.Count; i++ )
            {
                Console.WriteLine("\t    [{0}]:\t    {1}\t            {2}", i, myList.GetKey(i), myList.GetByIndex(i));
            }
        }
    }
}
