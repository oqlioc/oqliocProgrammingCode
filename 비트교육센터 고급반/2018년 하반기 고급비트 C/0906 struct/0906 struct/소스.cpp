#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <math.h>

typedef struct point {
	int xpos;
	int ypos;
}ptr ;

typedef struct circle{
	double radius;
	ptr *center;
}clc ;

void main()
{
	
	ptr pos = {2, 7};
	double rad = 5.5;

	clc ring = {rad, &pos};

	printf(" ¹ÝÁö¸§ : %g\n", ring.radius);
	printf(" ÁÂÇ¥ : (%d, %d)\n", ring.center->xpos, ring.center->ypos);
}