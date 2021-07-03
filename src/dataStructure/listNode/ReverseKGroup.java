package dataStructure.listNode;

import java.util.*;

/**
 * 对链表前k个节点进行翻转
 */
public class ReverseKGroup {
    public static void main(String[] args) {

        //输入数据到链表中
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();//输入k
        String str = sc.nextLine();//输入一行val
        String[] strs = str.split(" ");
        Node head = null;
        Node current = null;
        for(String s:strs){//初始化链表
            if(head == null){
                head = new Node(Integer.parseInt(s));
                current = head;
            }else{
                current.next = new Node(Integer.parseInt(s));//因为方法是static方法，所以可以使用"类+方法名"的方式调用
                current = current.next;
            }

        }

        Node temp = head;
        while(temp != null){
            System.out.print(temp.val);
            temp = temp.next;
        }

    }
}
class Node{
    int val;
    Node next;

    Node(int value){
        this.val = value;
    }
}
