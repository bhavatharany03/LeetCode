class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
         int totalDistance = 0;
        while (mainTank > 0) {
            
            if (mainTank >= 5) {
                
                totalDistance += 50;
                mainTank -= 5;
                
                if (additionalTank > 0) {
                    mainTank += 1;
                    additionalTank -= 1;
                }
            } else {
                totalDistance += mainTank * 10;
                break;
            }
        }
        
        return totalDistance;
    }
}