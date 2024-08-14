public class Main {

    public static void main(String[] args) throws StackFullException, StackEmptyException {

        StackClassArray stack = new StackClassArray(3);
//        for (int i = 1; i <= 10; i++) {
//            stack.push(i);
//        }
//      while (!stack.isEmpty()){
//          try {
//              System.out.print(stack.pop() + " ");
//          } catch (StackEmptyException e) {
//              throw new RuntimeException(e);
//          }
//      }
//
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        System.out.println(stack.top());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

}
