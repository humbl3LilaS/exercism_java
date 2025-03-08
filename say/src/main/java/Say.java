import java.util.HashMap;
import java.util.Map;

public class Say
{
    private static final long ONE_TRILLION = (long) Math.pow(10, 12);
    private static final int ONE_BILLION = 1_000_000_000;
    private static final int ONE_MILLION = 1_000_000;
    private static final Map<String, String> dictionary = new HashMap<>();

    static
    {
        dictionary.put("0", "zero");
        dictionary.put("1", "one");
        dictionary.put("2", "two");
        dictionary.put("3", "three");
        dictionary.put("4", "four");
        dictionary.put("5", "five");
        dictionary.put("6", "six");
        dictionary.put("7", "seven");
        dictionary.put("8", "eight");
        dictionary.put("9", "nine");
        dictionary.put("10", "ten");
        dictionary.put("11", "eleven");
        dictionary.put("12", "twelve");
        dictionary.put("13", "thirteen");
        dictionary.put("14", "fourteen");
        dictionary.put("15", "fifteen");
        dictionary.put("16", "sixteen");
        dictionary.put("17", "seventeen");
        dictionary.put("18", "eighteen");
        dictionary.put("19", "nineteen");
        dictionary.put("20", "twenty");
        dictionary.put("30", "thirty");
        dictionary.put("40", "forty");
        dictionary.put("50", "fifty");
        dictionary.put("60", "sixty");
        dictionary.put("70", "seventy");
        dictionary.put("80", "eighty");
        dictionary.put("90", "ninety");
    }

    public String say(long number)
    {
        if (number < 0 || number > ONE_TRILLION - 1)
        {
            throw new IllegalArgumentException();
        }
        var result = new StringBuilder();

        if (number < 10)
        {
            result.append(dictionary.get(String.valueOf(number)));
            return result.toString();
        }

        if (number < 100)
        {
            sayTens(number, result);
            return result.toString();
        }

        if (number < 1000)
        {
            sayHundreds(number, result);
            return result.toString();
        }

        if (number < ONE_MILLION)
        {
            sayThousands(number, result);
            return result.toString();
        }

        if (number < ONE_BILLION)
        {
            sayMillions(number,  result);
            return result.toString();
        }

        sayBillions(number, result);

        return result.toString();
    }

    private static void sayTens(long number, StringBuilder res)
    {

        if (number < 20 || number % 10 == 0)
        {
            res.append(dictionary.get(String.valueOf(number)));
        }
        else
        {
            res.append(dictionary.get(String.valueOf(number / 10 * 10)))
               .append("-")
               .append(dictionary.get(String.valueOf(number % 10)));
        }
    }

    private static void sayHundreds(long number, StringBuilder res)
    {
        if (number % 100 == 0)
        {
            res.append(dictionary.get(String.valueOf(number / 100))).append(" hundred");
        }
        else
        {
            res.append(dictionary.get(String.valueOf(number / 100))).append(" hundred ");
            sayTens(number % 100, res);
        }
    }

    private static void sayThousands(long number, StringBuilder res)
    {
        var div = number / 1000;
        if (number % 1000 == 0)
        {
            if (div > 100)
            {
                sayHundreds(div, res);
            }
            else if (div > 10)
            {
                sayTens(div, res);

            }
            else
            {
                res.append(dictionary.get(String.valueOf(div)));
            }
            res.append(" thousand");
        }
        else
        {
            if (div > 100)
            {
                sayHundreds(div, res);
            }
            else if (div > 10)
            {
                sayTens(div, res);

            }
            else
            {
                res.append(dictionary.get(String.valueOf(div)));
            }
            res.append(" thousand ");
            sayHundreds(number % 1000, res);
        }
    }

    private static void sayMillions(long number, StringBuilder res)
    {
        var div = number / ONE_MILLION;
        if (number % ONE_MILLION == 0)
        {
            if (div > 100)
            {
                sayHundreds(div, res);
            }
            else if (div > 10)
            {
                sayTens(div, res);

            }
            else
            {
                res.append(dictionary.get(String.valueOf(div)));
            }
            res.append(" million");
        }
        else
        {
            if (div > 100)
            {
                sayHundreds(div, res);
            }
            else if (div > 10)
            {
                sayTens(div, res);

            }
            else
            {
                res.append(dictionary.get(String.valueOf(div)));
            }
            res.append(" million ");
            sayThousands(number % ONE_MILLION, res);
        }
    }

    private static void sayBillions(long number, StringBuilder res)
    {
        var div = number / ONE_BILLION;
        if (number % ONE_BILLION == 0)
        {
            if (div > 100)
            {
                sayHundreds(div, res);
            }
            else if (div > 10)
            {
                sayTens(div, res);

            }
            else
            {
                res.append(dictionary.get(String.valueOf(div)));
            }
            res.append(" billion");
        }
        else
        {
            if (div > 100)
            {
                sayHundreds(div, res);
            }
            else if (div > 10)
            {
                sayTens(div, res);

            }
            else
            {
                res.append(dictionary.get(String.valueOf(div)));
            }
            res.append(" billion ");
            sayMillions(number % ONE_BILLION, res);
        }
    }

}