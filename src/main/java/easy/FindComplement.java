package easy;

public class FindComplement {

    /**
     * @param num integer in 1..2^31
     * @return complement to binary version
     * Example: 5 -> 101 so complement is flipped 101 -> 010 -> 2
     * @see <a href="https://leetcode.com/problems/number-complement/">Task</a>
     */
    public static int findComplement(int num) {
        int number_of_bits =
                (int) (Math.floor(Math.log(num) /
                        Math.log(2))) + 1;

        return ((1 << number_of_bits) - 1) ^ num;
    }

}
