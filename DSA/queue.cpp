#include <stdio.h>
#include <stdlib.h>

#define ARR_SIZE 5

int arr[ARR_SIZE];
int front = -1;
int rear = -1;

void reset()
{
	rear = -1;
	front = -1;
}

void enqueue()
{
	if (rear != ARR_SIZE - 1)
	{
		printf("Please enter a number to enqueue into queue: ");
		int n;
		scanf("%d", &n);
		if (front == -1)
			front = 0;
		rear++;
		arr[rear] = n;
		printf("%d came into the queue\n\n", arr[rear]);
	}
	else
	{
		printf("Array is full\n");
	}
}

void dequeue()
{
	if (front != -1)
	{
		printf("%d going out from the queue\n\n", arr[front]);
		if (front == rear - 1)
			reset();
		else
			front++;
	}
	else
	{
		printf("Queue is empty\n");
	}
}

void display()
{
	if (rear != -1)
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

	return 0;
}
