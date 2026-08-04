class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            char currleft = s.charAt(left);
            char currright = s.charAt(right);
            if(!Character.isLetterOrDigit(currleft)){
                left++;
            } else if(!Character.isLetterOrDigit(currright)){
                right--;
            } else {
                if(Character.toLowerCase(currleft) != Character.toLowerCase(currright)){
                   return false;
                } 
                left++;
                right--;
            }
        }     
        return true;
    }
}