/* 강의 주제 :
	linked list
	global variable 이용
*/

#include <stdio.h>
#include <malloc.h>

typedef struct _node {
	int data;
	struct _node *next;
} node,*nodePtr;

nodePtr list = NULL;

void insertAtHead(int d)
{
	nodePtr newNode;

	if (list == NULL) {
		newNode = (nodePtr)malloc(sizeof(node));
		newNode->data = d;
		newNode->next = NULL;
	} else {
		newNode = (nodePtr)malloc(sizeof(node));
		newNode->data = d;
		newNode->next = list;
	}
	list = newNode;
}

void insertAtTail(int d)
{
	nodePtr newNode;
	nodePtr tmp = list;

	newNode = (nodePtr)malloc(sizeof(node));
	newNode->data = d;
	newNode->next = NULL;
	if (list == NULL) {
		 list = newNode;
	} else {
		while(tmp->next != NULL) {
			tmp = tmp->next;
		}
		tmp->next = newNode;
	}
}

void print()
{
	nodePtr tmp = list;

	printf("< ");
	while (tmp != NULL) {
		printf("%d ",tmp->data);
		tmp = tmp->next;
	}
	printf(">\n");
}

int nOfList()
{
	nodePtr tmp = list;

	int n = 0;
	while(tmp != NULL) {
		n++;
		tmp = tmp->next;
	}
	return n;
}

void freeAll()
{
	nodePtr tmp;
	while(list != NULL) {
		tmp = list;
		list = list->next;
		free(tmp);
	}
}

main()
{
	insertAtHead(10);
	insertAtHead(20);
	insertAtHead(30);
	insertAtHead(40);
	insertAtTail(50);
	insertAtTail(60);
	insertAtTail(70);
	insertAtTail(80);
	print();
	printf("number of list = %d\n",nOfList());
	freeAll();
}

/* 결과는 다음과 같이 나온다.
< 40 30 20 10 50 60 70 80 >
number of list = 8
*/