#include<stdio.h>

int factorial(int n){
	if(n==0) return 1;
	return n * factorial(n-1);
}


int main(){
	printf("Factorial of 5 is %d\n",factorial(5));
	printf("© Copyright Pitam Poudel. All Rights Reserved");
	return 0;
}
