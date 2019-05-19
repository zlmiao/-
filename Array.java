import java.util.Arrays;

public class Array {

    private int[] data;    //类的成员变量私有的，不希望从外不直接获得信息，只能用get方法。 封装性
    private int size;    //数组中实际几个元素

    //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){    //capacity容量
        data = new int[capacity];
        size = 0;
    }

    //无参的构造函数，默认数组的容量capacity=10
   public Array(){
        this(10);
   }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //向所有元素后添加一个新元素
    public void addLast(int e) {

//        if (size==data.length)
//            throw new IllegalArgumentException("AddLast failed. Array is full");
//        data[size] = e;
//        size++;
        add(size,e);
    }

    //在所有元素前添加一个新元素
    public void addFirst(int e){
        add(0,e);
    }

    //在第index个位置插入一个新元素e
    public void add(int index, int e) {

        if (size == data.length)
            throw new IllegalArgumentException("Add failed. Array is full");

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        for (int i = size - 1; i >= index; i--)           //腾出位置来，所有元素往后挪一个位置！
            data[i + 1] = data[i];

        data[index] = e;

        size++;
    }

    @Override
    public String toString() {
       StringBuilder res = new StringBuilder();
       res.append(String.format("Array:size = %d , capacity = %d\n", size,data.length));   //size有多少个元素，%d占位符
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i!=size -1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }
}
