package Algorithms;

import StackImpl.LinkedStack;
import StackImpl.Stack;

public class Arrays {

    public static <E> void reverse(E[] e){
        Stack<E> buffer = new LinkedStack<>();

        for(E elem : e){
            buffer.push(elem);
        }


        System.out.println(buffer.toString());


        System.out.println(buffer.size());

        for(int i = 0; i < e.length; i++) {
            e[i] = buffer.pop();
        }
    }
}
