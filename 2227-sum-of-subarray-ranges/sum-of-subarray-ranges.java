class Solution {
    public long subArrayRanges(int[] nums) {
      int n = nums.length;
      long minSum = 0;
      long maxSum = 0;
      int[] pse = new int[n];
      int[] nse = new int[n]; 
      Stack<Integer> st = new Stack<>();
      for(int i = 0; i < n; i++){
        while(!st.empty() && nums[st.peek()] > nums[i]){
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
        while(!st.empty() && nums[st.peek()] >= nums[i]){
        st.pop();
        } 
        if(st.empty()){
            nse[i] = n;
        } else {
            nse[i] = st.peek();
        }
        st.push(i);
      }
      for(int i = 0; i < n; i++){
        long left = i - pse[i];
        long right = nse[i] - i; 
        minSum += (long) nums[i] * left * right;
      }
      int[] pge = new int[n];
      int[] nge = new int[n];
      st.clear();
      for(int i = 0; i < n; i++){
        while(!st.empty() && nums[st.peek()] < nums[i]) {
            st.pop();
        }
        if (st.empty()) {
            pge[i] = -1;
        } else {
            pge[i] = st.peek();
        }
        st.push(i);
      }
      st.clear();
      for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            if (st.empty()) {
                nge[i] = n;
            } else {
                nge[i] = st.peek();
            }

            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;

            maxSum += (long) nums[i] * left * right;
        }
      return maxSum - minSum;
    }
}