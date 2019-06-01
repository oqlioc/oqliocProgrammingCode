using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class SamplesArrayList
    {
        static void Main(string[] args)
        {
            ArrayList myAL = new ArrayList();
            myAL.Add("hi");
            myAL.Add("welcome");
            myAL.Add("to");
            myAL.Add("C#");
            myAL.Add("world");

            Print("1. 데이터삽입:", myAL);

            Queue myQueue = new Queue();
            myQueue.Enqueue("QueueData1");
            myQueue.Enqueue("QueueData2");

            myAL.AddRange(myQueue);
            Print("2. Queue에 내용을 ArrayList에 삽입:", myAL);

            myAL.Insert(2, "novel");
            Print("3. Index 위치 2에 데이터삽입:", myAL);

            myAL.Remove("hi");
            Print("4. hi 데이터 삭제:", myAL);

            myAL.RemoveAt(2);
            Print("5. Index 위치 2의 데이터 삭제:", myAL);

            myAL.RemoveRange(2, 2);
            Print("6. Index 2부터 2개의 데이터 삭제:", myAL);

            myAL.Sort(0, 3, null);
            Print("7. Index 위치 0부터 3개 Sort:", myAL);
        }

        public static void Print(string info, IEnumerable myList)
        {
            IEnumerator myEnumerator = myList.GetEnumerator();

            Console.Write(info);

            while (myEnumerator.MoveNext())
            {
                Console.Write(" {0},", myEnumerator.Current);
            }

            Console.WriteLine();
        }
    }
}
