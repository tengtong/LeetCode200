package others;

import java.util.HashMap;
import java.util.*;

public class Test{
    public static void main(String[] args) {
        int a=2,b=3,c=4;
        System.out.println((a>b)||(b>c));
        System.out.println((a>b)&&(b>c));
        System.out.println(!(a>b)&&!(b>c));
        System.out.println(!(a>b)&&(b>c));
    }
}
