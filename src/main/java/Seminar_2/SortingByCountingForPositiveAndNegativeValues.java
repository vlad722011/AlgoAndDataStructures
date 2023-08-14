package Seminar_2;

import java.util.Arrays;

public class SortingByCountingForPositiveAndNegativeValues {
    public static void main(String[] args) {
        int[] arr = {3, 5, -4, -6, 4, 3, 3, -6};
        System.out.println("Входящий массив");
        System.out.println(Arrays.toString(arr));

        System.out.println("Сортируем массив методом сортировки подсчетом): ");
        System.out.println(Arrays.toString(sortArrayByCountingMethod(arr)));

    }

    private static int [] sortArrayByCountingMethod(int[] array) {

        //Найдём максимальное число в массиве
        int maxElementInArray = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxElementInArray) {
                maxElementInArray = array[i];
            }
        }
        //Найдём минимальное число в массиве
        int minElementInArray = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minElementInArray) {
                minElementInArray = array[i];
            }
        }

        //Создадим новый массив длиной, равной разнице между максимальным и минимальным элементами входящего
        // массива увеличенной на единицу. Созданный массив по умолчанию наполнен нулями.
        int[] tempArray = new int[(maxElementInArray - minElementInArray) + 1];

        //Запишем в него количество вхождений каждого элемента поиндексно.
        for (int i = 0; i < array.length; i++) {
            int index = array[i] + (minElementInArray * -1);
            tempArray[index] = tempArray[index] + 1;
        }

        // Сортируем массив
        int value = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] != 0) {
                value = i - (minElementInArray * -1);
                int count = tempArray[i];
                while (count > 0){
                    array[index] = value;
                    index++;
                    count --;
                }
            }
        }
        return array;
    }
}
