package JavaProjects;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T>{
    // Class Attributes
    // Array of T data type 
    private T[] arr;
    // Length of Array
    private int len = 0;
    // total capacity of the Dynamic Array
    private int capacity = 0;

    // constructor 
    public DynamicArray(){

        this(16);
    }

    // constructor
    public DynamicArray(int capacity){
        if(capacity < 0) throw new IllegalArgumentException("Capacity Cannot be Negative");
        this.capacity = capacity;
        arr= (T[]) new Object[capacity];
    }

    // helper methods 
    public int getSize(){
        return len;
    }

    public int getCapacity(){
        return capacity;
    }
    
    public boolean isEmpty(){
        return getSize()==0;
    }

    public T getItem(int index){
        if(index>=len|| index<0) throw new IndexOutOfBoundsException();
        return arr[index];
    }

    public void set(int index, T elem) {
        if(index>=len|| index<0) throw new IndexOutOfBoundsException();
        arr[index] = elem;
    }

    public void clear(){
        // set all element of array to null
        for(int i = 0; i<len; i++) arr[i]=null;
        // reset length attribute
        len=0; 
    }

    public void add(T elem){
        // Check current capacity of array + 1 to see if new element will max out the current capacity  
        if(len+1>=capacity){
            // if current capacity is zero set the capacity to 1
            if(capacity==0) capacity=1;
            // else double the current capacity
            else capacity *=2;
            // instantiate a new array based on new capacity
            T[] newArr = (T[]) new Object[capacity];
            //copy all items from previous array to new array
            for(int i = 0; i <len; i++) newArr[i] = arr[i];
            // set arr equal to the new array
            arr = newArr;

        }
        // add new element to the array 
        arr[len++]= elem;
    }
    
    public T removeAt(int rmIndex){
        if(rmIndex >= len|| rmIndex < 0) throw new IndexOutOfBoundsException();
        T data = arr[rmIndex];
        // instantiante new iterable size len - 1
        T[] newArr = (T[]) new Object[len- 1];
        // scan array for item to remove
        for(int i = 0, j = 0; i < len; i++, j++){
            // if i = index of item to remove lag j
            if(i == rmIndex) j--;
            // assign item of old array from position i in new array to position j,
            else newArr[j] =arr[i];
        }
        // set newly created array to the arr attribtue
        arr = newArr;
        // set capacity as len - 1
        capacity= --len;
        // return item
        return data;

    }

    public boolean remove(Object obj){
        int index = indexOf(obj);
        if(index==-1) return false; 
        removeAt(index);
        return true;
    }

    public int indexOf(Object obj){

        for(int i = 0;i < len; i++){
            if(obj==null){
                if(arr[i]==null) return i;
            } else{
                if(obj.equals(arr[i])) return i; 
            }
        }
        return -1; 
    }
    
    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator(){
        return new java.util.Iterator<T>(){
            int index=0;

            @Override
            public boolean hasNext(){
                return index<len;

            }
            @Override
            public T next(){
                return arr[index++];
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }

        };
    }

    @Override
    public String toString(){
        // if array is empty return empty brackets
        if(len==0) return "[]";
        else{
            // instantiate a stringbuilder object with capacity of Len, and append first character of Bracket
            StringBuilder sb  = new StringBuilder(len).append("[");
            // loop through array and append a item to stringbuilder object
            for(int i = 0; i < len-1; i++) sb.append(arr[i]+", ");
            // return final string + closing bracket as a string
            return sb.append(arr[len-1]+"]").toString(); 
        }
    }

}