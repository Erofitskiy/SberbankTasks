
/*
Задачи

•	Написать сортировку пузырьком или бинарный поиск элемента в массиве.
•	Реализовать иерархию объектов Circle, Rect, Triangle, Square
•	Реализовать конвертеры температуры. Считаем, что значения будут поступать по шкале Цельсия, конвертеры должны преобразовывать значение в свою шкалу.

 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        convert(0);
        System.out.println();
        convert(10);
        System.out.println();
        convert(33.5);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(3);
        list.add(40);
        list.add(6);
        list.add(70);
        list.add(0);
        System.out.println(list);
        bubbleSort(list);
        System.out.println(list);

        System.out.println(binarySearch(list,70));
        System.out.println(binarySearch(list,1));
    }

    public static void bubbleSort(List<Integer> list){
        for (int i = 0; i < list.size()- 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public static Integer binarySearch(List<Integer> list, Integer elem) throws Exception {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < elem) {
                low = mid + 1;
            } else if (list.get(mid) > elem) {
                high = mid - 1;
            } else if (list.get(mid).equals(elem)) {
                return mid;
            }
        }
        throw new Exception("Element not found");
    }

    public static void convert(double celsius){
        double fahrenheit = (celsius * 9/5.0) + 32;
        double kelvin = celsius + 273.15;
        System.out.println(celsius + " C");
        System.out.println(fahrenheit + " F");
        System.out.println(kelvin + " K");
    }
}

class Circle {

}

class Rectangle {

}

class Triangle {

}

class Square extends Rectangle {

}



