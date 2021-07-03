package algorithm.math.other;

/**
 * 构建乘积数组
 * 这里用特殊方法，先计算B[]集群的左下角，再计算B[]集群的右上角，然后两者合并
 * 也是因为分左小角和右上角的话，邻层之间有关系，可以相互表示，故选择用这种方法来计算B[]集群
 * A = A[0,1,2,...,n-1]
 * B = B[0,1,2,...,n-1]
 * B[0]   =      * A[1] * A[2] * A[3] * ... * A[n-2] * A[n-1]
 * B[1]   = A[0]        * A[2] * A[3] * ... * A[n-2] * A[n-1]
 * B[2]   = A[0] * A[1]        * A[3] * ... * A[n-2] * A[n-1]
 * ...
 * B[n-1] = A[0] * A[1] * A[2] * A[3] * ... * A[n-2]
 * 这里可以看成一个做小角和一个右上角，因为B[i+1]可以用B[i]来表示，故方便整个B[n]数组集群搭建
 */
public class Multiply{
    public int[] multiply(int[] A) {
        int length = A.length;
        if(length==0){
            return null;
        }
        int[] B = new int[length];//先构建一个和A[n]等大的数组B[n]，来存放B结果值

        //计算每个B[i]
        //先计算左下角，可以看出，B[0]=1,B[1]=A[0],B[2]=B[1]*A[1],B[3]=B[2]*A[2]
        B[0]=1;
        for(int i = 1; i<length; i++){
            B[i] = B[i-1] * A[i-1];
        }
        //再计算右上角，右上角从B[n-1]开始方便累乘，这里因为B[i]已经有值，所以用temp来统计右上角的累成值
        //B[n-1]=B[n-1]*1
        //B[n-2]=B[n-2]*temp[n-2],temp[n-2]=temp[n-1]*A[n-1]
        //相当于B[j] = B[j]*temp[j],temp[j]=temp[j+1]*A[j+1]
        //...
        // B[0]=B[1]*A[1]
        int temp[] = new int[length];
        temp[length-1] = 1;
        for(int j=length-2;j>=0;j--){//因为最后一位是B[n-1]，所以j=lenght-2
            temp[j] = temp[j+1] * A[j+1];
            B[j] = B[j] * temp[j];
        }
        return B;
    }
}