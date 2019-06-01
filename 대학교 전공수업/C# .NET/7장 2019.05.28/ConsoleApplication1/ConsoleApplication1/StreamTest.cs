using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ConsoleApplication1
{
    class StreamTest
    {
        public static void Main()
        {
            int ch;
            Stream st = Console.OpenStandardInput();

            Console.WriteLine("끝내시려면 'S'를 입력해 주세요");
            Console.WriteLine("아무 글이나 입력하시고 Enter를 쳐주세요?");

            while ((ch = st.ReadByte()) != -1)
            {
                if (ch == 83)
                { //83은 'S'
                    Console.WriteLine("!!!!====== stop ======!!!!");
                    return;
                }

                Console.WriteLine((char)ch + " : " + ch);
            }
        }
    }
}
