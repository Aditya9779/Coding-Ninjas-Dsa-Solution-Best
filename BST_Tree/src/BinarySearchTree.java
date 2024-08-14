public class BinarySearchTree {
    private BST<Integer> root;

    public void insert(int data) {
        root = helperinsert(data, root);
    }

    private BST<Integer> helperinsert(int data, BST<Integer> root) {
        if (root == null) {
            BST<Integer> newNode = new BST<>(data);
        }
        if (root.data > data) {

            root.left = helperinsert(data, root.left);
        } else if (root.data < data) {

            root.right = helperinsert(data, root.right);
        }
        return root;
    }


    public void delete(int data) {
        root = helperdelete(data, root);
    }

    private BST<Integer> helperdelete(int data, BST<Integer> root) {
        if (root == null) {
            return root;
        }

        if (root.data > data) {
            root.left = helperdelete(data, root.left);
        } else if (root.data < data) {
            root.right = helperdelete(data, root.right);
        } else {
            // Node to be deleted found

            // Case 1: Node to be deleted has no children
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node to be deleted has one child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Node to be deleted has two children
            int leftMax = findLeftMax(root.left);
            root.data = leftMax;
            root.left = helperdelete(leftMax, root.left);
        }

        return root;
    }

/*    private int findLeftMax(BST<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        // Traverse to the rightmost node in the left subtree to find the maximum
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }*/
//or
    private int findLeftMax(BST<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.right == null) {
            return root.data;
        }
        return findLeftMax(root.right);
    }


    public boolean hasData(int data) {
        return helperhasData(data, root);
    }

    private boolean helperhasData(int data, BST<Integer> root) {
        if (root == null) {
            return false;
        }
        if (data == root.data) {
            return true;
        } else if (data < root.data) {
            return helperhasData(data, root.left);
        } else if (data > root.data) {
            return helperhasData(data, root.right);
        }
        return false;
    }


}
