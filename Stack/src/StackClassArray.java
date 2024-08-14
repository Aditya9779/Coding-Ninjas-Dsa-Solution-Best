public class StackClassArray {
    private int[] data;
    private int top; //index of top most element Or Its is the index from where we put the data

    public StackClassArray() {
        data = new int[10];
        //If the user does not give the size
        top = -1;
    }

    public StackClassArray(int capacity) {
        data = new int[capacity];  //if user gives the size
        top = -1;
    }

    public boolean isEmpty() {
//    if (top == -1) {
//      return true;
//    }
//    return false;
        return (top == -1);
    }

    public int size() {
        return top + 1;   //Wht we use because we have taken the
        // top as -1 individual spo that's why we add the 1

    }

    public int top() throws StackEmptyException {
        if (size() == 0) {
            //Stack Over Flow
            throw new StackEmptyException();
        }
        return data[top];
    }
    public void push(int element)
    //throws StackFullException {
    {
        if (size() == data.length) {
            // Stack Full Exception
// throw new StackFullException();
            restructure();
        }
        top++;
        data[top] = element;
    }

    public int pop() throws StackEmptyException {
        if (size() == 0) {
            throw new StackEmptyException();
        }
        int ans = data[top];
        top--;
        return ans;
    }

    private void restructure() {
        int[] temp = data;
        data = new int[temp.length + 1];
//System.arraycopy(temp,0,restructureArray,0,temp.length);
        System.arraycopy(temp, 0, data, 0, temp.length);
    }

}


class StackEmptyException extends Exception {
    private static final long serialVersion = 1L;

}

class StackFullException extends Exception {

}