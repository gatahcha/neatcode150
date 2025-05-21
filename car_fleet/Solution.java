package car_fleet;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        //building logic 
            //time required : ( target - pos[i] ) / speed
            //same fleet if time[i] < time[i+1] inductively
            //the position is not ordered -> use priorityqueueb

        int len = position.length;
        PriorityQueue<int[]> ord_pos = new PriorityQueue<>( (a,b) -> b[0] - a[0]);
        for (int i = 0 ; i < len ; i++){
            ord_pos.add(new int[]{position[i], speed[i]});
        }

        double last_time = -1.0;
        int fleet = 0;
        for ( int i = 0 ; i < len; i++ ){
            //calculatiing time required
            int[] poller = ord_pos.poll();
            int pos = poller[0];
            int spd = poller[1];
            double cur_time = 1.0 * ( target - pos ) / spd;
            System.out.println(cur_time); System.out.println();
            if ( cur_time > last_time ) fleet++;
            last_time = Math.max(last_time, cur_time);
        }
        return fleet;
    }
}
