import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getFromArr(int[] arr) {
        ListNode head = new ListNode(-1), tmp;
        tmp = head;
        for (int i = 0; i < arr.length; i++) {
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }
        return head.next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
    public static TreeNode deserialize(String data) {
        String[]nodes = data.split(",");
        if(nodes.length == 1)
            return null;
        nodes[0] = nodes[0].substring(1,nodes[0].length());
        nodes[nodes.length-1] = nodes[nodes.length-1].substring(0,nodes[nodes.length-1].length()-1);
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        TreeNode l,r,tmpr;
        int cursor = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while(cursor<nodes.length){
            //
            tmpr = queue.pollFirst();
            l = r = null;
            if(nodes[cursor].charAt(0) != 'x'){
                l = new TreeNode(Integer.parseInt(nodes[cursor]));
                queue.offerLast(l);
            }
            if(cursor+1<nodes.length && nodes[cursor+1].charAt(0) != 'x'){
                r = new TreeNode(Integer.parseInt(nodes[cursor+1]));
                queue.offerLast(r);
            }
            tmpr.left = l;
            tmpr.right = r;
            cursor+=2;
        }
        return root;
    }
}

public class LeetUtil {

}
