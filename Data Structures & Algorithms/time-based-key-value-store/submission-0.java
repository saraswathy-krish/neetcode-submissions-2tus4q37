class TimeMap {
    public record Pair(String value, int timestamp) {}
    Map<String, List<Pair>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }

        return findTarget(timeMap.get(key), timestamp);
    }

    private String findTarget(List<Pair> valueList, int target) {
        int left = 0;
        int right = valueList.size() - 1;
        int midTimestamp = 0;
        int mid =0;
        int ans = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            midTimestamp = valueList.get(mid).timestamp();
            if (midTimestamp <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans == -1 ? "" : valueList.get(ans).value();
    }
}

/*
[1,3,4,5,6,7,9]
target = 3
alice -> (happy,1) (sad,3)
david -> (neutral,4) (happy,6) (sad,5)
*/