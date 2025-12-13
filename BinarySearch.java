public class BinarySearch {
    static int[] data = {1, 3, 5, 7, 9, 11, 13};

    public static void main(String[] args) {
        test(1); // начало массива
        test(13); // конец
        test(7); // середина
        test(48); // нет в массиве
    }

    public static void test(int target) {
        int result = binarySearch(data, target);
        System.out.println("Checking target: " + target + ". Result: " + result);
    }

    public static int binarySearch(int[] array, int target) {
        // Асимптотическая сложность -  Olog(n) потому что на каждом шаге отсекается половина массива
        // после первого прохода элементов останется n/2, на втором - n/2^2, на третьем n/2^3
        // количество итераций можно найти по формуле log2(n)
        // Сложность по памяти O(1), мы не создаем копий массива
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = getMiddle(left, right);

            if (array[mid] == target) {
                return mid;
            }

            // массив должен быть отсортирован, иначе отсечение половины значений
            // при сравнении середины с искомым не имеет смысла

            if (array[mid] < target) {
                left = mid + 1;
            }

            if (array[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }

    private static int getMiddle(int left, int right) {
        return left + (right - left) / 2;
    }
}
