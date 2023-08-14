package Seminar_2;
import java.util.Arrays;
public class heapSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3, 5, 6, 6, 7, 957, -112, 817, 0, 94};
        System.out.println("Входящий массив");
        System.out.println(Arrays.toString(arr));
        System.out.println("Отсортированный массив");
        System.out.println(Arrays.toString(sort(arr)));
    }
    public static int[] sort(int[] array) {
        // построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        // один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
        return array;
    }
    public static void heapify(int[] array, int heapSize, int rootIndex) {
        // инициализируем наибольший элемент как корень
        int largest = rootIndex;
        // левый потомок корня
        int leftChild = rootIndex * 2 + 1;
        // правый потомок корня
        int rightChild = rootIndex * 2 + 2;
        // если левый потомок больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        // если правый потомок больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
        // если самый большой элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            // рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }
}
