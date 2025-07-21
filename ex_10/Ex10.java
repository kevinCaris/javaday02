package ex_10;

import java.util.*;

public class Ex10 {

    public static String simplifyPolynomialExpression(String expression) {
        String[] parts = expression.split("\\)\\(");
        String left = parts[0].substring(1); 
        String right = parts[1].substring(0, parts[1].length() - 1); 
        Map<Integer, Integer> resultMap = new HashMap<>();

        List<int[]> leftTerms = parseTerms(left);
        List<int[]> rightTerms = parseTerms(right);

        for (int[] leftTerm : leftTerms) {
            for (int[] rightTerm : rightTerms) {
                int coeff = leftTerm[0] * rightTerm[0];
                int degree = leftTerm[1] + rightTerm[1];
                resultMap.put(degree, resultMap.getOrDefault(degree, 0) + coeff);
            }
        }

        List<Integer> degrees = new ArrayList<>(resultMap.keySet());
        degrees.sort(Collections.reverseOrder());

        StringBuilder result = new StringBuilder();
        for (int deg : degrees) {
            int coeff = resultMap.get(deg);
            if (result.length() > 0 && coeff > 0) {
                result.append("+");
            }
            if (deg == 0) {
                result.append(coeff);
            } else if (deg == 1) {
                result.append(coeff).append("x");
            } else {
                result.append(coeff).append("x^").append(deg);
            }
        }

        return result.toString();
    }

    private static List<int[]> parseTerms(String poly) {
        List<int[]> terms = new ArrayList<>();
        poly = poly.replace("-", "+-"); // simplifie la séparation
        String[] split = poly.split("\\+");
        for (String term : split) {
            if (term.isEmpty()) continue;

            int coeff = 1, degree = 0;
            if (term.contains("x")) {
                String[] parts = term.split("x\\^?");
                if (parts.length > 0 && !parts[0].isEmpty()) {
                    coeff = Integer.parseInt(parts[0]);
                } else if (term.startsWith("-x")) {
                    coeff = -1;
                } else if (term.startsWith("x")) {
                    coeff = 1;
                }
                if (term.contains("^")) {
                    degree = Integer.parseInt(parts[1]);
                } else {
                    degree = 1;
                }
            } else {
                coeff = Integer.parseInt(term);
                degree = 0;
            }
            terms.add(new int[]{coeff, degree});
        }
        return terms;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPolynomialExpression("(2x^2+4)(6x^3+3)"));
        // Output: 12x^5+24x^3+6x^2+12
    }
}
