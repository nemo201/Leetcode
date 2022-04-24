class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> checkins = new HashMap<>();
    Map<Pair<String, String>, int[]> routes = new HashMap<>();
    public void checkIn(int id, String stationName, int t) {
        checkins.put(id, new Pair(stationName, t));
    }
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> cIn = checkins.get(id);
        checkins.remove(id);
        Pair<String, String> route = new Pair(cIn.getKey(), stationName);
        int[] trip = routes.getOrDefault(route, new int[2]);
        trip[0]++;
        trip[1] += t - cIn.getValue();
        routes.put(route, trip);
    }
    public double getAverageTime(String startStation, String endStation) {
        int[] trip = routes.get(new Pair(startStation, endStation));
        return (double)trip[1] / trip[0];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */