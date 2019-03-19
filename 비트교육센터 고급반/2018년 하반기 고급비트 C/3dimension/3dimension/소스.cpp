#include <stdio.h>
#include <stdlib.h>


int main(void)
{
	/*
	int clas[3] = {0}; // 반이름
	char name[3][3][10] = {0}; // 학생이름
	int score[3][3][4] = {0}; // 시험점수
	float avg[3][3] = {0}; // 학생별 시험점수 평균
	float clasavg[3] = {0}; // 클래스별 시험점수 평균

	for(int z = 0; z < 3; z++)
	{
		printf(" 반 이름 입력 : ");
		scanf("%d반", &clas[z]);
		
		for(int y = 0; y < 3; y++)
		{
			printf("  학생 이름 입력 : ");
			scanf("%s", name[z][y]);
			
			for(int x = 0; x < 3; x++)
			{
				printf("   국어 영어 수학 점수 입력 : ");
				scanf("%d", &score[z][y][x]);
				score[z][y][3] += score[z][y][x];

			}
			avg[z][y] = score[z][y][3]/3.f;
		}
	}

	for(int i = 0; i < 3; i++)
	{
		printf(" %d 반\n ", clas[i]);
		
		for(int j = 0; j < 3; j++)
		{
			printf("  이름 : %s \n ", name[i][j]);
			printf("  총점 : %d \n ", score[i][j][3]);
			for(int k = 0; k < 3; k++)
			{
				clasavg[i] += score[j][k][3];
			}
		}

		printf(" 반별 평균 : %f \n", clasavg[i]/9.f);
	}

	return 0;
	*/

	int clas[3] = {0}; // 반이름
	char name[3][3][10] = {0}; // 학생이름
	int score[3][3][4] = {0}; // 시험점수
	float avg[3][3] = {0}; // 학생별 시험점수 평균
	float clasavg[3] = {0}; // 클래스별 시험점수 평균

	for(int z = 0; z < 3; z++)
	{
		printf(" 반 이름 입력 : ");
		scanf("%d반", clas+z);
		
		for(int y = 0; y < 3; y++)
		{
			printf("  학생 이름 입력 : ");
			scanf("%s", *(*(name+z)+y));
			
			for(int x = 0; x < 3; x++)
			{
				printf("   국어 영어 수학 점수 입력 : ");
				scanf("%d", *(*(*(&score+z)+y)+x));
				*(*(*(score+z)+y)+3) += *(*(*(score+z)+y)+x);

			}
			*(*(avg+z)+y) = *(*(*(score+z)+y)+3)/3.f;
		}
	}

	for(int i = 0; i < 3; i++)
	{
		printf(" %d 반\n ", clas[i]);
		
		for(int j = 0; j < 3; j++)
		{
			printf("  이름 : %s \n ", *(*(name+i)+j));
			printf("  총점 : %d \n ", *(*(*(score+i)+j)+3));
			for(int k = 0; k < 3; k++)
			{
				*(clasavg+i) += *(*(*(score+j)+k)+3);
			}
		}

		printf(" 반별 평균 : %f \n", *(clasavg+i)/9.f);
	}

	return 0;
}