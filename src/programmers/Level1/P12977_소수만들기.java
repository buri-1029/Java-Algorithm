package programmers.Level1;

public class P12977_소수만들기 {
    static int cnt;
    static int[] select;
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 7, 6, 4};

        int ans1 = solution(nums1);
        System.out.println(ans1);

        int ans2 = solution(nums2);
        System.out.println(ans2);
    }

    private static int solution(int[] nums) {
        select = new int[3];
        cnt = 0;
        combination(0, 0, nums);
        return cnt;
    }

    private static void combination(int idx, int k, int[] nums) {
        if(k == select.length){
            int n = select[0] + select[1] + select[2];
            if(isPrime(n)) cnt++;
            return;
        }
        for(int i = idx ; i < nums.length; i++){
            select[k] = nums[i];
            combination(i + 1, k + 1, nums);
        }
    }

    private static boolean isPrime(int n) {
        if(n < 2){
            return false;
        }

        // 2부터 해당 숫자까지 모든 숫자로 나눠볼 필요 없이,
        // 해당 숫자의 제곱근까지만 구하면 된다.
        for(int i = 2; i*i <= n; i++){
            if(n%i == 0){
                return false;
            }
        }

        return true;
    }
}
