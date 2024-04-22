#include <stdio.h>
#define ARR_SIZE 5

int arr[ARR_SIZE];

void display()
{
	int i;
	for ( i = 0; i < ARR_SIZE; i++)
	{
		if(arr[i]!=NULL)
		printf("%d -> %d ", i, arr[i]);
	}
}

int hash(int data)
{
	return data % 10;
}

void insert(int value)
{
	int index = hash(value);
	if (arr[index] == NULL)
		arr[index] = value;
	else{
	int i = 1;
	
		while (1)
		{
			
			index += i * i;
			if (index >= ARR_SIZE)
			{
				printf("Array Overflow");
				break;
			}

			if (arr[index] == NULL)
			{
				arr[index] = value;
				break;
			}
			 i++;
		}
	}
}

void main()
{

	insert(42);
	insert(50);
	insert(53);
	display();
}
