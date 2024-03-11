import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<String> ops;

    public Double rpnCalc(String operation) {
        ops = new ArrayList<>(List.of(operation.split(" +")));
        while (ops.size() > 1) {
            int i = nextOperand();
            if (i == -1) return null;
            double a = Double.parseDouble(ops.get(i-2)), b = Double.parseDouble(ops.get(i-1));
            String result = String.valueOf(calculate(ops.get(i), a, b));
            ops.set(i, result);
            ops.remove(i-1);
            ops.remove(i-2);
        }
        return Double.parseDouble(ops.get(0));
    }

    private int nextOperand() {
        try {
            List<Integer> locs = List.of(ops.indexOf("+"), ops.indexOf("-"), ops.indexOf("*"), ops.indexOf("/"));
            int minI = locs.stream().filter(x -> x != -1).min(Integer::compare).get();
            if (minI < 2) return -1;
            return minI;
        } catch (Exception e) {
            return -1;
        }
    }

    private double calculate(String operand, double a, double b) {
        switch (operand) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return a;
        }
    }

}
