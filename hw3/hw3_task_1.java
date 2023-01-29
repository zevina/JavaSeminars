// Реализовать алгоритм сортировки слиянием

package hw3;

import java.util.Arrays;
import java.util.Random;

public class hw3_task_1 {
    public static void main(String[] args) {
        int[] randomNumbers = createAndFillArray(10, 0, 100);

        System.out.print("Исходный массив чисел:\n");
        System.out.println(Arrays.toString(randomNumbers));
        System.out.println();
        
        mergeSort(randomNumbers, 0, randomNumbers.length-1);
        System.out.print("Отсортированный массив чисел:\n");
        System.out.println(Arrays.toString(randomNumbers));
    }
    
    /**
     * Метод создает и наполняет массив случайными числами из заданного диапазона
     * @param size размер массива
     * @param min минимальное значение диапазона
     * @param max максимальное значение диапазона
     * @return массив случайных чисел
     */
    public static int[] createAndFillArray(int size, int min, int max) {
        Random random = new Random();
        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(min, max);
        }
        return randomArray;
    }
    

    public static void mergeSort(int[] array, int left, int right) {  
        if (right <= left) return;
        int mid = (left+right)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }
    

    public static void merge(int[] array, int left, int mid, int right) {
        // вычисляем длину
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;
    
        // создаем временные подмассивы
        int leftArray[] = new int [lengthLeft];
        int rightArray[] = new int [lengthRight];
    
        // копируем отсортированные массивы во временные
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid+i+1];
    
        // итераторы содержат текущий индекс временного подмассива
        int leftIndex = 0;
        int rightIndex = 0;
    
        // копируем из leftArray и rightArray обратно в массив  
        for (int i = left; i < right + 1; i++) {
            
            // если остаются нескопированные элементы в R и L, копируем минимальный
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // если все элементы были скопированы из rightArray, скопировать остальные из leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // если все элементы были скопированы из leftArray, скопировать остальные из rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}

