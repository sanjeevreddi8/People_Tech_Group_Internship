package Practice_problems;
 
import java.util.ArrayList;
import java.util.List;

class arrays_problem1 {
    
	public static void main(String[] args) {
        int[] arr = {16, 17, 44, 16, 9, 21, 29, 44, 11};
        List<Integer> duplicates = findDuplicates(arr);        
        for (int x : duplicates) {
            System.out.print(x + " ");
        }
    }
	static List<Integer> findDuplicates(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    if (!res.contains(arr[i])) {
                        res.add(arr[i]);
                    }
                    break; 
                }
            }
        }
        return res;
    }
}
