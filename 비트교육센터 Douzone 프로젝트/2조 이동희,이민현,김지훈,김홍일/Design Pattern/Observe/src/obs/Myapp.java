package obs;

public class Myapp
{
    public static void main(String args[])
    {
        System.out.println("Enter Text >");

        // �̺�Ʈ ���� ��ü�� ������ - stdin���κ��� ���ڿ��� �Է¹���
         EventSource evSrc = new EventSource();

        // �������� ������
         ResponseHandler respHandler = new ResponseHandler();

        // �������� ���� ��ü�� �����ϴ� �̺�Ʈ�� �����ϰ� ��
        evSrc.addObserver( respHandler );

        // �̺�Ʈ�� �����Ű�� ������ ����
        Thread thread = new Thread(evSrc);
        thread.start();
    }
}