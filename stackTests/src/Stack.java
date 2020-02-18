

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private int size=0;
    private int capacity;
    private List<T> list;

    public Stack(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>();
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean isFull(){
        return size==capacity;
    }

    public void push(T obj) throws Exception{
        if(obj==null) return;
        if(!isFull())
        {
        list.add(obj);
        size++;
        }
        else throw new Exception("The stack is full !");

    }

    public void pop() throws Exception{
        if(isEmpty())
            throw new Exception("The stack is empty !");
        else {
            list.remove(size-1);
            size--;
        }
    }

    public T top(){
        if(isEmpty())
            return null;
        else {
            return list.get(size-1);
        }
    }

    public T topAndPop() throws Exception {
        T temp = top();
        pop();
        return temp;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void empty(){
        list.clear();
        size=0;
    }
}
