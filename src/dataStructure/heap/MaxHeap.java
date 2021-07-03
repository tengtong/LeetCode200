package dataStructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//小顶堆->大顶推
public class MaxHeap{
    //对象：堆(11, new comparator(){@Override compare(o1,o2)})；
    PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>(11, new Comparator<Integer>(){
        @Override
        public int compare(Integer o1,Integer o2){
            return o2.compareTo(o1);
        }
    });
}
