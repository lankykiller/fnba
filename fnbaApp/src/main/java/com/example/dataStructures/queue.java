package com.example.dataStructures;

public class queue <E> {

    private static final int DEFAULT_ARRAY_SIZE = 20;
    private Object [] itemArray  = new Object[DEFAULT_ARRAY_SIZE];
    private int head = 0;
    private int tail = 0;
    private int count = 0;

    public queue(){
        itemArray = new Object[DEFAULT_ARRAY_SIZE];
    }

    public int capacity(){
        return itemArray.length;
    }
    public int size(){
        return count;
    }    
    public boolean isEmpty(){
        return count == 0;
    }
    public void enqueue(E element) throws OutOfMemoryError, NullPointerException{

        if(element == null){
                throw new NullPointerException("Cannot enqueue null element");
        }
    
        if(count == itemArray.length){  
    

            itemArray = reallocate();
           
        }
        
        if(tail >= itemArray.length && head >= 0){
            tail = 0;
        }
    
        itemArray[tail++] = element;
        count++;
    
        }
    
        private Object[] reallocate(){
    
            Object [] newArray = new Object[itemArray.length + 5];
            int index = 0;
            int counter = count;
            int nextItem = head;
    
            while(counter > 0){
                
                newArray[index] = itemArray[nextItem];
                index++;
                nextItem++;
                counter--;
    
                if(nextItem >= itemArray.length){
                nextItem = 0;
                }
            }
    
            head = 0;
            tail = count;
    
        return newArray;
        }

        @SuppressWarnings("unchecked")
        public E dequeue() throws IllegalStateException{

            if(count == 0){
                throw new IllegalStateException("empty queue");
            }
    
            E headElement = (E)itemArray[head];
            count--;
            head++;
    
            if(head >= itemArray.length){
                head = 0;
            }
    
            return headElement;
        }
        
        @SuppressWarnings("unchecked")
        public E element() throws IllegalStateException{

            if(count == 0){
                throw new IllegalStateException("empty queue");
            }
            
            E firstElement = (E)itemArray[head];
            return firstElement;
        }
        
        public void clear(){

            Object [] newArray = new Object[itemArray.length];
            itemArray = newArray;
            count = 0;
            head = 0;
            tail = 0;
        }

        public String toString(){

            StringBuilder StringItemArray = new StringBuilder();
            int counter = count;
            int index = head;
        
            StringItemArray.append("[");
        
                while(counter > 0){
        
                    StringItemArray.append(itemArray[index]);
        
                    if(counter > 1){
                        StringItemArray.append(", ");
                    }
                    index++;
                    counter--;
        
                    if(index >= itemArray.length){
                        index = 0;
                    }
                }
            
            StringItemArray.append("]");
            
            return StringItemArray.toString();
            }
}
