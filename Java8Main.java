
public class Java8Main {
    public static Integer performOp(BinaryOperation<Integer> op, Integer a, Integer b) {
        return op.doOp(a,b);
    }

    public static void main(String[] args) {
        System.out.println(performOp(new AdditionOperation(), 1, 2));

        //is now...
        System.out.println(performOp((x,y) -> x*y, 2, 3));
    }
}

