import java.util.HashMap;
import java.util.Map;

class ResistorColorDuo
{
    private final Map<String, Integer> colors = new HashMap<>();
    private static final String[] colorsArr = {
            "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"
    };

    public ResistorColorDuo()
    {
        for (int i = 0; i < colorsArr.length; i++)
        {
            colors.put(colorsArr[i], i);
        }
    }

    int value(String[] cArr)
    {
        return colors.get(cArr[0]) * 10 + colors.get(cArr[1]);
    }
}
