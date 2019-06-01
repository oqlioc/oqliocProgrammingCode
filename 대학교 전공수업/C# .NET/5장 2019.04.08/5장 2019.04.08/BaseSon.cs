using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5장_2019._04._08
{
    class BaseFather
    {
        private string name;

        public BaseFather(string name)
        {
            this.name = name;
            Console.WriteLine("BaseSon : {0}", name);
        }
    }
    class BaseSon : BaseFather
    {
        public BaseSon(string str)  : base(str)
        {
        }

        public static void Main()
        {
            BaseSon s = new BaseSon("Base Test Problem");
        }
    }
}
