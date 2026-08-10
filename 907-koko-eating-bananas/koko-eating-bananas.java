class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] > high){
                high = piles[i];
            }
        }
        int low = 1;
        int ans = high;
        while(low <= high){
            int mid = low + (high - low) / 2;
            long hours = 0;
            for(int i = 0; i < piles.length; i++){
                long hrs = piles[i] / mid;
                if(piles[i] % mid != 0){
                    hrs++;
                }
                hours += hrs;
            }
            if(hours <= h){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            } 
        }
        return ans;
    }
}