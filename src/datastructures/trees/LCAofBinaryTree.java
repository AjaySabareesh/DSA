package datastructures.trees;
////Lowest Common Ancestor
//Time Complexity: O(N) as the method does a simple tree traversal in a bottom-up fashion.
//Auxiliary Space: O(H), where H is the height of the tree. Height of nodes in recursive stack
public class LCAofBinaryTree {
    //Function to return the lowest common ancestor in a Binary Tree.
    boolean n1Present = false, n2Present = false;
    Node lca(Node root, int n1,int n2)
    {
        Node res = lcaUtil(root, n1, n2);
        if(n1Present & n2Present){
            return res;
        }
        return null;
    }
    Node lcaUtil(Node root, int n1,int n2)
    {
        if(root==null){
            return null;
        }
        Node ans = null;
        if(root.data ==n1){
            n1Present = true;
            ans = root;
        }else if(root.data == n2){
            n2Present= true;
            ans=root;
        }
        Node left = lcaUtil(root.left, n1, n2);
        Node right = lcaUtil(root.right, n1, n2);

        if(ans!=null){
            return ans;
        }else if(left!=null && right!=null){
            return root;
        }
        return left!=null ? left:right;
    }
}
