#include <stdio.h>

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

		printf(" �̸� : %s\n", name[y]);
		printf(" ���� : %d\n", score[y][3]);
		printf(" ��� : %f\n", avg[y]);
		
	}
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
		
		printf(" �̸� : %s\n", *(name+y));
		printf(" ���� : %d\n", *(*(score+y)+3));
		printf(" ��� : %f\n", *(avg+y));
	}

}