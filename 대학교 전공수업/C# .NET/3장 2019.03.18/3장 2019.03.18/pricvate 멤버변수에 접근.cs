using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

 class TopSecret
{
    private int secret;

    public void SetSecret(int x)
    {
        secret =  x;
    }

    public int GetSecret()
    {
        return secret;
    }

}

namespace _3장_2019._03._18
{

    class TopSecretMain
    {

        public static void Main()
        {
            TopSecret t = new TopSecret();
            t.SetSecret(1000);
            int s = t.GetSecret();
            Console.WriteLine("secret = {0}", s);
        }

    }

}

