import java.util.HashMap;
import java.util.Map;

class RaindropConverter
{
    private Map<Integer, String> divisor = new HashMap<>();

    public RaindropConverter()
    {
        divisor.put(3, "Pling");
        divisor.put(5, "Plang");
        divisor.put(7, "Plong");

    }

    String convert(int number)
    {
        var result = new StringBuilder();

        divisor.forEach((key, value) ->
                        {
                            if (number % key == 0)
                            {
                                result.append(value);
                            }
                        });

        if (result.toString().isEmpty()) {
            result.append(number);
        }
        return result.toString();
    }

}
