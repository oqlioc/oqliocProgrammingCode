#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void main()
{
	
	int num1 = 100, num2 = 200, num3 = 300;

	int *arr[3] = {&num1, &num2, &num3};
	printf("%d \n", *arr[0]);
	printf("%d \n", *arr[1]);
	printf("%d \n", *arr[2]);

}
