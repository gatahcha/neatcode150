package container_with_most_water;

class Solution {
    public int maxArea(int[] heights) {

        int lo = 0; 
        int hi = heights.length - 1;
        int maxArea = calcArea(heights, lo, hi);

        while (lo < hi){
            if ( heights[lo] < heights[hi] ){
                int lastHeight = heights[lo];
                while (heights[lo] <= lastHeight && lo < hi ) lo++;
                int curArea = calcArea(heights, lo, hi);
                if ( curArea > maxArea ) maxArea = curArea;
            }
            else{
                int lastHeight = heights[hi];
                while (heights[hi] <= lastHeight && lo < hi) hi--;
                int curArea = calcArea(heights, lo, hi);
                if ( curArea > maxArea ) maxArea = curArea;
            }
        }
        return maxArea;
    }

    public int calcArea (int[] heights, int lo, int hi){
        return (hi - lo)*( (heights[lo] < heights[hi]) ? heights[lo] : heights[hi] );
    }
}
