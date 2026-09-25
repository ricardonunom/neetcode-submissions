class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> obj = map.getOrDefault(key, null);
        if(obj == null) return "";

        String value = obj.get(timestamp);
        if(value != null){
            return value;
        } else {
            Map.Entry<Integer, String> entry = obj.floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();
        }
    }
}
