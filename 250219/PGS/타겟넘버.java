public class 타겟넘버 {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = recursive(numbers, target, 0, 0);
        return answer;
    }

    public int recursive(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += recursive(numbers, target, idx+1, sum+numbers[idx]);
        count += recursive(numbers, target, idx+1, sum-numbers[idx]);
        return count;
    }
}
