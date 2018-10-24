#include <iostream>
using namespace std;

class Me
{
protected:
	int rear;
	int front;
	int arr[5];

public:
	Me()
	{
		front = 0;
		rear = 0;
	}

	virtual int pop() = 0;
	void push(int num)
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
		if (rear == (sizeof(arr) / sizeof(int)))
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
		if (rear == (sizeof(arr) / sizeof(int)) && front != 0)
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

class S : public Me
{
public:

	virtual int pop()
	{
		if (Empty())
		{
			return arr[--rear];
		}
	}
};

class Q : public Me
{
public:

	virtual int pop()
	{
		if (Empty())
		{
			return arr[front++];
		}
	}


};

int main()
{
	int co1, co2, input;
	Me *m = NULL;
	S s;
	Q q;

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