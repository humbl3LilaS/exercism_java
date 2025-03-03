class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        return  (int) Math.pow(sum(input), 2);
    }

   private static int sum(int input) {
        return input > 1 ? input + sum(input - 1) : 1;
   }

    int computeSumOfSquaresTo(int input) {
        return input > 1 ? ((int) Math.pow(input, 2)) + computeSumOfSquaresTo(input - 1) : 1;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
