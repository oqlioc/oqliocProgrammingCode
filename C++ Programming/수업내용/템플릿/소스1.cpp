#include <iostream>
using namespace std;

template<typename T>
class Tem
{
	T a;
public:
	void setA(T a) {
		this->a = a;
	}
	T getA()const:
};

template<typename T>
T Tem<T>::getA()const {
	return a;
}

void main()
{
	Tem<int> a;
	a.setA(10);
	cout << a.getA() << endl;

	Tem<char> b;
	b.setA(10);
	cout << b.getA() << endl;
}