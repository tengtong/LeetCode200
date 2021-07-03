package dataStructure.tree.trie;

/**
 * 实现一个Trie，用来求前缀和
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 */
public class MapSum {

    private class Node{
        Node[] child = new Node[26];
        int value;
    }

    private Node root = new Node();

    public void insert(String key, int val){
        insert(key,root,val);
    }

    private void insert(String key, Node node, int val){
        if (node == null) return;
        if (key.length() == 0) {
            node.value = val;
            return;
        }
        int index = indexForChar(key.charAt(0));
        if (node.child[index] == null){
            node.child[index] = new Node();
        }
        insert(key.substring(1), node.child[index], val);
    }

    public int sum(String prefix) {
        return sum(prefix, root);
    }

    private int sum(String prefix, Node node){
        if (node == null) return 0;
        if (prefix.length() != 0) {
            int index = indexForChar(prefix.charAt(0));
            return sum(prefix.substring(1),node.child[index]);
        }
        int sum = node.value;
        for (Node child: node.child){
            sum += sum(prefix,child);
        }
        return sum;
    }

    private int indexForChar(char c){
        return c - 'a';
    }
}
