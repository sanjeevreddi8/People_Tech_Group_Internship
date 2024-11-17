package Practice_problems;
public class smallest_missing_pos_num {
    public static int findSmallestMissingPositive(int[] array) {
        int a = array.length;
        for (int i = 0; i < a; i++) {
            if (array[i] <= 0 || array[i] > a) {
                array[i] = a + 1;
            }
        }
        for (int i = 0; i < a; i++) {
            int number = Math.abs(array[i]);
            if (number <= a) {
                array[number - 1] = -Math.abs(array[number - 1]);
            }
        }
        for (int i = 0; i < a; i++) {
            if (array[i] > 0) {
                return i + 1;
            }
        }
        return a + 1;
    }
    public static void main(String[] args) {
        int[] array1 = {2, -3, 4, 1, 1, 7};
        int[] array2 = {5, 3, 2, 5, 1};
        int[] array3 = {-8, 0, -1, -4, -3};
        System.out.println(findSmallestMissingPositive(array1)); 
        System.out.println(findSmallestMissingPositive(array2));  
        System.out.println(findSmallestMissingPositive(array3)); 
    }
}
