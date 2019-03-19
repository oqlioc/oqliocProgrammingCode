#include <stdio.h>
#include <stdlib.h>

typedef struct s_node {

	int data;
	struct s_node *next;

}node, *p_node;

void FrontInput(p_node *p_list, int n)
{
	p_node newNode;
	newNode = (p_node)malloc(sizeof(node));

	if (*p_list == NULL)
	{
		newNode->data = n;  //(*newNode).data = n
		newNode->next = NULL;
	}
	else
	{
		newNode->data = n;
		newNode->next = *p_list;
	}
	*p_list = newNode;
}

void MiddleInput(p_node *p_list, int n, int wit)
{

}

void BackInput(p_node *p_list, int n)
{
	p_node newNode;
	newNode = (p_node)malloc(sizeof(node));
	
	p_node tmp;
	tmp = *p_list;
	
	if (*p_list == NULL)
	{
		*p_list = newNode;
	}
	else
	{
		while(tmp->next != NULL)
		{
			tmp = tmp->next;
		}
		tmp->next = newNode;
	}

}

void ShowData(p_node node)
{
	printf("%d", node->data);
}

void DataDelete()
{

}

void main()
{
	p_node list = NULL;

	FrontInput(&list, 10);
	FrontInput(&list, 20);
	BackInput(&list, 30);

	ShowData(list);

}

