package com.xuyao.test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        int[] nums = {9, 5, 2, 7, 8};
        sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
    public static void sort(int[] nums){
        int temp;
        int j;
        for(int i = 1; i < nums.length; i++){
            temp = nums[i];
            for(j = i; j > 0; j--){
                if(nums[j - 1] > temp){
                    nums[j] = nums[j-1];
                }else{
                    break;
                }
            }
            nums[j] = temp;
        }
    }
}
