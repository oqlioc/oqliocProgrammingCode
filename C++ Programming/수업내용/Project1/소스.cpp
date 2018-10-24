#include <iostream>
using namespace std;

class A
{
public:
	A() { cout << "생성자" << endl; }
	~A() { cout << "소멸자" << endl; }
	A(const A &aa) { cout << "복사생성자" << endl; }
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