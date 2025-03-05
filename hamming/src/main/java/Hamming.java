import java.util.stream.IntStream;

public class Hamming
{
    private final String leftStrand;
    private final String rightStrand;
    private final int distance;

    public Hamming(String leftStrand, String rightStrand)
    {
        if (leftStrand.length() != rightStrand.length())
        {
            throw new IllegalArgumentException("strands must be of equal length");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        this.distance = IntStream.range(0, leftStrand.length())
                                 .map(x ->
                                      {
                                          if (leftStrand.charAt(x) == rightStrand.charAt(x))
                                              return 0;
                                          return 1;
                                      })
                                 .reduce(0, Integer::sum);
    }

    public int getHammingDistance()
    {
        return distance;
    }


}
