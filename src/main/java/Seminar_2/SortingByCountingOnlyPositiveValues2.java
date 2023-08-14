package Seminar_2;

import java.util.Arrays;

public class SortingByCountingOnlyPositiveValues2 {
    public static void main(String[] args) {
        int[] arr = {19, 234, 714, 2000, 7, 2, 5, 4, 3, 2, 543, 98, 168, 2, 657, 345};
        System.out.println("Входящий массив");
        System.out.println(Arrays.toString(arr));

        System.out.println("Сортируем массив методом сортировки подсчетом): ");
        System.out.println(Arrays.toString(sortArrayByCountingMethod(arr)));
    }


    private static int[] sortArrayByCountingMethod(int[] array) {

        //Найдём максимальное число в массиве
        int maxElementInArray = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxElementInArray) {
                maxElementInArray = array[i];
            }
        }

        //Создадим новый массив длиной, равной значению максимального элемента входящего массива,
        // увеличенному на единицу. Созданный массив по умолчанию наполнен нулями.
        int[] tempArray = new int[maxElementInArray + 1];
        int[] tempArray1 = new int[maxElementInArray + 1];

        //Запишем в него количество вхождений каждого элемента поиндексно.
        // Первый вариант создания дополнительного массива.
        for (int value : array) {
            ++tempArray[value];
        }
        // Создаем тот же дополнительный массив, более читаемой записью.
        for (int value : array) {
            tempArray1[value] = tempArray1[value] + 1;
        }

        // Сортируем массив
        int b = 0;
        for (int i = 0; i < maxElementInArray + 1; ++i) {
            for (int j = 0; j < tempArray[i]; ++j) {
                array[b++] = i;
            }
        }
        return array;
    }
}
