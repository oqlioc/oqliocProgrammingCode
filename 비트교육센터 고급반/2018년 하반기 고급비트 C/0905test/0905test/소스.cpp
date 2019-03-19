#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
/*
void StudentInput(int *n, char **name, int **stu);
void Getsum(int *n, int *sum, int **stu);
void Sumavg(int *n, int *sum, float *avg);
void Output(int *n, char **name, int *sum, float *avg);
*/
void StudentInput(int n, char **name, int **stu)
{
	//stu = (int **)malloc(sizeof(int *)* n);  
	//name = (char **)malloc(sizeof(char *)* n);


	for(int i = 0; i < n; i++)
	{
		//name[i] = (char *)malloc(10 * sizeof(char));
		printf(" 학생 이름? : ");
		scanf("%s", name[i]);

		//stu[i] = (int *)malloc(3 * sizeof(int));

		printf(" %s 학생의 국영수 점수? : " , name[i]);
		scanf("%d %d %d", &stu[i][0],&stu[i][1],&stu[i][2]);
	}
}

void Getsum(int n, int *sum, int **stu)
{
	for(int i = 0; i < n; i++)
	{
		sum[i] = 0;
		for(int j = 0; j < 3; j++)
		{
			sum[i] += stu[i][j];
		}
	}
}

void Sumavg(int n, int *sum, float *avg)
{

	for(int i = 0; i < n; i++)
	{
		avg[i] = 0 + sum[i] /3.f;
	}
}

void Output(int n, char **name, int *sum, float *avg)
{
	for(int i = 0; i < n; i++)
	{
		printf(" 이름 : %s \n", name[i]);
		printf(" 총합 : %d \n", sum[i]);
		printf(" 평균 : %.3f \n", avg[i]);
	}
}

int NumInput ()
{
	int temp;

	printf(" 학생은 몇명? : ");
	scanf("%d",&temp);
	return temp;
}

char** MemoryName(int n)
{
	char **temp;

	temp = (char **)malloc(sizeof(char *)* n);
	for (int i = 0; i < n; i++)
	{
		temp[i] = (char *)malloc(10 * sizeof(char));
	}

	return temp;
}

int** MemoryStu(int n)
{
	int i;
	int **temp;

	temp = (int **)malloc(sizeof(int *)* n);
	for ( i = 0; i < n; i++)
	{
		temp[i] = (int *)malloc(3 * sizeof(int));
	}

	return temp;
}

int* MemorySum(int n)
{
	int *temp;

	temp = (int *)malloc(sizeof(int)* (n));

	return temp;
}

float* MemoryAvg(int n)
{
	float *temp;

	temp = (float *)malloc(sizeof(float)* (n));

	return temp;
}

void main()
{
	int **stu = NULL;
	char **name = NULL;
	int n;
	int *sum = NULL;
	float *avg = NULL;

	n = NumInput();
	name = MemoryName(n);
	stu = MemoryStu(n);
	sum = MemorySum(n);
	avg = MemoryAvg(n);

	StudentInput(n, name, stu);

	Getsum(n, sum, stu);
	Sumavg(n, sum, avg);
	Output(n, name, sum, avg);

	free(name);
	free(stu);
	free(sum);
	free(avg);
}
