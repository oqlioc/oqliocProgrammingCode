#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void main()
{
	/*
	char name[3][10];
	int score[3][4] = {0};
	float avg[3] = {0};

	for(int y = 0; y < 3; y++)
	{
		printf("�̸� �Է� : ");
		scanf("%s", name[y]);

		for(int x = 0; x < 3; x++)
		{
			printf("���� ���� ���� ���� �Է� : ");
			scanf("%d", &score[y][x]);
			score[y][3]+=score[y][x];
		}
		avg[y] = score[y][3]/3.f;
		
	}

	for(int i = 0; i < 3; i++)
	{
		printf(" �̸� : %s\n", name[i]);
		printf(" ���� : %d\n", score[i][3]);
		printf(" ��� : %f\n", avg[i]);
	}
	*/

	// pointer === p�� &p ����Ű�� �ּ�, *p�� ����Ű�� ��



	/*
	����
	char name[3][10];
	int score[3][4] = {0};
	float avg[3] = {0};

	char *pName=NULL;
	int *pScore=NULL;
	float *pAvg=NULL;

	pName=*name;
	*/


	char name[3][10];
	int score[3][4] = {0};
	float avg[3] = {0};

	for(int y = 0; y < 3; y++)
	{
		printf("�̸� �Է� : ");
		scanf("%s", *(name+y));

		for(int x = 0; x < 3; x++)
		{
			printf(" ���� �Է� : ");
			scanf("%d", *(score+y)+x);
			*(*(score+y)+3)+=*(*(score+y)+x);
		}
		*(avg+y) = *(*(score+y)+3)/3.f;
		
	}

	for(int i = 0; i < 3; i++)
	{
		printf(" �̸� : %s\n", *(name+i));
		printf(" ���� : %d\n", *(*(score+i)+3));
		printf(" ��� : %f\n", *(avg+i));
	}
}