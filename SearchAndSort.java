import java.util.Arrays;
import java.util.Scanner;

class SearchAndSort {

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Enter the key to search:");
        int key = scanner.nextInt();
        System.out.println("Enter the type of search (linear/binary):");
        String searchType = scanner.next();
        if (searchType.equals("linear")) {
            long startTime = System.nanoTime();
            int index = linearSearch(arr, key);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            if (index == -1) {
                System.out.println("Element not found");
            } else {
                System.out.println("Element found at index " + index);
            }
            System.out.println("Time taken: " + duration + " nanoseconds");
        } else if (searchType.equals("binary")) {
            long startTime = System.nanoTime();
            int index = binarySearch(arr, key);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            if (index == -1) {
                System.out.println("Element not found");
            } else {
                System.out.println("Element found at index " + index);
            }
            System.out.println("Time taken: " + duration + " nanoseconds");
        } else {
            System.out.println("Invalid search type");
        }
        System.out.println("Enter the type of sort (merge/bubble/insertion):");
        String sortType = scanner.next();
        if (sortType.equals("merge")) {
            long startTime = System.nanoTime();
            mergeSort(arr, 0, n - 1);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Sorted array: " + Arrays.toString(arr));
            System.out.println("Time taken: " + duration + " nanoseconds");
        } else if (sortType.equals("bubble")) {
            long startTime = System.nanoTime();
            bubbleSort(arr);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Sorted array: " + Arrays.toString(arr));
            System.out.println("Time taken: " + duration + " nanoseconds");
        } else if (sortType.equals("insertion")) {
            long startTime = System.nanoTime();
            insertionSort(arr);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Sorted array: " + Arrays.toString(arr));
            System.out.println("Time taken: " + duration + " nanoseconds");
        } else {
            System.out.println("Invalid sort type");
        }
        scanner.close();
    }
} 