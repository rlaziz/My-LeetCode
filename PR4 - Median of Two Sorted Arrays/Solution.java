class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Not the perfect solution, time complexity of this O(n + m), need O(log(n + m))

        ArrayList<Integer> n1 = new ArrayList<>();
        ArrayList<Integer> n2 = new ArrayList<>();
        for (int num : nums1){
            n1.add(num);
        }
        for (int num : nums2){
            n2.add(num);
        }

        int length = n1.size() + n2.size();
        int merged = 0;

        if (length % 2 == 0){

            while(merged != (length / 2) - 1){
                nextToMerge(n1,n2);
                merged++;
            }

            return (double) (nextToMerge(n1,n2) + nextToMerge(n1,n2)) / 2.0;
        }else {

            while(merged != length / 2){
                nextToMerge(n1,n2);
                merged++;
            }

            return (double) nextToMerge(n1,n2);
        }
    }
    private int nextToMerge(ArrayList<Integer> nums1, ArrayList<Integer> nums2){

        if (nums1.size() == 0){
            return nums2.remove(0);
        }

        if (nums2.size() == 0){
            return nums1.remove(0);
        }

        int num1 = nums1.get(0);
        int num2 = nums2.get(0);

        if (num1 <= num2){
            nums1.remove(0);
            return num1;
        }else {
            nums2.remove(0);
            return num2;
        }
    }
}