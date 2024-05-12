#include<stdio.h>

void swap(int arr[], int first, int second){
	int temp = arr[first];
	arr[first]= arr[second];
	arr[second]=temp;
}
	
void exchange_sort(int arr[], int size){
	int i,j;
	for(i=0;i<size;i++){
		for(j =i+1; j<size; j++){
			if(arr[i]>arr[j]){
				swap(arr,i,j);
			}
		}
	}
}

void bubble_sort(int arr[], int size){
	int i,j;
	for(i=0;i<size-1;i++){
   	for(j=0;j<size-i-1;j++){
		if(arr[j]>arr[j+1]){
			swap(arr,j,j+1);
		}
	}
}
}

void display(int arr[], int size){
	int i;
	for( i=0;i<size;i++){
     printf("%d,",arr[i]);
	}
	
}

void main(){
	int arr[] = {0,3,2,5,6,2};
	bubble_sort(arr,6);
    exchange_sort(arr,6);
	display(arr,6);
	
}
