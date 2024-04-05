#include <stdio.h>
#include <stdlib.h>

struct Node
{
	int value;
	struct Node *next;
};

struct Node *top = NULL;

struct Node *createNode()
{
	struct Node *new_node;
	new_node = (struct Node *)malloc(sizeof(struct Node));
	if (new_node == NULL)
	{
		printf("Out of memory");
		exit(0);
	}
	printf("\nEnter value for new node: ");

	scanf("%d", &new_node->value);
	new_node->next = NULL;
	return new_node;
}

void push()
{
	struct Node *newNode = createNode();
	newNode->next = top;
	top = newNode;
}
void pop(){
	if(top==NULL){
		printf("Stack is empty. Can't Pop");
	}else{
		struct Node * temp = top;
		top=top->next;
		free(temp);
	}
}

void display(){
	if(top==NULL){
		printf("stack is empty.");
	}else{
		printf("stack is: ");
		struct Node * temp = top;
		while(temp->next !=NULL){
			printf("%d,",temp->value);
			temp=temp->next;
		}
		printf("%d\n",temp->value);
	}
}

void main(){
	int option = 0;
	while (option != -1)
	{
		printf("Choose an option:\n1. Push\n2. Pop \n3. Display\n");
		scanf("%d", &option);
		switch (option)
		{
		case 1:
			push();
			break;
		case 2:
			pop();
			break;
		case 3:
			display();
			break;
		default:
			printf("Invalid option. Please choose again or enter -1 to exit.\n");
		}
	}
}
