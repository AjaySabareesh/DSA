package datastructures.trees;

public class BuildBSTFromPreOrder {
    public Node bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        return solve(preorder, 0, n-1);
    }

    Node solve(int[] arr, int st, int end){
        if(st<0 || end <0 ){
            return null;
        }
        Node root = new Node(arr[st]);
        int left=-1, right=-1;
        for(int i=st+1;i<=end;i++){
            if(left==-1 && arr[i]<root.data){
                left = i;
            }
            if(right==-1 && arr[i]>root.data){
                right=i;
                break;
            }
        }
        root.left=solve(arr, left, right==-1 ? end:right-1);
        root.right= solve(arr, right, end);
        return root;
    }

//Using Stack
    // public TreeNode bstFromPreorder(int[] preorder) {
    //     if (preorder == null || preorder.length == 0) {
    //         return null;
    //     }
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode root = new TreeNode(preorder[0]);
    //     stack.push(root);
    //     for (int i = 1; i < preorder.length; i++) {
    //         TreeNode node = new TreeNode(preorder[i]);
    //         if (preorder[i] < stack.peek().val) {
    //             stack.peek().left = node;
    //         } else {
    //             TreeNode parent = stack.peek();
    //             while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
    //                 parent = stack.pop();
    //             }
    //             parent.right = node;
    //         }
    //         stack.push(node);
    //     }
    //     return root;
    // }
}
