#include <iostream>
using namespace std;

class A
{
public:
	A() { cout << "������" << endl; }
	~A() { cout << "�Ҹ���" << endl; }
	A(const A &aa) { cout << "���������" << endl; }
	void setObject(A aa) {}
	A getObject() { A aa; return aa; }
};

void main()
{
	A aa;
	A bb(aa);
	A cc = bb;
	
	aa.setObject(bb); bb.setObject(cc); cc.setObject(bb);
	aa.getObject(); bb.getObject(); cc.getObject();
}