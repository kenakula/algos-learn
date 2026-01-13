import java.util.ArrayDeque;
import java.util.Deque;

public class QuickSort {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        int[] empty = {};
        int[] full = {12, -2, 44, 2, 6, 8, -3, 1, 4};
        int[] single = {4};

        quickSort(empty);
        printArray(empty);

        quickSort(full);
        printArray(full);

        quickSort(single);
        printArray(single);
    }

    public static void printArray(int[] array) {
        for (int el : array) {
            System.out.print(el + " ");
        }

        System.out.print('\n');
    }

    public static void quickSort(int[] arr) {
        if (arr.length < 1) return;

        Deque<Integer> stack = new ArrayDeque<>(); // стэк для хранения позиций в массиве
        stack.push(0); // добавляем стартовые позиции
        stack.push(arr.length - 1);

        while (!stack.isEmpty()) {
            // пока есть что-то в стэке
            int high = stack.pop();
            int low = stack.pop();

            int pivotIndex = partition(arr, low, high); // индекс элемента разделяющего массив на две части (меньше и больше поворотного)

            // добавляем новые позиции в стэк
            if (pivotIndex - 1 > low) {
                stack.push(low);
                stack.push(pivotIndex - 1);
            }

            if (pivotIndex + 1 < high) {
                stack.push(pivotIndex + 1);
                stack.push(high);
            }
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // сохраняет позицию элемента до которого все элементы меньше поворотного

        for (int j = low; j < high; j++) {
            // двигаем левую границу подмассива
            if (arr[j] < pivot) {
                // если элемент меньше поворотного передвигаем его влево
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // после того как прошлись по элементам и подвигали все элементы меньше поворотного
        // двигаем поворотный элемент на позицию, где левее него будут элементы меньше него, а правее - больше
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // возвращаем позицию поворотного элемента
        return i + 1;
    }
}