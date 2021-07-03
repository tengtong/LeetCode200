package dataStructure.arrayAndMatrix;

/**
 * 寻找数组中只出现一次的数
 * 方法一：用hashmap统计
 * 方法二：
 */
public class FindNumsAppearOnce {
    public void solution(int [] array,int num1[] , int num2[]) {
        int result=0;
        for(int i=0;i<array.length;i++){
            result^=array[i];//对数组中的所有元素逐个进行异或操作，用num记录最后的结果值
        }
        int count=0;//标志位，找出result二进制中从右往左的第一个1出现的位置，count是标识位，故在二进制中每个count都要左移后再与result对比
        for(;count<array.length;count++){//循环体中每次变化的只有count++
            if((result&(1<<count))!=0){//十进制进行位运算，虽然是在二进制上进行运算，但是结果还以十进制进行展示，所以这里是 !=0 ，而不是 =1
                break;
            }
        }
        num1[0]=0;
        num2[0]=0;
        for(int i=0;i<array.length;i++){//循环体中每次变换的只有i++
            if((array[i]&(1<<count))==0){//标志位为0的为一组，异或后必得到一个数字（这里注意==的优先级高于&，需在前面加（））；这里1<<count，表示数字1左移count位，即只进行一次运算
                num1[0]^=array[i];//&结果为0表示该元素的该位为0，1&0=0，然后把这个元素都 异或 一下，相同都消失了，只剩下一个标识为0且出现一次的数
            }else{
                num2[0]^=array[i];//标志位为1的为一组，同理，所有结果异或完，只剩下一个标识为1且出现一次的数
            }
        }
    }
}
