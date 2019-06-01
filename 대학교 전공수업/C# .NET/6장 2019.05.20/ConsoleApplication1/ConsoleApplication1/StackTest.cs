using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class StackTest
    {
        public static void Main()
        {
            Stack stack = new Stack();
            stack.Push("Hi");
            stack.Push("Hello");
            stack.Push("World");
            stack.Push("7777");

            Print("1. Stack의 목록: ", stack);
            object obj = stack.Pop();
            Console.WriteLine("2. Pop:{0}", obj);
            obj = stack.Pop();
            Console.WriteLine("3. Pop:{0}", obj);
            Print("4. Pop을 두번한 후 의 목록:", stack);
            obj = stack.Peek();
            Console.WriteLine("5. Peek:{0}", obj);
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
