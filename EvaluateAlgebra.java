
import java.util.ArrayList;
import java.util.List;

public class EvaluateAlgebra {

    private int firstNumber;
    private int secondNumber;
    private boolean negativeX;
    List<String> inputs;

    public EvaluateAlgebra(String input) {
        inputs = new ArrayList<>();
        inputs.add(input);
    }

    public EvaluateAlgebra(List<String> inputs) {
        this.inputs = inputs;

    }

    public List<Integer> calcEquations() {
        List<Integer> solutions = new ArrayList<>();

        for (String s : inputs) {
            String equation = s.replace(" ", "");
            int indexOfEqual = equation.indexOf("=");
            int indexOfX = equation.indexOf("x");
            String leftSide = equation.substring(0, indexOfEqual);
            String rightSide = equation.substring(indexOfEqual + 1);
            boolean xIsLeft = indexOfX < indexOfEqual;

            if (xIsLeft) {
                secondNumber = Integer.parseInt(rightSide);
                switch (indexOfX) {
                    case 0 -> {
                        firstNumber = Integer.parseInt(leftSide.substring(1));
                        negativeX = false;
                    }
                    case 1 -> {
                        negativeX = leftSide.charAt(0) == '-';
                        firstNumber = Integer.parseInt(leftSide.substring(2));
                    }
                    default -> {
                        negativeX = leftSide.charAt(indexOfX - 1) == '-';
                        firstNumber = Integer.parseInt(leftSide.substring(0, indexOfX - 1));
                    }
                }

            } else {
                secondNumber = Integer.parseInt(leftSide);
                indexOfX = rightSide.indexOf("x");
                switch (indexOfX) {
                    case 0 -> {
                        firstNumber = Integer.parseInt(rightSide.substring(1));
                        negativeX = false;
                    }
                    case 1 -> {
                        negativeX = rightSide.charAt(0) == '-';
                        firstNumber = Integer.parseInt(rightSide.substring(2));
                    }
                    default -> {
                        negativeX = rightSide.charAt(indexOfX - 1) == '-';
                        firstNumber = Integer.parseInt(rightSide.substring(0, indexOfX - 1));
                    }
                }
            }
            solutions.add(calcX());
        }
        return solutions;
    }


    private int calcX() {
        int solution = (firstNumber * -1) + secondNumber;

        if (negativeX)
            solution *= -1;

        return solution;
    }

}

