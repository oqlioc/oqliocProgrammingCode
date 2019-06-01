using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ConsoleApplication1
{
    class DirectoryTest
    {
        public static void Main()
        {
            Directory.CreateDirectory(@"F:\20131902\7장 2019.05.27\NewFolder");  // 디렉터리 생성

            if (Directory.Exists(@"F:\20131902\7장 2019.05.27\NewFolder"))  // 디렉터리 존재확인
            {
                Console.WriteLine("해당 디렉터리가 존재합니다.");
            }
            else
            {
                Console.WriteLine("해당 디렉터리가 존재하지 않습니다.");
            }

            string[] files = Directory.GetFiles(".");  // 디렉터리 내 파일얻기 

            for (int i = 0; i < files.Length; i++)
            {
                Console.WriteLine(files[i]);
            }

            string[] dirs = Directory.GetDirectories(".");  // 서브 디렉터리얻기 

            for (int i = 0; i < dirs.Length; i++)
            {
                Console.WriteLine(dirs[i]);
            }
        }
    }
}
