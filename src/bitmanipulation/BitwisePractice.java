package bitmanipulation;

public class BitwisePractice {
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
