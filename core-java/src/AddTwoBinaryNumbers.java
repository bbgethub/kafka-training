public class AddTwoBinaryNumbers {
    public static void main(String[] args) {
        long b1 = 11100;
        long b2 = 10101;
        int[] sum = new int[10];
        int i = 0, carry = 0;
        while (b1 != 0 || b2 != 0) {
            sum[i++] = (int) ((b1 % 10 + b2 % 10 + carry) % 2);
            carry = (int) ((b1 % 10 + b2 % 10 + carry) / 2);
            b1 /= 10;
            b2 /= 10;
        }
        if (carry != 0) {
            sum[i++] = carry;
        }
        --i;
        while (i >= 0) {
            System.out.print(sum[i--]);
        }
    }
}
