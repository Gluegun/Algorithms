package merge_sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {24, -8, 1, 5, 4, 2, 98};

        mergeSort(arr);

        System.out.println(Arrays.toString(arr));


    }


    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }

        int n = array.length;
        int middle = array.length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[n - middle];

        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
        }
        for (int i = middle; i < n; i++) {
            rightArray[i - middle] = array[i];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(array, leftArray, rightArray);
    }

    private static void merge(int[] array, int[] leftArray, int[] rightArray) {

        int left = array.length / 2;
        int right = array.length - array.length / 2;

        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < left) {
            array[k++] = leftArray[i++];
        }

        while (j < right) {
            array[k++] = rightArray[j++];
        }
    }
}

