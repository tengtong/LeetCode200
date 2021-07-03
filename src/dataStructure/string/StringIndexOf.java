package dataStructure.string;

/**
 * 查询字符或者字符串第一次出现的索引位置
 * s.indexOf(int ch)//查询s中字符的索引位置，可以 char类型的''或者int类型的ASCII码形式
 * s.indexOf(int ch, int fromIndex)//查询s中字符的索引位置，从索引fromIndex开始（包括索引fromIndex）
 * s.indexOf(String str)//查询s中字符串的索引位置
 * s.indexOf(String str, int fromIndex)//查询s中字符串的索引位置，从索引fromIndex开始（包括索引fromIndex）
 * fromIndex，即字符数组的index，这里所有的索引统一
 */
public class StringIndexOf {
    public static void main(String args[]) {
        String string = "aaa456ac";
        System.out.println(string.indexOf("a",3));//从第4个字符开始查询"a"
        System.out.println(string.indexOf(99));//查询字符c，c-99
        System.out.println(string.indexOf('c'));//查询字符c
        System.out.println(string.indexOf(97,3));//从第4个字符开始查询'a'
        System.out.println(string.indexOf('a',3));//从第4个字符开始查询'a'

        String str = new String("菜鸟教程:www.runoob.com");
        String substr1 = new String("runoob");
        String substr2 = new String("com");
        System.out.println(str.indexOf('o'));//查找字符 o 第一次出现的位置
        System.out.println(str.indexOf('o', 14));//从第14个位置查找字符 o 第一次出现的位置
        System.out.println(str.indexOf(substr1));//子字符串 substr1 第一次出现的位置
        System.out.println(str.indexOf(substr1, 15));//从第十五个位置开始搜索子字符串 substr1 第一次出现的位置
        System.out.println(str.indexOf(substr2));//子字符串 substr2 第一次出现的位置
    }
}