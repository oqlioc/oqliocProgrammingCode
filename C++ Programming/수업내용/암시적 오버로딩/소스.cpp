#include <iostream>
#include <stdio.h>
using namespace std;
/*
	�Ͻ��� �����ε�( ����Ʈ���ڰ� )
	:����Ʈ ���ڰ��� �� �������� �ڿ� �ִ� �Ű�������
	������ �ʱ�ȭ�� ���־���Ѵ�.

	����Ʈ���ڰ� ���� + 1�� ��ŭ ȣ�Ⱑ��
	�Լ�����ο� ����Ʈ���ڰ��� ����ϰ�
	�Լ����Ǻο��� ����� �ϸ� �ȵȴ�.
*/
void output(int a = 0, int b = 0, int c = 0); //�Լ�����

void main()
{
	int a = 10;
	int b = 20;
	int c = 30;

	output();
	output(a);
	output(a, b);
	output(a, b, c);

}

void output(int a, int b, int c) // �Լ� ����
{
	cout << a << b << c << endl;
}