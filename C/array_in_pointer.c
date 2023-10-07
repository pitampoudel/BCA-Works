#include <stdio.h>
 
 
int main () 
{
	int size=3;
   int var[size];
   
   
   int i, *ptr[size];
 
   for ( i = 0; i <= size; i++) 
   {
   	  printf("Enter variable for var[%d]\n",i);
   	  scanf("%d",var+i);   //var+i=&x[i]
      ptr[i] = &var[size-i]; /* assign the address of integer. */
   }
   
   for ( i = 0; i <= size; i++) 
   {
      printf("Value of var[%d] = %d\n", i, *ptr[size-i] );
   }
   
   for ( i = 0; i <= size; i++) 
   {
      printf("Address of var[%d] = %d\n", i, ptr[size-i] );
   }
   
   return 0;
}
