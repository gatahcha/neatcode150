package trapping_rain_water;

public class Solution {
    public int trap(int[] height) {

        int storedWater = 0;
        int[] prefixes = new int[height.length];
        int[] suffices = new int[height.length];

        //storign prefixes
        for (int i = 1; i < prefixes.length; i++){
            if ( prefixes[i-1] < height[i-1] ) prefixes[i] = height[i-1];
            else prefixes[i] = prefixes[i-1];
        }
    
        //stroing suffices
        for (int j = height.length - 2; j > 0; j--){
            if (suffices[j+1] < height[j+1]) suffices[j] = height[j+1];
            else suffices[j] = suffices[j+1];
        }

        //itteratiing over to determine the trapped rainwater
        for (int k = 0 ; k < height.length; k++){
            storedWater += ( ( Math.min(prefixes[k], suffices[k]) - height[k] ) > 0 )?
                                 Math.min(prefixes[k], suffices[k]) - height[k] : 0 ;
        }

        return storedWater;
    }
}
