import java.util.*;
import java.util.stream.Collectors;

class HighScores
{
    private List<Integer> highScores;

    public HighScores(List<Integer> highScores)
    {
        this.highScores = highScores;
    }

    List<Integer> scores()
    {
        return highScores;
    }

    Integer latest()
    {
        return highScores.get(highScores.size() - 1);
    }

    Integer personalBest()
    {
        return Collections.max(highScores);
    }

    List<Integer> personalTopThree()
    {
        return highScores.stream()
                         .sorted(Comparator.reverseOrder())
                         .limit(3)
                         .collect(Collectors.toList());
    }

}
