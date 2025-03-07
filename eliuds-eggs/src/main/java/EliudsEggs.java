public class EliudsEggs
{
    public int eggCount(int number)
    {
        return (int) Integer.toBinaryString(number).chars().filter(x -> x == '1').count();
    }

}
