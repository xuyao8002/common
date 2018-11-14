package com.xuyao.test;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        int[] nums = {9, 5, 2, 7, 8};
        otherSort(nums);
//        Arrays.stream(nums).forEach(System.out::println);
    }


    public static void bubbleSort(int[] nums){
        int temp;
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
    public static void insertSort(int[] nums){
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
    public static void otherSort(int[] nums){
        int[] tmp = new int[10];
        for (int i = 0; i < nums.length; i++) {
            tmp[nums[i]]++;
        }
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i] > 0){
                System.out.println(i);
            }
        }
    }

}
