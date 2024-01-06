#include<stdio.h>
int main(){
	int _a1, _a2, _sum; 
	/* 
	Using underscore is not as important but it us usually a
	common naming convention. It's not required by the language 
	itself, but it's a style choice made by many programmers for 
	several reasons; Readabilty, Consistancy, Avoidig Conflicts etc
	*/
	printf("Enter Two integers");
	scanf("%d%d", &_a1, &_a2);
	
	_sum = _a1 + _a2;
	
	printf("%d + %d = %d", _a1, _a2, _sum);
	return -10;
	//This is a common practice to indicate an error or an abnormal termination.
	//Return -10 often used to signify that something went wrong or an error occurred during program execution
}




