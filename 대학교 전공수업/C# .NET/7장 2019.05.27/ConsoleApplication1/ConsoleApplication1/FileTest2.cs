using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ConsoleApplication1
{
    class FileTest2
    {
        public static void Main()
        {
            FileStream fs = File.OpenRead("./FileTest.txt");

            StreamReader r = new StreamReader(fs, System.Text.Encoding.Default);

            r.BaseStream.Seek(0, SeekOrigin.Begin);

            while (r.Peek() > -1)
            {
                Console.WriteLine(r.ReadLine());
            }

            r.Close();
        }
    }
}
