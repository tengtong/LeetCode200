package dataStructure.listNode.huawei;

/**
 * 给定一个排序链表，针对每个元素，增加节点或者删除节点，使得每个元素出现3次
 */
import java.util.*;
public class Solution {
    public static void main(String[] agrs){
        //1、从输入中读取数据存入链表中
        Scanner sc = new Scanner(System.in);//把输入的所有内容存入Scanner类的sc中
        String s = sc.nextLine();//再通过空格或分隔符为间隔获取所有的字符串//next是以空格或者分隔符区分；而nextLine是以换回车区分，一次取一行
        String[] res = s.split("");
        Node nextNode = new Node();
        Node head = nextNode;//复制头节点
        for(String re:res){//遍历现有list或者数组时，用forEach比较方便
            nextNode.next = new Node(Integer.parseInt(re));//对当前节点的val进行赋值
            nextNode = nextNode.next;
        }
        //2、开始处理链表
        nextNode = head.next;
        //一次循环就是处理一组相同元素的过程
        //处理的策略就是找出所有相同元素的node，然后通过长度进行删、减操作
        while(nextNode != null) {//一个循环就是一次相同元素的处理//遍历链表，while()是循环执行的条件
            int count = 0;
            Node firstNode = nextNode;//一组相同元素的第一个
            Node lastNode = null;//一组相同元素的最后一个

            //寻找lastNode，遍历寻找完一组所有相同的元素
            while(nextNode.next != null){//遍历链表问题，循环的话，还是容易.next.value为null//所以遍历链表条件都是node!=null
                if(nextNode.value == nextNode.next.value){
                    count++;
                    nextNode = nextNode.next;
                }else{
                    break;
                }
            }
            count++;
            //结束while循环，表示下一个元素为不相同元素//同样，如果nextNode.next==null，当前节点也是lastNode
            lastNode = nextNode;//找到了lastNode

            //开始根据count进行增删操作
            //先记录last.next，避免丢失
            Node temp = lastNode.next;
            //根据count进行增删操作
            if(count<3){//条件语句和循环语句不同，条件语句只执行一次
                //增操作//这里循环进行的是添加操作，所以循环次数是需要添加的次数
                for(int i=count;i<3;i++){//即i<=3都执行操作
                    lastNode.next = new Node(lastNode.value);//把元素加在lastNode后面
                    lastNode = lastNode.next;//lastNode就是最后一个相同元素的node
                }
                lastNode.next = temp;
            }else if (count > 3){
                //删除操作
                firstNode.next.next.next = temp;
            }else {
                //count=3时，不操作
            }
            //调整指针，准备下一个元素
            nextNode = lastNode.next;
        }
        //遍历输出结果
        nextNode = head.next;
        while(nextNode != null){
            System.out.print(nextNode.value);
            nextNode = nextNode.next;
        }
    }
}
class Node{
    public int value;
    public Node next;

    public Node(){
    }

    public Node(int val){
        this.value = val;
    }
}

