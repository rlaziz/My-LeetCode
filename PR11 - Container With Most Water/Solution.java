class Solution {
    public int maxArea(int[] height) {

        int bestArea = 0;

        int left = 0;
        int right = height.length - 1;

        int poolHeight = 0;
        int poolWidth = 0;
        int currentArea = 0;

        while (left < right){

            poolHeight = Math.min(height[left],height[right]);

            poolWidth = right - left;

            currentArea = poolWidth * poolHeight;

            bestArea = Math.max(bestArea,currentArea);

            if(height[left] < height[right]){
                left ++;
            }else {
                right --;
            }
        }

        return bestArea;
    }
}