#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
	/*
	int kor, eng, math;
	int sum;
	float avg;
	
	printf(" Kor, Eng, Math  Score Input : ");
	scanf("%d %d %d", &kor, &eng, &math);

	sum = kor+eng+math;
	avg = (kor+eng+math)/3;

	printf(" �� �� : %d\n ", sum);
	printf(" �� �� : %f\n ", avg);

	if(avg >= 90.0)
		printf(" A ");
	else if(avg >= 80.0)
		printf(" B ");
	else if(avg >= 70.0)
		printf(" C ");
	else if(avg >= 60.0)
		printf(" D ");
	else 
		printf(" F ");
	
	*/
	
	/*
	char name[10];
	int kor, eng, math;
	int sum;
	float avg;

	printf("�̸� �Է� = ");
	scanf("%s", &name);
	fflush(stdin);

	printf(" Kor, Eng, Math  Score Input : ");
	scanf("%d %d %d", &kor, &eng, &math);

	sum = kor+eng+math;
	avg = (kor+eng+math)/3.f;

	if(avg >= 90.0)
		printf(" A\n ");
	else if(avg >= 80.0)
		printf(" B\n ");
	else if(avg >= 70.0)
		printf(" C\n ");
	else if(avg >= 60.0)
		printf(" D\n ");
	else 
		printf(" F\n ");
	
//	printf(" �� �� : %s\n ", &name);
	printf(" �� �� : %d\n ", sum);
	printf(" �� �� : %f\n ", avg);

	return 0;
	*/

	/*
	char name[3][10];
	int kor[3];
	int eng[3];
	int math[3];
	int sum[3];
	float avg[3];

	for(int i = 0; i < 3; i++)
	{
		printf(" �̸� �Է� : ");
		fflush(stdin);
		scanf("%s", name[i]);
		fflush(stdin);
	
		printf("%s�� ���� ���� ���� ����", name[i]);
		scanf("%d %d %d", &kor[i], &eng[i], &math[i]);
		fflush(stdin);
		
		sum[i] = kor[i]+eng[i]+math[i];
		avg[i] = sum[i]/3.f;
	
	}

	for(int i = 0; i < 3; i++)
	{
		printf(" �� �� : %s\n ", name[i]);
		printf(" �� �� : %d\n ", sum[i]);
		printf(" �� �� : %f\n ", avg[i]);

		if(avg[i] >= 90.0)
			printf(" A\n ");
		else if(avg[i] >= 80.0)
			printf(" B\n ");
		else if(avg[i] >= 70.0)
			printf(" C\n ");
		else if(avg[i] >= 60.0)
			printf(" D\n ");
		else 
			printf(" F\n ");
	}
	*/
	char name[3][10];
	int kor[3];
	int eng[3];
	int math[3];
	int sum[3];
	float avg[3];

	for(int i = 0; i < 3; i++)
	{
		printf(" �̸� �Է� : ");
		fflush(stdin);
		scanf("%s", *(name+i));
		fflush(stdin);
	
		printf("%s�� ���� ���� ���� ����", *(name+i));
		scanf("%d %d %d", &kor[i], &eng[i], &math[i]);
		fflush(stdin);
		
		sum[i] = kor[i]+eng[i]+math[i];
		avg[i] = sum[i]/3.f;
	
	}

	for(int i = 0; i < 3; i++)
	{
		printf(" �� �� : %s\n ", name[i]);
		printf(" �� �� : %d\n ", sum[i]);
		printf(" �� �� : %f\n ", avg[i]);

		if(avg[i] >= 90.0)
			printf(" A\n ");
		else if(avg[i] >= 80.0)
			printf(" B\n ");
		else if(avg[i] >= 70.0)
			printf(" C\n ");
		else if(avg[i] >= 60.0)
			printf(" D\n ");
		else 
			printf(" F\n ");
	}
	
	
}