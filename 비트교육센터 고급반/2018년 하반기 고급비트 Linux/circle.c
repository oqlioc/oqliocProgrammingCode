#include <stdio.h>

void main()
{
	double pi = 3.141592;
	int radius = 0;

	printf("반지름을 입력하세요 : ");
	scanf("%d", &radius);

	double result = pi * radius * radius;
	printf("반지름 : %d \n", radius);
	// %전체자릿수, 소수 이하 자릿수
	printf("넓이 : %7.2f \n", result);
}