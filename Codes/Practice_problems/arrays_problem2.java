package Practice_problems;

class arrays_problem2 {
	
	 public static void main(String[] args) {
	        int[] array = {1, 6, 9, 1, 12, 9, 14, 9, 18, 8};
	        int find = 9;
	        System.out.println(count_occruence(array, find)); 
	    }	 
    static int count_occruence(int[] array, int find) {
        int inc = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == find) { 
                inc++; 
            }
        }        
        return inc; 
    }
}