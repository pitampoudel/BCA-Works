#include <stdio.h>
#include <stdlib.h>

struct Node
{
	int value;
	struct Node *right, *left;
};

void preorder_traversal(struct Node *parent)
{
	if (parent != NULL)
	{
		printf("%d ", parent->value);
		preorder_traversal(parent->left);
		preorder_traversal(parent->right);
	}
}
void inorder_traversal(struct Node *parent)
{
	if (parent != NULL)
	{
		inorder_traversal(parent->left);
		printf("%d ", parent->value);
		inorder_traversal(parent->right);
	}
}
void postorder_traversal(struct Node *parent)
{
	if (parent != NULL)
	{
		postorder_traversal(parent->left);
		postorder_traversal(parent->right);
		printf("%d ", parent->value);
	}
}

struct Node *insert(struct Node *parent, int value)
{
	if (parent == NULL)
	{
		struct Node *temp = (struct Node *)malloc(sizeof(struct Node));
		temp->value = value;
		temp->left = temp->right = NULL;
		return temp;
	}
	else
	{
		if (value < parent->value)
		{
			parent->left = insert(parent->left, value);
		}
		else if (value > parent->value)
		{
			parent->right = insert(parent->right, value);
		}
	}
	return parent;
}

struct Node *search_bst(struct Node *parent, int target)
{
	if (parent == NULL)
		return NULL;
	if (parent->value == target)
		return parent;
	if (target < parent->value)
		return search_bst(parent->left, target);
	if (target > parent->value)
		return search_bst(parent->right, target);
}

void askAndSearch(struct Node *root)
{
	int target;
	printf("Enter value to search:");
	scanf("%d", &target);
	struct Node *search_result = search_bst(root, target);
	if (search_result == NULL)
	{
		printf("%d not found \n", target);
	}
	else
	{
		printf("%d found \n", search_result->value);
	}
}

struct Node *minValueNode(struct Node *root)
{
	struct Node *temp = root;
	while (temp->left != NULL)
		temp = temp->left;
	return temp;
}
struct Node *delete(struct Node *root, int target)
{
	if (root == NULL)
		return NULL;
	else if (target < root->value)
		return delete (root->left, target);
	else if (target > root->value)
		return delete (root->right, target);
	// root.value == target.value
	else
	{
		if (root->left == NULL)
		{
			struct Node *temp = root->right;
			free(root);
			return temp;
		}
		else if (root->right == NULL)
		{
			struct Node *temp = root->left;
			free(root);
			return temp;
		}
		struct Node *temp = minValueNode(root->right);
		root->value = temp->value;
		root->right = delete (root->right, temp->value);
	}
	return root;
}

void askAndDelete(struct Node *root)
{
	int target;
	printf("Enter value to delete:");
	scanf("%d", &target);
	struct Node *deleted = delete (root, target);
}

int main()
{
	struct Node *root = insert(NULL, 50);
	insert(root, 30);
	insert(root, 20);
	insert(root, 40);
	insert(root, 70);
	insert(root, 60);
	insert(root, 80);

	int choice = 0;
	while (choice != -1)
	{

		printf("Choose an option:\n1. In Order Traversal\n2. Pre Order Traversal \n3. Post Order Traversal\n4. Search\n5. Delete\n");
		scanf("%d", &choice);
		switch (choice)
		{
		case 1:
			inorder_traversal(root);
			break;
		case 2:
			preorder_traversal(root);
			break;
		case 3:
			postorder_traversal(root);
			break;
		case 4:
			askAndSearch(root);
			break;
		case 5:
			askAndDelete(root);
			break;
		default:
			printf("Invalid option. Please choose again or enter -1 to exit.\n");
		}
	}

	return 0;
}
