#include <stdio.h>
#include <stdlib.h>


int main(void)
{
	/*
	int clas[3] = {0}; // ���̸�
	char name[3][3][10] = {0}; // �л��̸�
	int score[3][3][4] = {0}; // ��������
	float avg[3][3] = {0}; // �л��� �������� ���
	float clasavg[3] = {0}; // Ŭ������ �������� ���

	for(int z = 0; z < 3; z++)
	{
		printf(" �� �̸� �Է� : ");
		scanf("%d��", &clas[z]);
		
		for(int y = 0; y < 3; y++)
		{
			printf("  �л� �̸� �Է� : ");
			scanf("%s", name[z][y]);
			
			for(int x = 0; x < 3; x++)
			{
				printf("   ���� ���� ���� ���� �Է� : ");
				scanf("%d", &score[z][y][x]);
				score[z][y][3] += score[z][y][x];

			}
			avg[z][y] = score[z][y][3]/3.f;
		}
	}

	for(int i = 0; i < 3; i++)
	{
		printf(" %d ��\n ", clas[i]);
		
		for(int j = 0; j < 3; j++)
		{
			printf("  �̸� : %s \n ", name[i][j]);
			printf("  ���� : %d \n ", score[i][j][3]);
			for(int k = 0; k < 3; k++)
			{
				clasavg[i] += score[j][k][3];
			}
		}

		printf(" �ݺ� ��� : %f \n", clasavg[i]/9.f);
	}

	return 0;
	*/

	int clas[3] = {0}; // ���̸�
	char name[3][3][10] = {0}; // �л��̸�
	int score[3][3][4] = {0}; // ��������
	float avg[3][3] = {0}; // �л��� �������� ���
	float clasavg[3] = {0}; // Ŭ������ �������� ���

	for(int z = 0; z < 3; z++)
	{
		printf(" �� �̸� �Է� : ");
		scanf("%d��", clas+z);
		
		for(int y = 0; y < 3; y++)
		{
			printf("  �л� �̸� �Է� : ");
			scanf("%s", *(*(name+z)+y));
			
			for(int x = 0; x < 3; x++)
			{
				printf("   ���� ���� ���� ���� �Է� : ");
				scanf("%d", *(*(*(&score+z)+y)+x));
				*(*(*(score+z)+y)+3) += *(*(*(score+z)+y)+x);

			}
			*(*(avg+z)+y) = *(*(*(score+z)+y)+3)/3.f;
		}
	}

	for(int i = 0; i < 3; i++)
	{
		printf(" %d ��\n ", clas[i]);
		
		for(int j = 0; j < 3; j++)
		{
			printf("  �̸� : %s \n ", *(*(name+i)+j));
			printf("  ���� : %d \n ", *(*(*(score+i)+j)+3));
			for(int k = 0; k < 3; k++)
			{
				*(clasavg+i) += *(*(*(score+j)+k)+3);
			}
		}

		printf(" �ݺ� ��� : %f \n", *(clasavg+i)/9.f);
	}

	return 0;
}