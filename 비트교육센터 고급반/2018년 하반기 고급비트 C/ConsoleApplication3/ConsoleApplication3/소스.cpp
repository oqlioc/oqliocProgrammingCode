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
		printf("이름 입력 : ");
		scanf("%s", name[y]);

		for(int x = 0; x < 3; x++)
		{
			printf("국어 영어 수학 점수 입력 : ");
			scanf("%d", &score[y][x]);
			score[y][3]+=score[y][x];
		}
		avg[y] = score[y][3]/3.f;
		
	}

	for(int i = 0; i < 3; i++)
	{
		printf(" 이름 : %s\n", name[i]);
		printf(" 총합 : %d\n", score[i][3]);
		printf(" 평균 : %f\n", avg[i]);
	}
	*/

	// pointer === p는 &p 가르키는 주소, *p는 가르키는 값



	/*
	보류
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
		printf("이름 입력 : ");
		scanf("%s", *(name+y));

		for(int x = 0; x < 3; x++)
		{
			printf(" 점수 입력 : ");
			scanf("%d", *(score+y)+x);
			*(*(score+y)+3)+=*(*(score+y)+x);
		}
		*(avg+y) = *(*(score+y)+3)/3.f;
		
	}

	for(int i = 0; i < 3; i++)
	{
		printf(" 이름 : %s\n", *(name+i));
		printf(" 총합 : %d\n", *(*(score+i)+3));
		printf(" 평균 : %f\n", *(avg+i));
	}
}