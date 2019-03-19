#include <stdio.h>

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

		printf(" 이름 : %s\n", name[y]);
		printf(" 총합 : %d\n", score[y][3]);
		printf(" 평균 : %f\n", avg[y]);
		
	}
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
		
		printf(" 이름 : %s\n", *(name+y));
		printf(" 총합 : %d\n", *(*(score+y)+3));
		printf(" 평균 : %f\n", *(avg+y));
	}

}