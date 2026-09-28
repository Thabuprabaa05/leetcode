class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            char current = num.charAt(i);
            while(k > 0 && !st.isEmpty() && st.peek() > current){
                st.pop();
                k--;
            }
            st.push(current);
        }
        while(k > 0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        for(char ch : st){
            ans.append(ch);
        }
        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }
        String result = ans.substring(i);
        if(result.length() == 0){
            return "0";
        }
        return result;
    }
}