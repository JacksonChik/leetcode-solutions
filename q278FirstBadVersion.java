/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int l = 0;
            int r = n;
            int badVer = -1;
            
            while(l <= r){
                int mid = l + ( r - l ) / 2;
    //             l + r might lead to overflow!
                boolean isMidBad = isBadVersion(mid);
                badVer = isMidBad ? mid : badVer;
                
                if(isMidBad) r = mid - 1;
                else l = mid + 1;
                
            }
            
            return badVer;
        }
    }