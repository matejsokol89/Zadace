public class MaxAndMinValue {
    //metoda koja vraca najveći broj
    static int max(int[] listOfNums) {
        int max = listOfNums[0];

        for (int i = 1; i < listOfNums.length; i++) {
            if (listOfNums[i] > max) {
                max = listOfNums[i];
            }
        }
        System.out.println(max);
        return max;
    }

    // metoda koja vraca samo namjmanji broj
    static int min(int[] listOfNums) {
        int min = listOfNums[0];

        for (int i = 1; i < listOfNums.length; i++) {
            if (listOfNums[i] < min) {
                min = listOfNums[i];
            }
        }
        System.out.println(min);
        return min;
    }


    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 5, 6};
        max(numbers);
        min(numbers);
    }
}
