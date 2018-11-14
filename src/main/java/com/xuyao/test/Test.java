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
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j+1]){
                    temp = nums[j+1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

}
