/*https://www.happycoders.eu/algorithms/avl-tree-java/*/
public class implementation {

    //finding the height
    private int height(Node root) {
        return root != null ? root.height : -1;
    }

    //update the height the height
    private void updateHeight(Node root) {
        int leftChildHeight = height(root.left);
        int rightChildHeight = height(root.right);
        root.height = Math.max(leftChildHeight, rightChildHeight) + 1;
    }

    // Checking balanced for every node
    private int balancedFactor(Node root) {
        return height(root.right) - height(root.left);
    }

    //Right Rotations understand the img
    /*https://www.happycoders.eu/wp-content/uploads/2021/08/avl-tree-right-rotation-944x269.png*/
    private Node rightRotate(Node root) {
        Node leftChild = root.left;
        root.left = leftChild.right;
        leftChild.right = root;
        updateHeight(root);
        updateHeight(leftChild);
        return leftChild;
    }

    // Left Rotate understand the img
    /*https://www.happycoders.eu/wp-content/uploads/2021/08/avl-tree-left-rotation-v2-944x269.png*/
    private Node leftRotate(Node root) {
        Node rightChild = root.right;
        root.right = rightChild.left;
        rightChild.left = root;
        updateHeight(root);
        updateHeight(rightChild);
        return rightChild;
    }

    // Next Two Case in this

    private Node rebalance(Node root) {
        /*
        *  private int balancedFactor(Node root) {
        return height(root.right) - height(root.left);
        *
        * see form this is balancefactor is negative then
        * left height is greater
    }
    * */

        int balancedFactor = balancedFactor(root);

        //left heavy  // see up balance factor
        if (balancedFactor < -1) {
            if (balancedFactor(root.left) <= 0) {
                //right Rotate if left height is zero
                root = rightRotate(root);
            } else {
                //Rotate left - right
                root.left = leftRotate(root);
                root = rightRotate(root);
            }

        }

        // Right heavy // see the up factor it means right
        // right height is more
        if (balancedFactor > 1) {
            if (balancedFactor(root.right) >= 0) {
                //rotate left
                root = leftRotate(root);
            } else {
                //rotate right - left
                root.right = rightRotate(root);
                root = leftRotate(root);
            }
        }
        return root;
    }

    public Node insert(Node root, int data) {
        if (root == null) return new Node(data);

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            return root; // Duplicate keys are not allowed
        }

        updateHeight(root);
        return rebalance(root);
    }

    public Node delete(Node root, int data) {
        if (root == null) return root;

        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null || root.right == null) {
                root = (root.left != null) ? root.left : root.right;
            } else {
                Node temp = minValueNode(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }

        if (root == null) return root;
        updateHeight(root);
        return rebalance(root);
    }

    private Node minValueNode(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

}
