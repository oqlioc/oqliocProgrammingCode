/*
#include <iostream>
using namespace std;

//����� �������̵�
void change(int &a, int &b)
{
	int tmp = a;
	a = b;
	b = tmp;
}

void change(char &c, char &d)
{
	char tmp = c;
	c = d;
	d = tmp;
}

void change(float &e, float &f)
{
	float tmp = e;
	e = f;
	f = tmp;
}

void main()
{
	int a = 10, b = 20;
	char c = 'A', d = 'B';
	float e = 3.7, f = 4.5;

	change(a, b);
	change(c, d);
	change(e, f);

	cout << a << "\t" << b << endl;
	cout << c << "\t" << d << endl;
	cout << e << "\t" << f << endl;
}
*/



#include <iostream>
using namespace std;
/*

����� - ��ɰ� ������ Ÿ���� �޶���
�Ͻ��� - ����� �Ȱ��� ������ ���� �ٲܼ��� ����.
 ������
�Ͻ��� �����ε� ( ����Ʈ ���ڰ�(�ʱ�ȭ��) = ����ڰ� ���� ���ָ� �⺻ ���ڰ����� ��� )

����Ʈ ���ڰ��� �� �������� �ڿ� �ִ� �Ű�������
������ �ʱ�ȭ�� ���־�� �Ѵ�.

����Ʈ ���ڰ��� Ƚ�� + 1�� ��ŭ ȣ�Ⱑ��
�Լ�����ο� ����Ʈ ���ڰ��� ����ϰ�
�Լ����Ǻο��� ����� �ϸ� �ȵȴ�.

void out(int a = 0, int b = 0); // �̷��� �Լ� ������ �Ͻ��� �����ε� �̶���.
out(10, 20); / 10 20
out(10); / 10 0
out(); / 0 0


*/

void output(int a = 0, int b = 0, int c = 0); // �Լ�����

void main()
{
	int a = 10, b = 20, c = 30;

	output();
	output(a);
	output(a, b);
	output(a, b, c);


}

void output(int a = 0, int b = 0, int c = 0) // �Լ�����
{
	cout << a << b << c << endl;
}