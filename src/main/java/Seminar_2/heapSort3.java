package Seminar_2;
import java.util.Arrays;
import java.util.Scanner;
public class heapSort3 {
    private static int heapSize;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину входящего массива: ");
        int arraySize = scanner.nextInt();
        System.out.println("Введите элементы массива : ");
        int[] inArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            inArray[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(inArray));
        System.out.println("Сортируем массив методом сортировки кучей (наглядная демонстрация процесса, пошагово): ");
        sort(inArray);
    }
    public static void sort(int[] arr) {
        buildHeap(arr);
        while (heapSize > 1) {
            swap(arr, 0, heapSize - 1);
            heapSize--;
            heapify(arr, 0);
        }
    }
    public static void buildHeap(int[] array) {
        heapSize = array.length;
        for (int i = array.length / 2; i >= 0; i--) {
            heapify(array, i);
        }
        System.out.println(Arrays.toString(array));
    }
    private static void heapify(int[] a, int rootIndex) {
        int l = left(rootIndex);
        int r = right(rootIndex);
        int largest = rootIndex;
        if (l < heapSize && a[rootIndex] < a[l]) {
            largest = l;
        }
        if (r < heapSize && a[largest] < a[r]) {
            largest = r;
        }
        if (rootIndex != largest) {
            swap(a, rootIndex, largest);
            heapify(a, largest);
        }
    }
    private static int right(int i) {
        return 2 * i + 2;
    }
    private static int left(int i) {
        return 2 * i + 1;
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        System.out.println(Arrays.toString(array));
    }
}


