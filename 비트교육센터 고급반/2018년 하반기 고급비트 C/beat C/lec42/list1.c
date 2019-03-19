/* list1.c */
/* 강의 주제 :
	linked list
	structure
	dynamic allocation
*/

#include <stdio.h>
#include <malloc.h>

typedef struct _node {
	int data;
	struct _node *next;
} node,*nodePtr;

void insertAtHead(nodePtr *list_pointer,int d)
{
	nodePtr newNode;

	if (*list_pointer == NULL) {
		newNode = (nodePtr)malloc(sizeof(node));
		newNode->data = d;
		newNode->next = NULL;
	} else {
		newNode = (nodePtr)malloc(sizeof(node));
		newNode->data = d;
		newNode->next = *list_pointer;
	}
	*list_pointer = newNode;
}

void insertAtTail(nodePtr *list_pointer,int d)
{
	nodePtr newNode;
	nodePtr tmp = *list_pointer;

	newNode = (nodePtr)malloc(sizeof(node));
	newNode->data = d;
	newNode->next = NULL;
	if (*list_pointer == NULL) {
		*list_pointer = newNode;
	} else {
		while(tmp->next != NULL) {
			tmp = tmp->next;
		}
		tmp->next = newNode;
	}
}

void print(nodePtr list)
{
	printf("< ");
	while (list != NULL) {
		printf("%d ",list->data);
		list = list->next;
	}
	printf(">\n");
}

int nOfList(nodePtr list)
{
	int n = 0;
	while(list != NULL) {
		n++;
		list = list->next;
	}
	return n;
}

void freeAll(nodePtr list)
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
	nodePtr list = NULL;

	insertAtHead(&list,10);
	insertAtHead(&list,20);
	insertAtHead(&list,30);
	insertAtHead(&list,40);
	insertAtTail(&list,50);
	insertAtTail(&list,60);
	insertAtTail(&list,70);
	insertAtTail(&list,80);
	print(list);
	printf("number of list = %d\n",nOfList(list));
	freeAll(list);
}

/* 결과는 다음과 같이 나온다.
< 40 30 20 10 50 60 70 80 >
number of list = 8
*/




----------

싱글 링크드 리스트

front 부분 input

struct s_node data = new data(input);
temp.next = head;
gead = temp;

middle input

stuct s_node temp1 = head;
while (--i != 0) {
	temp1 = temp1.next
}

struct s_node temp2 = temp1.next
struct s_node data = new data(input)
temp1.next = new data
new data.next = temp2