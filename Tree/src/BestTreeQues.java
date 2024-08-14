public class BestTreeQues   {



    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {

        return maxSumNodeHelper(root).node;
    }

    public static maxSumNodePairClass<Integer> maxSumNodeHelper(TreeNode<Integer> root) {
        if (root == null) {
            maxSumNodePairClass<Integer> output =new maxSumNodePairClass<>();
            output.node=root;
            output.sum=Integer.MIN_VALUE;
            return output;
        }
        if (root.children.isEmpty()) {
            maxSumNodePairClass<Integer> output1 =new maxSumNodePairClass<>();
            output1.node=root;
            output1.sum= root.data;
            return output1;
        }
        int sum=0;
        for (int i = 0; i <root.children.size() ; i++) {
            sum=sum+ root.children.get(i).data;
        }
        maxSumNodePairClass<Integer> ans=new maxSumNodePairClass<>();
        ans.node=root;
        ans.sum=sum;
       /* for (TreeNode<Integer> child: root.children
             ) {
            maxSumNodePairClass<Integer> childAns=new maxSumNodePairClass<>(child);
            if (childAns.sum > ans.sum) {
                ans=childAns;
            }
        }*/

        for (int i = 0; i <root.children.size() ; i++) {
            maxSumNodePairClass<Integer> childAns=new maxSumNodePairClass<>(root.children.get(i));
            if
            (childAns.sum > ans.sum) {
                ans = childAns;
            }
        }


return ans;

    }

    public static void main(String[] args) {

    }
}

class maxSumNodePairClass<T> {
    TreeNode<Integer> node;
    int sum;

    public maxSumNodePairClass() {
    }

    public maxSumNodePairClass(TreeNode<T> child) {
    }
}


/*public class Solution {

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        TreeNode<Integer> maxNode = null;
        int[] maxSum = {Integer.MIN_VALUE}; // Using an array to hold the maximum sum value

        dfs(root, maxSum, maxNode);

        return maxNode;
    }

    private static int dfs(TreeNode<Integer> node, int[] maxSum, TreeNode<Integer> maxNode) {
        if (node == null) {
            return 0;
        }

        int sum = node.data;
        for (TreeNode<Integer> child : node.children) {
            sum += dfs(child, maxSum, maxNode);
        }

        if (sum > maxSum[0]) {
            maxSum[0] = sum;
            maxNode = node;
        }

        return sum;
    }
}
*/