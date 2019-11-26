import java.util.*;
public class matchString {
    /*基本性质

    1，根节点不包含字符，除根节点意外每个节点只包含一个字符。

    2，从根节点到某一个节点，路径上经过的字符连接起来，为该节点对应的字符串。

    3，每个节点的所有子节点包含的字符串不相同。



    优点：

    可以最大限度地减少无谓的字符串比较，故可以用于词频统计和大量字符串排序。

　　跟哈希表比较：

　　　　1，最坏情况时间复杂度比hash表好

　　　　2，没有冲突，除非一个key对应多个值（除key外的其他信息）

　　　　3，自带排序功能（类似Radix Sort），中序遍历trie可以得到排序。*/
    static class Node {
        private static final int D_size=26;

        char c;
        Node[] children=new Node[D_size];

        Node(char c){
            this.c=c;
        }
    }


    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] hasSub=new boolean[n];
//        for (int i = 0; i < p.length; i++) {
//            hasSub[i]=s.contains(p[i]);
//        }
        if(p.length<1)
            return hasSub;
        Node root=new Node('0');
        build(root, s);
        for(int i=0;i<p.length;++i){
            hasSub[i]= findSub(root, p[i]);
        }
        return hasSub;
    }

    private boolean findSub(Node root, String s) {
        for(int i=0;i<s.length();++i){
            Node node=root.children[s.charAt(i)-'a'];
            if(node==null||node.c!=s.charAt(i))
                return false;
            root=root.children[s.charAt(i)-'a'];
        }
        return true;
    }

    private void build(Node root, String s) {
        for(int i=0;i<s.length();++i){
            insert(root, s, i);
        }
    }

    private void insert(Node root, String str, int i){
        if(i>=str.length())
            return;
        int index=str.charAt(i)-'a';
        if(root.children[index]==null){
            root.children[index]=new Node(str.charAt(i));
            if(i==str.length()-1)
                return;
        }
        insert(root.children[index], str, i+1);
    }
}
