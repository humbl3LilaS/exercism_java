import java.util.NavigableMap;
import java.util.Optional;
import java.util.TreeMap;

public class Say
{
    private static final long MAX = 999_999_999_999L;
    private static final NavigableMap<Long, String> dictionary = new TreeMap<>();
    private static final String EMPTY = "";
    private static final String SPACE = " ";
    private static final String HYPHEN = "-";

    static
    {

        dictionary.put(0L, "zero");
        dictionary.put(1L, "one");
        dictionary.put(2L, "two");
        dictionary.put(3L, "three");
        dictionary.put(4L, "four");
        dictionary.put(5L, "five");
        dictionary.put(6L, "six");
        dictionary.put(7L, "seven");
        dictionary.put(8L, "eight");
        dictionary.put(9L, "nine");
        dictionary.put(10L, "ten");
        dictionary.put(11L, "eleven");
        dictionary.put(12L, "twelve");
        dictionary.put(13L, "thirteen");
        dictionary.put(14L, "fourteen");
        dictionary.put(15L, "fifteen");
        dictionary.put(16L, "sixteen");
        dictionary.put(17L, "seventeen");
        dictionary.put(18L, "eighteen");
        dictionary.put(19L, "nineteen");
        dictionary.put(20L, "twenty");
        dictionary.put(30L, "thirty");
        dictionary.put(40L, "forty");
        dictionary.put(50L, "fifty");
        dictionary.put(60L, "sixty");
        dictionary.put(70L, "seventy");
        dictionary.put(80L, "eighty");
        dictionary.put(90L, "ninety");
        dictionary.put(100L, "hundred");
        dictionary.put(1_000L, "thousand");
        dictionary.put(1_000_000L, "million");
        dictionary.put(1_000_000_000L, "billion");
    }

    public String say(final long number)
    {
        if (number < 0 || number > MAX)
        {
            throw new IllegalArgumentException();
        }
        if (number < 100)
        {
            return Optional.ofNullable(dictionary.get(number))
                           .orElseGet(() -> dictionary
                                                    .floorEntry(number)
                                                    .getValue() + HYPHEN + this.say(number % 10)
                                     );
        }
        return this.say(number / dictionary.floorKey(number)) +
               SPACE +
               Optional.ofNullable(dictionary.get(number))
                       .orElseGet(
                               () -> dictionary.floorEntry(number)
                                               .getValue() +
                                     ((number % dictionary.floorKey(number) > 0)
                                             ? SPACE + this.say(
                                             number % dictionary.floorKey(number))
                                             : EMPTY));
    }

}