using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ConsoleApplication1
{
    class PathTest
    {
        static void Main(string[] args)
        {
            char ps = Path.DirectorySeparatorChar;
            Console.WriteLine("1. Path.DirectorySeparatorChar : " + ps);
            string path1 = @"c:\csharp\";
            string path2 = @"chap07\Path";
            Console.WriteLine("2. 디렉토리 결합 : " + Path.Combine(path1, path2));
            string str = Path.GetDirectoryName(@"c:\csharp\chap07\PathTest.cs");
            Console.WriteLine("3. 파일 이름 얻기 : " + str);
        }
    }
}
