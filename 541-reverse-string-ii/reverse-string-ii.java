class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = k -1;
        for(int i = 0; i < arr.length; i += 2 * k){
            left = i;
            right = Math.min(i + k - 1, arr.length - 1);
            while(left < right){
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;  
                left++;
                right--;
            }  
        }
        return new String(arr);
    }
}