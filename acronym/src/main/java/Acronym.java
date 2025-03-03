import java.util.Arrays;
import java.util.stream.Collectors;

class Acronym
{
    private String phrase;

    Acronym(String phrase)
    {
        this.phrase = phrase;
    }

    String get()
    {
        var words = phrase.split("[\\s-_]+");
        return Arrays.stream(words)
                     .map(item -> item.substring(0, 1).toUpperCase())
                     .collect(Collectors.joining());
    }

}
