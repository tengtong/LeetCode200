package algorithm.math.other;

import java.util.*;

/**
 * 寻找数据流中的中位数
 * Insert()方法读取数据流
 * GetMedian()方法获取数据流中的中位数
 */
public class MidNum {
    ArrayList<Integer> res = new ArrayList<>();
    public void Insert(Integer num) {
        res.add(num);
        Collections.sort(res);
    }
    public Double GetMedian() {
        int n = res.size();
        if (n % 2 == 0) {
            return Double.valueOf((res.get(n / 2) + res.get(n / 2 - 1)) / 2.0);
        } else {
            return Double.valueOf(res.get(n / 2));
        }
    }
}
