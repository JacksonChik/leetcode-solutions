class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int ptrLeft = 0;
        int ptrRight = height.length-1;
        
        while(ptrRight > ptrLeft){
            int currentArea = (ptrRight - ptrLeft) * Math.min(height[ptrRight], height[ptrLeft]);
            max = Math.max(currentArea, max);
            
            if (height[ptrLeft] >= height[ptrRight]) ptrRight--;
            else ptrLeft++;
            
            //TRICKY STUFF
        }
        return max;
    }
}

// NON-OPTIMAL IMPLEMENTATION
// class Solution {
//     public int maxArea(int[] height) {
//         int max = 0;
//        for(int ptrFast = 1, ptrSlow =0; ptrFast < height.length; ptrFast++){
//            int currentArea = Math.min(height[ptrFast], height[ptrSlow]) * (ptrFast - ptrSlow);
//            for(int j = 0; j < ptrFast; j++){
//                if((Math.min(height[ptrFast], height[j]) * (ptrFast - j)) > currentArea){
//                    currentArea = (Math.min(height[ptrFast], height[j]) * (ptrFast - j));
//                    ptrSlow = j;
//                }
//            }
//            if(currentArea > max) max = currentArea;
//        }
//         return max;
//     }
// }