import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder result = new StringBuilder();
        
        String numsString[] = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            numsString[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsString, (a,b)-> (b+a).compareTo(a+b));
        if (numsString[0].equals("0")) {
            return "0";
        }
//         Arrays.sort(numsString, new Comparator<String>(){
//             @Override
//             public int compare(String a, String b){
//                     for(int i = 0; i < Math.min(a.length(), b.length()); i++){
//                         if(a.charAt(i) > b.charAt(i)) return -1;
//                         else if(a.charAt(i) < b.charAt(i)) return 1;
//                     }
                
//                     String shorterStr = a.length() > b.length() ? b : a;
//                     String longerStr = a.length() > b.length() ? a : b;
                
// //                        if(shorterStr.charAt(Math.min(a.length(),b.length()) - 1) < longerStr.charAt(Math.min(a.length(),b.length()))){
// //                             if(longerStr == a) return 1;
// //                             else return -1;
// //                         }
                
                
//                     for(int i = Math.min(a.length(),b.length() -1); i < Math.max(a.length(), b.length()); i++){
//                         // if(shorterStr.charAt(Math.min(a.length(),b.length()) - 1) > longerStr.charAt(i)){
//                         //     if(longerStr == a) return 1;
//                         //     else return -1;
//                         // }
//                         if(shorterStr.charAt(Math.min(a.length(),b.length()) - 1) < longerStr.charAt(i)){
//                             if(longerStr == a) return -1;
//                             else return 1;
//                         }
//                     }
//                 return 1;
//             }
//         });
        for(int i = 0; i < numsString.length; i++){
            result.append(numsString[i]);
        }
        return result.toString();
    }
}