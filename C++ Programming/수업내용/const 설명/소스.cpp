#include <iostream>
using namespace std;
/*
const field : �� �ݷ��ʱ�ȭ�� �ؾ��Ѵ�
const method : �޼ҵ峻���� �ʵ��� ���� ��ȣ�ϴ� ����
const Object : ��ü �ȿ� �ִ� ������ ��ȣ ����

const Object�� const method���� ȣ�Ⱑ��
*/
class A
{
	const int a;
	int b;
public:
	A(int aa) :a(aa), b(aa){
		//b= aa;
	}
	void setB(int bb) { b = bb; }

	int getA()const {
		return a;
	}
	int getB()const { // const Object�ϰ�� �켱
		return b;
	}
	int getB() {      // �Ϲ� Object�ϰ�� �켱
		return b;
	}
};
void main()
{
	const A aa(80);
	// aa.setB(89);

	cout << aa.getA() << endl;
	cout << aa.getB() << endl;

	
}