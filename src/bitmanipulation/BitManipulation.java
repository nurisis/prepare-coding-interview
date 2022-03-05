package bitmanipulation;

public class BitManipulation {
    public static void main(String[] args) {
        int x = 16;
        int position = 2;
        int bitAdded = setBit(x, position);
        System.out.println("Set bit 1 in " + Integer.toBinaryString(x) + " in " + position + " position : " + Integer.toBinaryString(bitAdded));

        int bitCleared = clearBit(bitAdded, position);
        System.out.println("Clear bit 1 in " + Integer.toBinaryString(bitAdded) + " in " + position + " position : " + Integer.toBinaryString(bitCleared));

        int bitFliped = flitBit(bitCleared, position);
        System.out.println("Flip bit in " + Integer.toBinaryString(bitCleared) + " in " + position + " position : " + Integer.toBinaryString(bitFliped));

        System.out.println("Is bit set in " + Integer.toBinaryString(bitAdded) + " in " + position + " position : " + isBitSet(bitAdded, position));
        System.out.println("Is bit set in " + Integer.toBinaryString(bitAdded) + " in 3 position : " + isBitSet(bitAdded, 3));

        int a = 16;
        int b = 15;
        System.out.println("Count different bit between" + Integer.toBinaryString(a) + " and "+ Integer.toBinaryString(b) + " :" + countNumberOfDifferentBit(a, b));

        a = 11;
        System.out.println("Count different bit between" + Integer.toBinaryString(a) + " and "+ Integer.toBinaryString(b) + " :" + countNumberOfDifferentBit(a, b));

        System.out.println("abs(-14) : " + abs(-14));
        System.out.println("abs(1579) : " + abs(1579));
        System.out.println("abs(-1234567892345L) : " + abs(-1234567892345L));

        swap(13, 6);

        System.out.println("min(1,9): "+min(1, 9));
        System.out.println("min(11,9): "+min(11, 9));
        System.out.println("min(-11,9): "+min(-11, 9));

        System.out.println(Integer.toBinaryString(10 & 1));
    }

    /**
     * Why it works?
     * case1) x < y
     * - y ^ ((x^y) & -1) => -1 is 1's in two's complement
     * => y ^ ((x^y)) => x
     *
     * case2) x >= y
     * - y ^ ((x^y) & 0)
     * => y ^ 0 => y
     */
    public static int min(int x, int y) {
         return y ^ ((x^y) & -(x < y ? 1 : 0));
    }

    /**
     * Swap the two integers without a temporary variable.
     * Why it works?
     * -> (x ^ y) ^ y => x
     *
     * BUT, performance is not good. Poor at exploiting instruction-level parallelism(ILP)
     */
    public static void swap(int x, int y) {
        System.out.println("Before swap >> x:"+x+", y:"+y);

        // Mask with 1's where bit differs.
        x = x ^ y;
        // Flip bits in y that differ from x.
        y = x ^ y;
        // Flip bits in x that differ from y.
        x = x ^ y;
        System.out.println("After swap >> x:"+x+", y:"+y);
    }

    /**
     * https://bits.stephan-brumme.com/absInteger.html
     * 2의 보수 체계를 이용해 아래와 같이 구해도 되긴 하지만, shift 연산을 통해 구하는 방법이다.
     * - for x ≥ 0 → x
     * - for x < 0 → NOT(x) + 1
     * @return absolute value of x
     */
    public static int abs(int x) {
        int bit31 = x >> 31;
        return (x ^ bit31) - bit31;
    }
    public static long abs(long x) {
        long bit63 = x >> 63;
        return (x ^ bit63) - bit63;
    }

    public static int countNumberOfDifferentBit(int a, int b) {
        int number = a ^ b;
        int count = 0;
        while (number > 0) {
            if ((number & 1) == 1) count++;
            number = number >> 1;
        }

        return count;
    }

    public static boolean checkIfPowerOf2(int x) {
        return (x & (x-1)) == 0;
    }

    public static boolean checkIfEven(int x) {
        return (x & 1) == 0;
    }

    public static boolean isBitSet(int x, int position) {
        int shifted = x >> position;
        return (shifted & 1) == 1;
    }

    public static int flitBit(int x, int position) {
        int mask = 1 << position;
        return x ^ mask;
    }

    public static int clearBit(int x, int position) {
        int mask = 1 << position;
        return x & ~mask;
    }

    public static int setBit(int x, int position) {
        int mask = 1 << position;
        return x | mask;
    }
}
