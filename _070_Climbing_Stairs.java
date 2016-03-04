public class Solution {
    public int climbStairs(int n) {
        if( n == 0 )return 0;
        if( n == 1 )return 1;
        if( n == 2 )return 2;

        int steps = 0;
        int oneStepBefore = 2;
        int twoStepsBefore = 1;

        for(int i = 2; i < n; i++){
            steps = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = steps;
        }
        return steps;
    }
    // public int climbStairs(int n) {
    //     if( n == 0 )return 0;
    //     if( n == 1 )return 1;
    //     if( n == 2 )return 2;

    //     int[] mem = new int[n];
    //     mem[0] = 1;
    //     mem[1] = 2;
    //     for(int i = 2; i < n; i++){
    //         mem[i] = mem[i-1] + mem[i-2];
    //     }
    //     return mem[n-1];
    // }
}
