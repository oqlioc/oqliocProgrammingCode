#include <iostream>
using namespace std;

template <typename T>
class Me
{
protected:
	int rear;
	int front;
	T arr[5];

public:
	Me()
	{
		front = 0;
		rear = 0;
	}

	virtual T pop() = 0;
	void push(T num)
	{
		if (Full())
		{
			arr[rear] = num;
			rear++;
		}
	}

	int Empty()
	{
		if (front == rear)
		{
			cout << "없다" << endl;
			return 0;
		}
		else
		{
			return 1;
		}
	}

	int Full()
	{
		if (rear == (sizeof(arr) / sizeof(T)))
		{
			cout << " 풀이다 " << endl;
			return 0;
		}
		else
		{
			return 1;
		}
	}

	void shift()
	{
		int i;
		if (rear == (sizeof(arr) / sizeof(T)) && front != 0)
		{
			for (i = 0; i < rear - 1; i++)
			{
				arr[i] = arr[i + 1];
			}
			rear--;
			front--;
		}
	}

};

template <typename T>
class S : public Me<T>
{
public:

	virtual T pop()
	{
		if (Me<T>::Empty())
		{
			return Me<T>::arr[--Me<T>::rear];
		}
	}
};

template <typename T>
class Q : public Me<T>
{
public:

	virtual T pop()
	{
		if (Me<T>::Empty())
		{
			return Me<T>::arr[Me<T>::front++];
		}
	}


};

int main()
{
	int co1, co2;

	//==타입==바꾸기=====================
	char input;
	Me<char> *m = NULL;
	S<char> s;
	Q<char> q;
	//==타입==바꾸기=====================

	while (1)
	{
		cout << "1. 스택  2. 큐  3. 나가기" << endl;
		cin >> co1;

		if (co1 == 1)
		{
			cout << "<스택>" << endl;;
			m = &s;
		}
		if (co1 == 2)
		{
			cout << "<큐>" << endl;;
			m = &q;
		}
		if (co1 == 3)
		{
			break;
		}

		while (1)
		{
			cout << "1. push  2. pop  3. 나가기" << endl;
			cin >> co2;

			if (co2 == 1)
			{
				cout << "push : ";
				cin >> input;
				m->shift();
				m->push(input);
			}
			else if (co2 == 2)
			{
				cout << "pop : " << m->pop() << endl;;
				cout << endl;
			}
			else if (co2 == 3)
			{
				break;
			}

		}
	}


}