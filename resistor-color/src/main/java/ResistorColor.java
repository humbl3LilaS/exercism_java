import java.util.HashMap;
import java.util.Map;

class ResistorColor
{
    private final Map<String, Integer> colors = new HashMap<>();
    private static final String[] colorsArr = {
            "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"
    };

    public ResistorColor()
    {
        for (int i = 0; i < colorsArr.length; i++)
        {
            colors.put(colorsArr[i], i);
        }
    }

    int colorCode(String color)
    {
      return colors.get(color);
    }

    String[] colors()
    {
       return colorsArr;
    }
}
