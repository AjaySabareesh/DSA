package datastructures.trees;

public class RootToLeafPathSum {
//Approach - 1: have prob in few cases like 2 digit node values
// 	public long treePathsSum(Node root){
// 	    String s = "";
// 	    long sum = pathSum(root,s);
// 	    return sum;
// 	}

// 	long pathSum(Node node, String s){
// 	    if(node==null){
// 	        return 0;
// 	    }
// 	    String s1 = s+node.data;
// 	    if(node.left==null && node.right==null){
// 	        return Long.parseLong(s1);
// 	    }
// 	    return pathSum(node.left, s1) + pathSum(node.right,s1);
// 	}

    //approach - 2
    public long treePathsSum(Node root){
        long sum = pathSum(root,0);
        return sum;
    }

    long pathSum(Node node, long val){
        if(node==null){
            return 0;
        }
        val = val*10+node.data;
        if(node.left==null && node.right==null){
            return val;
        }
        return pathSum(node.left,val)+pathSum(node.right,val);
    }
}
