import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    // Helper class to store a passenger's active check-in event
    private static class CheckInDetails {
        String stationName;
        int checkInTime;

        CheckInDetails(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    // Helper class to track aggregated travel data for a specific route
    private static class RouteStat {
        double totalTime;
        int tripCount;

        RouteStat(double totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    // Maps passenger ID -> Active Check-In Details
    private final Map<Integer, CheckInDetails> activeCheckIns;
    
    // Maps "StartStation,EndStation" -> Aggregated Route Stats
    private final Map<String, RouteStat> routeStats;

    public UndergroundSystem() {
        this.activeCheckIns = new HashMap<>();
        this.routeStats = new HashMap<>();
    }

    /**
     * Time Complexity: O(1)
     * Records that a customer checked in at a given station and time.
     */
    public void checkIn(int id, String stationName, int t) {
        activeCheckIns.put(id, new CheckInDetails(stationName, t));
    }

    /**
     * Time Complexity: O(1)
     * Completes a customer's trip, updates aggregate statistics, 
     * and clears their active check-in data.
     */
    public void checkOut(int id, String stationName, int t) {
        // Retrieve and remove the passenger's active check-in record
        CheckInDetails checkIn = activeCheckIns.remove(id);
        
        // Construct a unique key representing the direct station route
        String routeKey = checkIn.stationName + "->" + stationName;
        int travelTime = t - checkIn.checkInTime;

        // Retrieve existing stats or create a new entry if the route is new
        RouteStat stats = routeStats.getOrDefault(routeKey, new RouteStat(0, 0));
        stats.totalTime += travelTime;
        stats.tripCount += 1;

        routeStats.put(routeKey, stats);
    }

    /**
     * Time Complexity: O(1)
     * Returns the average direct travel time between two specified stations.
     */
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteStat stats = routeStats.get(routeKey);
        
        // Return average (total travel time / total direct trips)
        return stats.totalTime / stats.tripCount;
    }
}
