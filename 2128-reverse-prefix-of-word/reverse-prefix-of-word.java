class Solution {
    public String reversePrefix(String word, char ch) {
        Stack<Character> st = new Stack<>();
        int index = word.indexOf(ch);
        if(index == -1){
            return word;
        }
        char[] ans = word.toCharArray();
        for(int i = 0; i <= index; i++){
            st.push(word.charAt(i));
        }
        for(int i = 0; i <= index; i++){
            ans[i] = st.pop();
        }
        return new String(ans);
    }
}