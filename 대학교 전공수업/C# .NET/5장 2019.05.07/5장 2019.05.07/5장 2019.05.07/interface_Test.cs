using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._05._07
{
    public interface IRemoteControl
    {
        void PowerOn();  // 추상함수
        void PowerOff();
        void ChannelUp();
        void ChannelDown();
    }

    class interface_Test
    {
        static void Main(string[] args)
        {
            IRemoteControl irc1 = new SSTVRemote();
            irc1.PowerOn();
            irc1.PowerOff();
            irc1.ChannelUp();
            irc1.ChannelDown();
            IRemoteControl irc2 = new DWTVRemote();
            irc2.PowerOn();
            irc2.PowerOff();
            irc2.ChannelUp();
            irc2.ChannelDown();
            IRemoteControl irc3 = new HDTVRemote();
            irc3.PowerOn();
            irc3.PowerOff();
            irc3.ChannelUp();
            irc3.ChannelDown();
        }
    }

    public class SSTVRemote : IRemoteControl
    {
        protected int nChannel = 0;
        protected bool bPower = false;
        public void PowerOn()
        {
            bPower = true;
            Console.WriteLine("SS TV 전원 On!");
        }
        public void PowerOff()
        {
            bPower = false;
            Console.WriteLine("SS TV 전원 Off!");
        }
        public void ChannelUp()
        {
            nChannel++;
            Console.WriteLine("SS TV Channel Up " + nChannel);
        }
        public void ChannelDown()
        {
            nChannel--;
            Console.WriteLine("SS TV Channel Down " + nChannel);
        }
    }

    public class DWTVRemote : IRemoteControl
    {
        protected int nChannel = 0;
        protected bool bPower = false;
        public void PowerOn()
        {
            bPower = true;
            Console.WriteLine("DW TV 전원 On!");
        }
        public void PowerOff()
        {
            bPower = false;
            Console.WriteLine("DW TV 전원 Off!");
        }
        public void ChannelUp()
        {
            nChannel++;
            Console.WriteLine("DW TV Channel Up " + nChannel);
        }
        public void ChannelDown()
        {
            nChannel--;
            Console.WriteLine("DW TV Channel Down " + nChannel);
        }
    }

    public class HDTVRemote : IRemoteControl
    {
        protected int nChannel = 0;
        protected bool bPower = false;
        public void PowerOn()
        {
            bPower = true;
            Console.WriteLine("HD TV 전원 On!");
        }
        public void PowerOff()
        {
            bPower = false;
            Console.WriteLine("HD TV 전원 Off!");
        }
        public void ChannelUp()
        {
            nChannel++;
            Console.WriteLine("HD TV Channel Up " + nChannel);
        }
        public void ChannelDown()
        {
            nChannel--;
            Console.WriteLine("HD TV Channel Down " + nChannel);
        }
    }
}
