#include <stdio.h>
#include <stdlib.h>

struct Node
{
	int value;
	struct Node *next;
};

struct Node *first_node = NULL;

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

void insertAtStart()
{
	struct Node *new_node = createNode();

	if (first_node == NULL)
	{
		first_node = new_node;
	}
	else
	{
		new_node->next = first_node;
		first_node = new_node;
	}
}

void insertAt(int position)
{
	struct Node *new_node = createNode();

	if (position == 0)
	{
		first_node = new_node;
	}
	else
	{
		struct Node *prev_node;
		struct Node *next_node = first_node;

		int i;
		for (i = 1; i < position; i++)
		{
			prev_node = next_node;
			next_node = next_node->next;
		}
		prev_node->next = new_node;
		new_node->next = next_node;
	}
}

void insertAtEnd()
{
	struct Node *new_node = createNode();

	if (first_node == NULL)
	{
		first_node = new_node;
	}
	else
	{
		struct Node *last_node = first_node;

		while (last_node->next != NULL)
		{
			last_node = last_node->next;
		}
		last_node->next = new_node;
	}
}

void removeFromStart()
{
	if (first_node == NULL)
	{
		printf("List is empty");
	}
	else
	{
		first_node = first_node->next;
	}
}
void removeFromEnd()
{
	if (first_node == NULL)
	{
		printf("List is empty");
	}
	else if (first_node->next == NULL)
	{
		first_node = NULL;
		printf("List cleared");
	}
	else
	{
		struct Node *last_node = first_node;
		struct Node *second_last_node;

		while (last_node->next != NULL)
		{
			second_last_node = last_node;
			last_node = last_node->next;
		}

		second_last_node->next = NULL;
		printf("deleted item from end: %d", last_node->value);
	}
}

void displayList()
{
	struct Node *temp = first_node;

	printf("\nThe list is: ");
	while (temp != NULL)
	{
		printf("%d, ", temp->value);
		temp = temp->next;
	}
	printf("\n\n");
}

int main()
{
	int option = 0;
	while (option != -1)
	{
		printf("Choose an option:\n1. Insert node at start\n2. Insert node at position\n3. Insert node at end\n4. Delete node at start\n5. Delete node at end\n6. Display\n");
		scanf("%d", &option);
		switch (option)
		{
		case 1:
			insertAtStart();
			break;
		case 2:
		{
			int position;
			printf("\nPosition: ");
			scanf("%d", &position);
			insertAt(position);
			break;
		}
		case 3:
			insertAtEnd();
			break;
		case 4:
			removeFromStart();
			break;
		case 5:
			removeFromEnd();
			break;
		case 6:
			displayList();
			break;
		default:
			printf("Invalid option. Please choose again or enter -1 to exit.\n");
		}
	}
	return 0;
}
