package datastructures.trees;

public class IsValidBST {
    // public boolean isValidBST(Node root) {
    //     return isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    // }
    // boolean isBstUtil(Node node, int min, int max) {
    //     if(node==null){
    //         return true;
    //     }
    //     if(node.data<=min || node.data>=max){
    //     }
    //     return isBstUtil(node.left,min,node.data) && isBstUtil(node.left,node.data, max);
    // }
    Node prev=null;
    public boolean isValidBST(Node root) {
        if(root==null){
            return true;
        }
        if(root.left!=null){
            if(!isValidBST(root.left)){
                return false;
            }
        }
        if(prev!=null && prev.data>=root.data){
            return false;
        }
        prev=root;
        return isValidBST(root.right);
    }
}
