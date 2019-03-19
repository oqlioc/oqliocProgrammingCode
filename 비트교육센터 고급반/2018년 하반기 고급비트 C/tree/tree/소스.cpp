#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct node {
	int key;
	int data;
	struct node *left;
	struct node* right;
}Node;

int Insert(Node* root, int key, int data);
int Delete(Node* root, int key);
int Getdata(Node* root, int key, int* data);
void print(Node* root);
void PreOrder(Node* cur);
void InOrder(Node* cur);
void PostOrder(Node* cur);

int main()
{
	Node* root = (Node *)calloc(1, sizeof(Node));
	root->left = NULL;
	root->right = NULL;
	root->key = -1;
	root->data = -1;
	int m_num;
	int key;
	int data;

	while (1)
	{
		puts("");
		puts("**Menu**");
		puts("1, Insert");
		puts("2, Getdata");
		puts("3, Delete");
		puts("4, print");
		puts(":");
		scanf("%d", &m_num);

		switch (m_num)
		{
			case 1:		//insert
				puts("Enter the key : ");   
				scanf("%d", &key);
				puts("Enter the data : ");
				scanf("%d", &data);

				if (Insert(root, key, data) == -1)
				{
					puts("ERR");
					break;
				}
				puts("Done");
				break;
			case 2:		//getdata
				puts("Enter the key : ");   
				scanf("%d", &key);

				if (Getdata(root, key, &data) == -1)
				{
					puts("ERR");
					break;
				}
				printf("Data : %d\n", data);
				break;
			case 3:		//delete
				puts("Enter the key : ");
				scanf("%d", &key);

				if (Delete(root, key) == -1)
				{
					puts("ERR");
					break;
				}
				puts("Delete Done");
				break;
			case 4:		// print
				puts("<RESULT>");
				print(root->left);
				break;
			default:
				puts("Wrong Input!");
				break;
		}
	}
}

int Insert(Node* root, int key, int data)
{
	Node *tmp;
	Node *cur;
	Node *newnode;

	newnode = cur = (Node *)malloc(sizeof(Node));

	newnode->key = key;
	newnode->data = data;
	newnode->left = NULL;
	newnode->right = NULL;
	if(root->key == -1)
	{
		root->left = newnode;
		return 1;
	}
	else
	{
		tmp = root->left;
		cur = tmp;
		while (1)
		{
			if(newnode->key == cur->key)
			{
				puts("중복");
				return 0;
			}
			else if(newnode->key < cur->key)
			{
				if (cur->left == NULL)
				{
					break;
				}
				cur = cur->left;
			}
			else
			{
				if (cur->right = NULL)
				{
					break;
				}
				cur = cur->right;
			}
		}

	}
	if (newnode->key < cur->key)
	{
		cur->left = newnode;
	}
	else
	{
		cur->right = newnode;
	}

	puts("노드 추가 완료");
	return 1;
}

int Delete(Node* root, int key)
{

}

int Getdata(Node* root, int key, int* data)
{

}

void print(Node* root)
{

}

void PreOrder(Node* cur)
{

}

void InOrder(Node* cur)
{

}

void PostOrder(Node* cur)
{

}