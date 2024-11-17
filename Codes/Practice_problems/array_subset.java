package Practice_problems;
public class array_subset {
	public static void main(String[] args) {
        int[] array1 = {11, 1, 13, 21, 3, 7}; 
        int[] array2 = {11, 3, 7};          
        int a = array1.length;  
        int b = array2.length;
        if (isSubset(array1, array2, a, b)) {
            System.out.println("Yes... Array1 is subset of Array2");  
        } else {
            System.out.println("No... Array1 is subset of Array2"); 
        }
    }
    public static boolean isSubset(int[] array1, int[] array2, int a, int b) {
        for (int i = 0; i < b; i++) {
            boolean found = false;

            for (int j = 0; j < a; j++) {
                if (array2[i] == array1[j]) {
                    found = true;
                    break; 
                }
            }
            if (!found) return false;
        }
        return true;
    }
}
