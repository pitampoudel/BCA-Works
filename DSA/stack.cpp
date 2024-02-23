#include<stdio.h>
#include<stdlib.h>

#define ARR_SIZE 5

int arr[ARR_SIZE];
int tos = -1;
	
void push(){
	if(tos!=ARR_SIZE-1){
		printf("Please enter a number to push into stack: ");
		int n;
		scanf("%d",&n);
		tos++;
		arr[tos]=n;
	}else{
		printf("Stack is full");
	}
	
}
void pop(){
	if(tos!=-1){
		tos--;
	}else{
		printf("Stack is empty");
	}
}
void display(){
	if(tos!=-1){
		printf("Stack is:\n");
		for(int i=tos; i>=0; i--){
			printf("%d\n",arr[i]);
		}
		printf("\n");
	}else{
		printf("Stack is empty\n");
	}
	
}
int main(){
	int choice;
	while(choice !=4){
	printf("Please choose an option below:\n");
	printf("1.Push\n2.Pop\n3.Display\n4.Stop\n");

	scanf("%d",&choice);
	
	switch(choice){
		case 1:
			push();
			break;
		case 2:
		   pop();
	 	   break;
		case 3:
	     display();
	      break;	
			
	 }
   }

	return 0;
}
