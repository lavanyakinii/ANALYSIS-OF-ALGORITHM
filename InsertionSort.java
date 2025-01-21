public class InsertionSort {
    public static void main(String[] args) 
    {
        int[] arr = {12, 11, 13, 5, 6};

        System.out.println("Original array:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    public static void insertionSort(int[] arr) 
    {
        int n = arr.length;

        for (int j = 1; j < n; j++) 
        { 
            int key = arr[j];
            int i = j - 1;

            while (i >= 0 && arr[i] > key) 
            {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key; 
        }
    }

    public static void printArray(int[] arr)
    {
        for (int num : arr) 
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
