import java.util.Arrays;
import java.util.stream.Collectors;

class MicroBlog
{
    public String truncate(String input)
    {
        int[] codePoints = input.codePoints().toArray();
        return Arrays.stream(codePoints).mapToObj(Character::toString).limit(5).collect(
                Collectors.joining());
    }
}
