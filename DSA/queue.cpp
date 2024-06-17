#include <stdio.h>
#include <stdlib.h>

#define ARR_SIZE 5

int arr[ARR_SIZE];
int front = -1;
int rear = -1;

int isFull()
{
	if (front == ( (rear + 1) % ARR_SIZE) + 1)
		return 1;
	return 0;
}

int isEmpty()
{
	if (front == -1)
		return 1;
	return 0;
}

void enqueue()
{
	if (isFull())
		printf("\n Queue is full!! \n");
	else
	{
		printf("Please enter a number to enqueue into queue: ");
		int element;
		scanf("%d", &element);

		if (front == -1)
			front = 0;
		rear = (rear + 1) % ARR_SIZE;
		arr[rear] = element;
		printf("\n Inserted -> %d\n", element);
	}
}

void dequeue()
{

	int element;
	if (isEmpty())
	{
		printf("\n Queue is empty !! \n");
	}
	else
	{
		element = arr[front];
		if (front == rear)
		{
			front = -1;
			rear = -1;
		}
		// Q has only one element, so we reset the
		// queue after dequeing it. ?
		else
		{
			front = (front + 1) % ARR_SIZE;
		}
		printf("\n Deleted element -> %d \n", element);
	}
}

void display()
{
	if (!isEmpty())
	{
		printf("Queue is (rear to front):\n");
		for (int i = rear; i >= front; i--)
		{
			printf("%d\n", arr[i]);
		}
		printf("\n");
	}
	else
	{
		printf("Queue is empty\n");
	}
}

int main()
{
	int choice;
	while (choice != 4)
	{
		printf("Please choose an option below:\n");
		printf("1.Enqueue\n2.Dequeue\n3.Display\n4.Stop\n");

		scanf("%d", &choice);

		switch (choice)
		{
		case 1:
			enqueue();
			break;
		case 2:
			dequeue();
			break;
		case 3:
			display();
			break;
		}
	}
	printf("© Copyright Pitam Poudel. All Rights Reserved");
	return 0;
}
