#include <stdio.h>

void main()
{
 int x;
 double y;
 char z;
 
 int *a;
 double *b;
 char *c;

 int p,q;
 double u,v;

 printf("%ld %ld %ld %ld %ld %ld\n", &x, &y, &z, &a, &b, &c);
 
 x = 10;
 y = 13.21;
 z = 'A';

 printf("%d %f %c\n", x,y,z);

 a = &x; // &x => address of x
 *a = 100;  // *a => a가 가르키는 곳

 b = &y;
 *b = 34.56;

 c = &z;
 *c = 'x';

 *a = *a + 400;
 printf("%d %f %c\n", x,y,z);

 p = *a +30;
 q = *a;
 printf("%d %d\n", p, q);

} 