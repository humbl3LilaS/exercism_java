import java.util.stream.IntStream;

class NaturalNumber
{
    private final Classification classification;

    NaturalNumber(int number)
    {
        if (number <= 0)
        {
            throw new IllegalArgumentException(
                    "You must supply a natural number (positive integer)");
        }


        var sum = getAliquotSum(number);

        if (sum < number)
        {
            this.classification = Classification.DEFICIENT;
        }
        else if (sum > number)
        {
            this.classification = Classification.ABUNDANT;
        }
        else
        {
            this.classification = Classification.PERFECT;
        }

    }

    private static int getAliquotSum(int number)
    {
        return IntStream.rangeClosed(1, number / 2)
                        .parallel()
                        .filter(x -> number % x == 0)
                        .sum();
    }

    Classification getClassification()
    {
        return classification;
    }

}
