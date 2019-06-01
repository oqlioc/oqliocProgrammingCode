using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ConsoleApplication1
{
    class FileStreamTest
    {
        public static byte[] WriteStringBytes(string str, FileStream fs)
        {
            byte[] info = new UTF8Encoding(true).GetBytes(str);
            fs.Write(info, 0, info.Length);

            return info;
        }

        public static void Main()
        {
            FileStream fs = new FileStream("test.txt", FileMode.Create);

            fs.Seek(0, SeekOrigin.Begin);

            FileStreamTest.WriteStringBytes("------------------\r\n", fs);
            FileStreamTest.WriteStringBytes("-- File Content --\r\n", fs);
            FileStreamTest.WriteStringBytes("------------------\r\n", fs);

            fs.Flush();
            fs.Close();

            byte[] b = new byte[1024];

            FileStream fs2 = File.OpenRead("test.txt");
            UTF8Encoding utf8 = new UTF8Encoding(true);

            while (fs2.Read(b, 0, b.Length) > 0)
            {
                Console.WriteLine(utf8.GetString(b));
            }

            fs2.Close();
        }
    }
}
