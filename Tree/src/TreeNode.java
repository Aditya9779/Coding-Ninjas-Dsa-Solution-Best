import java.util.ArrayList;

public class TreeNode<T> {
    T data; // R
    ArrayList<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data=data; // It means that R belongs to T data inside R=data(R see up)
        children=new ArrayList<>();
    }
}
