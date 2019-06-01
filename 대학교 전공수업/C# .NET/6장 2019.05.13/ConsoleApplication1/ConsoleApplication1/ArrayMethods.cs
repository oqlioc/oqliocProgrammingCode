using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class ArrayMethods
    {
        public static void Print(int[] arr)
        {
            foreach (int s in arr)
                Console.Write(s + "\t ");
            Console.WriteLine();
        }

        public static void Main()
        {
            int[] arr = { 10, 5, 44, 55, 1000, 140, 3, 55};
            Print(arr);
            Array.Sort(arr);  // 배열의 오름차순 정렬
            Print(arr);
            Array.Reverse(arr);  // 배열의 역순으로 정렬
            Print(arr);
            int index55 = Array.IndexOf(arr, 55);  // 55가 처음 나오는 위치
            Console.WriteLine(index55);
            // 마지막부터 검색하여 55가 처음 나오는 위치
            int lastIndex55 = Array.LastIndexOf(arr, 55);
            Console.WriteLine(lastIndex55);
            Array.Clear(arr, 0, 5);  // 0번째부터 5개를 초기화한다.
            Print(arr);
        }
    }
}
