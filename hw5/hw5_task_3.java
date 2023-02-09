// Реализовать алгоритм пирамидальной сортировки (HeapSort)

package hw5;

public class hw5_task_3 {
    public static void main(String args[]) {
        int arr[] = { 12, 58, 13, 5, 1, 7 };
        System.out.println("Первоначальный массив:");
        printArray(arr);

        System.out.println();
        sort(arr);
        System.out.println("Отсортированный массив:");
        printArray(arr);
    }

    public static void sort(int arr[]) {
        int N = arr.length;

        // Построить кучу (переставить массив)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // Один за другим извлечь элементы из кучи
        for (int i = N - 1; i > 0; i--) {
            // Переместить текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // вызов heapify для уменьшенной кучи
            heapify(arr, i, 0);
        }
    }

    // Для создания кучи поддерева с корнем в узле i, который является индексом в arr[]. N - размер кучи
    static void heapify(int arr[], int N, int i) {
        int largest = i; 
        int l = 2 * i + 1; // left
        int r = 2 * i + 2; // right

        // Если левый ребенок больше корневого
        if (l < N && arr[l] > arr[largest])
            largest = l;

        // Если правый ребенок больше, чем самый большой на данный момент
        if (r < N && arr[r] > arr[largest])
            largest = r;

        // Если самый большой не является корневым
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивный вызов heapify для поддеревьев
            heapify(arr, N, largest);
        }
    }

    // Печать массива
    static void printArray(int arr[]) {
        int N = arr.length;

        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
