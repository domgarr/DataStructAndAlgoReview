package Algorithms;

import QueueImpl.CircularLinkedQueue;

public class JosephusProblem {
    //https://docs.oracle.com/javase/tutorial/extra/generics/methods.html
    public static <E> E solve(E[] items, int k){
        if(items.length == 0){
            return null;
        }

        CircularLinkedQueue queue = new CircularLinkedQueue<>();
        for(int i = 0; i < items.length; i++){
            queue.enqueue(items[i]);
        }

        while(queue.size() > 1){
            for(int i = 0; i < k - 1; i++){
                queue.rotate();
            }
            queue.dequeue();
        }
        return (E)queue.dequeue();
    }
}
