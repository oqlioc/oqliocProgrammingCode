using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ConsoleApplication1
{
    class FileTest
    {
        public static void Main()
        {
            Console.WriteLine("1. 프로그램 시작");
            File.Copy("FileTest.txt", "Output.txt", true);
            Console.WriteLine("2. === Copied Successfully!! ===");
            bool exist = File.Exists("./Output.txt");
            Console.WriteLine("3. Output.txt 존재여부 : " + exist);
            DateTime dt = File.GetCreationTime("./Output.txt");
            Console.WriteLine("4. 파일 생성시간 : " + dt.ToString());
            Console.WriteLine("5. 프로그램 끝");
        }
    }
}