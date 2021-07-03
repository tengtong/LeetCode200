package dataStructure.tree.trie;

/**
 * Trie，前缀树/字典树，用于判断字符串是否存在 或者是否具有某种字符串前缀
 */

/**
 * 实现一个Trie
 * 这里的原生方法，行参都是不带node节点，因为Node类是我们自己创建的，为了方便操作
 */
class Trie {

    /**
     * 创建内部类 Node 帮助我们操作trie
     */
    private class Node{
        //26个字母，26个Node
        Node[] childs = new Node[26];
        boolean isLeaf;
    }

    //默认有一个无参的构造函数
    private Node root = new Node();

    /**
     * Initialize your data structure here.
     * 初始化
     * */
    public Trie() {
    }

    /**
     * Inserts a word into the trie.
     * 将一个word插入到trie中，具体还是一个字符一个字符插入到字典树中
     * @param word
     */
    public void insert(String word) {
        insert(word,root);
    }

    /**
     * 方法：insert重载构造函数，往trie中插入word
     */
    private void insert(String word,Node node){
        //截止条件
        if (node == null) return;
        if (word.length() == 0){
            node.isLeaf = true;
            return;
        }
        int index = indexForChar(word.charAt(0));
        if (node.childs[index] == null){
            node.childs[index] = new Node();
        }
        insert(word.substring(1),node.childs[index]);
    }

    /**
     * Returns if the word is in the trie.
     * 判断树中是否存在word单词
     * @param word
     * @return
     */
    public boolean search(String word) {
        return search(word,root);
    }

    /**
     * search的重载函数
     * @param word
     * @param node
     * @return
     */
    private boolean search(String word,Node node){
        //截止条件
        if (node == null) return false;
        if (word.length() == 0) return node.isLeaf;
        //indexForChar，找到该单词首字母对应的index，例如a的index为0
        int index = indexForChar(word.charAt(0));
        //example: "unhappy".substring(2) returns "happy"
        //每层节点只保存一个字符，故一个一个字符判断和处理
        return search(word.substring(1),node.childs[index]);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * 输入首字母判断是否存在以该首字符出现的word，即只要判断trie中是否存在节点值为prefix的节点
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        return search(prefix,root);
    }

    /**
     * sartsWith的重载函数
     * @param prefix //前缀不一定是只有一个字符，故这里用的是String
     * @param node
     * @return
     */
    private boolean startsWith(String prefix, Node node){
        if (node == null) return false;
        if (prefix.length() == 0) return true;
        int index = indexForChar(prefix.charAt(0));
        return startsWith(prefix.substring(1), node.childs[index]);
    }

    /**
     * 计算的字符的index，a的index为0
     * @param c
     * @return
     */
    private int indexForChar(char c){
        return c - 'a';
    }
}
