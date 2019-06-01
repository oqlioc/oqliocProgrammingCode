using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class BombComputer 
    {
        private bool power;

        public void powerOn()
        {
            this.power = true;
            Console.WriteLine("!!!!!!!폭발물컴퓨터 전원 ON.!!!!!!!");
        }
        public void powerOff()
        {
            this.power = false;
            Console.WriteLine("!!!!!!!폭발물컴퓨터 전원 OFF.!!!!!!!");
        }
        public void processJob()
        {
            Console.WriteLine("!!!!!!! 작업처리1 !!!!!!!");
            Console.WriteLine("!!!!!!! 작업처리2 !!!!!!!");

            throw new Exception("@!@!@곧 폭발 합니다.@!@!@");
        }
    }

    public class BombComputerTest
    {
        public static void Main()
        {
            BombComputer bc = new BombComputer();

            try
            {
                bc.powerOn();
                bc.processJob();
                bc.powerOff();
            }
            catch (Exception e)
            {
                Console.WriteLine("1. Message 속성 : " + e.Message);
                Console.WriteLine("2. e.StackTrace 속성 : " + e.StackTrace);
                Console.WriteLine("3. e.HelpLink 속성 : " + e.HelpLink);
                Console.WriteLine("4. e.ToString 속성 : " + e.ToString());
            }
        }
    }
}
