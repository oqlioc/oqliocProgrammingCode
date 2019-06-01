using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class QueueTest
    {
        public static void Main()
        {
            Queue que = new Queue();
            que.Enqueue("Hi");
            que.Enqueue(5);
            que.Enqueue(500);
            que.Enqueue("Hello");
            Print("1. Queue의 목록: ", que);
            object obj = que.Dequeue();
            Console.WriteLine("2. Dequeue: {0}", obj);
            obj = que.Dequeue();
            Console.WriteLine("3. Dequeue: {0}", obj);
            Print("4. 두개를 Dequeue한 후의 목록: ", que);

            obj = que.Peek();
            Console.WriteLine("5. Peek: {0}", obj);
            Print("6. Peek한 후의 Queue의 목록: ", que);
        }
        public static void Print(string info, IEnumerable myCollection)
        {
            Console.Write(info + "\n\t");
            IEnumerator myEnumerator = myCollection.GetEnumerator();
            while (myEnumerator.MoveNext())
                Console.Write("{0}, ", myEnumerator.Current);
            Console.WriteLine();
        }
    }
}
