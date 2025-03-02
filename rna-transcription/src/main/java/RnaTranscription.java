import java.util.Arrays;
import java.util.stream.Collectors;

class RnaTranscription
{

    String transcribe(String dnaStrand)
    {
        var sequence = dnaStrand.split("");
        return Arrays.stream(sequence)
                     .map(RnaTranscription::changeSequence)
                     .collect(
                             Collectors.joining());
    }

    private static String changeSequence(String nucleotides)
    {
        switch (nucleotides)
        {
            case "G":
                return "C";
            case "C":
                return "G";
            case "T":
                return "A";
            case "A":
                return "U";
            default:
                return "";
        }
    }

}
