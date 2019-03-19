#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

struct Node

{

        int          data;

        struct Node* next;

};

    

int Insert(struct Node*root, int position);

int Delete(struct Node*root, int position);

int SetData(struct Node*root, int position, int data);

int GetData(struct Node*root, int position, int* data);

void print(struct Node* root);

#define ASSERT(exp) if(!(exp)){puts("Err\n");}
// ������ ���ϴ� ���� ������ �ִ��� Ȯ���ϴ� �ڵ带 �ǹ�
 

void main(void)

{

        Node* root = (struct Node*)malloc(sizeof(struct Node));

        root->next = NULL;

        int r , n;

 

        //0����ġ�� 10�� ����

        for(int i = 0; i < 10; i++)

        {

               r = Insert(root, 0);
			   ASSERT(r);

               r = SetData(root,0,i+1);
			   ASSERT(r);

        }
		print(root);

        //����Ȯ��

        for(int i=0;i<10;i++)

        {

               r = GetData(root,i,&n);
			   ASSERT(r);

               ASSERT(n == 10 - i);

        }
		print(root);

        //��λ���

        for(int i = 0; i < 10; i++)

        {

               r = Delete(root, 0);ASSERT(r);

        }
		print(root);

        //��������ġ�� 10������

        for(int i = 0; i < 10; i++)

        {

               r = Insert(root,i);ASSERT(r);

               r = SetData(root,i,i+1);ASSERT(r);

        }
		print(root);

        //¦����°��λ���

        for(int i=10-1;i>=0;i-=2)

        {

               r = Delete(root, i);ASSERT(r);

        }
		print(root);

        //¦����°�ٽû���

        for(int i=1;i<10;i+=2)

        {

               r = Insert(root, i);
			   ASSERT(r);

               r = SetData(root,i,i+1);
			   ASSERT(r);

        }
		print(root);

        //����Ȯ��

        for(int i=0;i<10;i++)

        {

               r = GetData(root,i,&n);
			   ASSERT(r);

               ASSERT(n==i+1);

        }
		print(root);

        //����Ȯ��

        for(int i=10;i<20;i++)

        {

               r = GetData(root,i,&n);
			   ASSERT(!r);

        }
		print(root);

        //�������λ���

        for(int i=10-1;i>=0;i--)

        {

               r = Delete(root, i);
			   ASSERT(r);

        }
		print(root);

 

        ASSERT(root->next == NULL);

        free(root);

        root = NULL; //��������

}


int Insert(struct Node*root, int position)
{
	struct Node* p_root = root;
	struct Node* p_New = (struct Node*)malloc(sizeof(struct Node));
	//if(!(p_New)) return 0;
	p_New->next = NULL;
	p_New->data = NULL;
	if(position == 0)
	{
		p_New->next = root->next;
		root->next = p_New;
	}else
	{
		for(int i = 0; i < position; i++)
		{
			if(p_root->next == NULL)   return 0;
			p_root = p_root->next;
		}
		p_New->next = p_root->next;
		p_root->next = p_New;
	}
	return 1;
}
int SetData(struct Node*root, int position, int data)
{
	struct Node* p_root = root->next;
	for(int i = 0; i < position; i++)
	{
		p_root = p_root->next;
	}
	(*p_root).data = data;

	if((*p_root).data)
		return 1;
	else
		return 0;
}
int GetData(struct Node*root, int position, int* data)
{
	struct Node* p_root = root->next;
	for(int i = 0; i < position; i++)
	{
		if(p_root->next == NULL) return 0;
		p_root = p_root->next;
	}
	*data = p_root->data;
	return 1;
}
int Delete(struct Node*root, int position)
{
	struct Node* p_root = root;
	struct Node* p_Con;
	for(int i = 0; i < position; i++)
	{
		if(p_root->next == NULL) return 0;
		p_root = p_root->next;
	}
	if(p_root->next != NULL)
		p_Con = p_root->next->next;
	else
		p_Con = NULL;
	//free(p_Cur->next);

	p_root->next = p_Con;

	return 1;
}
void print(struct Node* root)
{
   printf("\n");
   struct Node* cur;
   cur = root->next;
 
   while(cur!=NULL)
   {
      printf("%d ",cur->data);
      cur=cur->next;
   }
}
 