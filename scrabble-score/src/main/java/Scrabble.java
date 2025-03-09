import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class Scrabble
{


    private static final Map<Character, Integer> dictionary = new HashMap<>();
    private final int score;

    static
    {
        "aeioulnrst".chars().forEach(ch -> dictionary.put((char) ch, 1));
        "dg".chars().forEach(ch -> dictionary.put((char) ch, 2));
        "bcmp".chars().forEach(ch -> dictionary.put((char) ch, 3));
        "fhvwy".chars().forEach(ch -> dictionary.put((char) ch, 4));
        "k".chars().forEach(ch -> dictionary.put((char) ch, 5));
        "jx".chars().forEach(ch -> dictionary.put((char) ch, 8));
        "qz".chars().forEach(ch -> dictionary.put((char) ch, 10));
    }


    Scrabble(String word)
    {
        this.score = processScore(word);
    }

    int getScore()
    {
        return score;
    }

    private static int processScore(String word)
    {
        return word.toLowerCase().chars().reduce(
                0, (acc, curr) ->
                        acc + Optional.ofNullable(dictionary.get((char) curr)).orElse(0));
    }

}
