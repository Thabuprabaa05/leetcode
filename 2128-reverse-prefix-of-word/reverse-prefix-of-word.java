class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        int start = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == ch){
                int end = i;
                Reverse(arr, start, end);
                break;
            }
        }
        return new String(arr);
    }
    private void Reverse(char[] ch, int s, int e){
        while(s < e){
            char temp = ch[s];
            ch[s] = ch[e];
            ch[e] = temp;
            s++;
            e--;
        }
    }
}