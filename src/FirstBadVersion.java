///**
// * Created by rahilvora on 9/10/16.
// */
//public class FirstBadVersion {
//    public static void main(String args[]){
//        new FirstBadVersion().firstBadVersion(5);
//    }
//    public int firstBadVersion(int n) {
//        public int firstBadVersion(int n) {
//            int low  = 1;
//            int high = n;
//            int mid = 1;
//
//            while(low <= high){
//                if(low == high)
//                    return low;
//                mid = (low + (high - low)/2);
//                if(isBadVersion(mid)){
//                    high = mid;
//                }
//                else{
//                    low =  mid + 1;
//                }
//            }
//            return mid ;
//        }
//    }
//}
