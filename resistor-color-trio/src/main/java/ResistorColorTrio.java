import java.util.HashMap;
import java.util.Map;

class ResistorColorTrio
{
    private final String[] colorLabels = {
            "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"
    };

    private final Map<String, Integer> colorValues = new HashMap<>();

    public ResistorColorTrio()
    {

        for (int i = 0; i < colorLabels.length; i++)
        {
            colorValues.put(colorLabels[i], i);
        }
    }

    String label(String[] colors)
    {
        var firstColorValue = colorValues.get(colors[0]) * 10;
        var secondColorValue = colorValues.get(colors[1]);
        var modifier = colorValues.get(colors[2]);
        var totalValue = (firstColorValue + secondColorValue) * Math.pow(10, modifier);
        return getLabel(totalValue);
    }

    private String getLabel(double totalValue)
    {
        if (totalValue > Math.pow(10, 9))
        {
            var remainder = totalValue / Math.pow(10, 9);
            return String.format("%s gigaohms", (int) remainder);
        }

        if (totalValue > Math.pow(10, 6))
        {
            var remainder = totalValue / Math.pow(10, 6);
            return String.format("%s megaohms", (int) remainder);
        }
        if (totalValue > Math.pow(10, 3))
        {
            var remainder = totalValue / Math.pow(10, 3);
            return String.format("%s kiloohms", (int) remainder);
        }
        return (int) totalValue + " ohms";
    }
}
