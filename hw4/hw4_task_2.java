/* Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди, 
dequeue() - возвращает первый элемент из очереди и удаляет его, 
first() - возвращает первый элемент из очереди, не удаляя.
*/

package hw4;

import java.util.Arrays;
import java.util.LinkedList;

public class hw4_task_2 {
    public static LinkedList<String> queue;

    public static void main(String[] args) {
        queue = new LinkedList<>();

        enqueue("a");
        enqueue("b");
        enqueue("c");

        System.out.println(Arrays.toString(queue.toArray()));
        
        dequeue();
        System.out.println(Arrays.toString(queue.toArray()));

        first();
        System.out.println(Arrays.toString(queue.toArray()));
    }

    /**
     * помещает элемент в конец очереди
     * @param element элемент для добавления
     */
    public static void enqueue(String element) {
        queue.add(element);
    }

    /**
     * возвращает первый элемент из очереди и удаляет его
     */
    public static void dequeue() {
        System.out.println(queue.getFirst());
        queue.removeFirst();
    }

    /**
     * возвращает первый элемент из очереди, не удаляя
     */
    public static void first() {
        System.out.println(queue.getFirst());
    }
}
