using System;

public class MergeSort
{
    public static void Sort(int[] array, int left, int right)
    {
        if (left < right)
        {
            int mid = (left + right) / 2;
            Sort(array, left, mid);
            Sort(array, mid + 1, right);
            Merge(array, left, mid, right);
        }
    }

    private static void Merge(int[] array, int left, int mid, int right)
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = array[mid + 1 + j];

        int i1 = 0, j1 = 0, k = left;

        while (i1 < n1 && j1 < n2)
        {
            if (leftArray[i1] <= rightArray[j1])
            {
                array[k] = leftArray[i1];
                i1++;
            }
            else
            {
                array[k] = rightArray[j1];
                j1++;
            }
            k++;
        }

        while (i1 < n1)
        {
            array[k] = leftArray[i1];
            i1++;
            k++;
        }

        while (j1 < n2)
        {
            array[k] = rightArray[j1];
            j1++;
            k++;
        }
    }
}