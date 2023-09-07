import java.util.Random;

public class JavaWarmup1 {
    public static void main(String[] args) {
        int[] nums = new int[20];
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(9);
        }
        int numsInRow = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]){
                if(numsInRow == 0){
                    System.out.print("(");
                    numsInRow++;
                } 
                numsInRow++;
            }
            System.out.print(nums[i]);
            if(nums[i] != nums[i + 1]){
                if(numsInRow > 1){
                    System.out.print(")");
                    numsInRow = 0;
                }
            }
        }
        if(numsInRow > 1) System.out.println(")");
    }
}
