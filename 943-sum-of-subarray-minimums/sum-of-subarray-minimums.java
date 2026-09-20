class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.empty() && arr[st.peek()] > arr[i]){
                st.pop();
            } 
            if(st.empty()){
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i = n - 1; i >= 0; i--){
             while(!st.empty() && arr[st.peek()] >= arr[i]){
                st.pop();
            } 
            if(st.empty()){
                nse[i] = n;
            } else {
                nse[i] = st.peek();
            }
            st.push(i);
        } 
        long sum = 0;
        for(int i = 0; i < n; i++){
            int leftChoices = i - pse[i];
            int rightChoices = nse[i] - i;
            long contribution = (long) arr[i] * leftChoices * rightChoices;
            sum += contribution;
        }
        return (int)(sum % 1_000_000_007);
    }
}