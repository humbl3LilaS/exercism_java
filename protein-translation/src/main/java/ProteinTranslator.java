import java.util.ArrayList;
import java.util.List;

class ProteinTranslator
{

    List<String> translate(String rnaSequence)
    {
        var result = new ArrayList<String>();
        for (int i = 0; i < rnaSequence.length(); i += 3)
        {

            String segments = i + 3 > rnaSequence.length()
                    ? rnaSequence.substring(i)
                    : rnaSequence.substring(i, i + 3);

            if (isBreakSequence(segments))
            {
                return result;
            }

            String acid = getAcidName(segments);

            if (!acid.isEmpty())
            {
                result.add(acid);
            }
        }
        return result;
    }

    private static String getAcidName(String segment)
    {
        switch (segment)
        {
            case "AUG":
                return "Methionine";
            case "UUU":
            case "UUC":
                return "Phenylalanine";
            case "UUA":
            case "UUG":
                return "Leucine";
            case "UCU":
            case "UCC":
            case "UCA":
            case "UCG":
                return "Serine";
            case "UAU":
            case "UAC":
                return "Tyrosine";
            case "UGU":
            case "UGC":
                return "Cysteine";
            case "UGG":
                return "Tryptophan";
            default:
                throw new IllegalArgumentException("Invalid codon");
        }
    }

    private static boolean isBreakSequence(String segment)
    {
        switch (segment)
        {
            case "UAA":
            case "UAG":
            case "UGA":
                return true;
            default:
                return false;
        }
    }

}
