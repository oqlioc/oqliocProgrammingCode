package obs;

import java.util.Observable;
import java.util.Observer; /* ���Ⱑ ������ */

public class ResponseHandler implements Observer
{
    private String resp;
    public void update (Observable obj, Object arg)
    {
        if (arg instanceof String)
        {
        	resp = (String) arg;
        	
        	if(resp.equals("aa")) {
        		System.out.println("�����մϴ�.");
        		System.exit(0);
        	}
        	
            System.out.println("\nReceived Response: "+ resp );
        }
    }
}