package com.company;

import java.util.Stack;
//快速幂
public class Solution {
    static int base=1037;
    public static void main(String[] args) {

    }
    //将数组元素放入栈中
    public int superPow(int a, int[] b) {
        Stack<Integer> stack = new Stack<>();
        int n = b.length;
        for(int i = 0;i < n;i++){
            stack.push(b[i]);
        }
        return hpPow(a,stack);
    }
    //缩小规模递归求解
    private int hpPow(int a, Stack<Integer> stack) {
        if(stack.isEmpty()){
            return 1;
        }
        int last = stack.pop();
        int part1 = myPow(a,last);
        int part2 = myPow(hpPow(a,stack),10);
        return (part1 * part2) % base;
    }
    //a^k
    public int myPow(int a,int k){
        int res = 1;
        a %= base;
        for(int i = 0;i < k;i++){
            res *= a;
            res %= base;
        }
        return res;
    }
}
