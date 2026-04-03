
class FrequencyKey{
    private final int[] counts;

    public FrequencyKey(int[] counts){
        this.counts = counts;
    }

    @Override
    public boolean equals(Object o) {
        //check if both of them are physiclaly at the same location
        if (this == o) return true;

        if (!(o instanceof FrequencyKey)) return false;
        //check whether the contents of both of them are the same
        return Arrays.equals(counts, ((FrequencyKey) o).counts);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(counts);
    }
}
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        // Notice the Map key is now our custom FrequencyKey object
        Map<FrequencyKey, List<String>> anaMap = new HashMap<>();

        for(String str: strs){
            int[] counts = new int[26];
            for (char c : str.toCharArray()) {
                counts[c - 'a']++;
            }
// Wrap the array in our custom key object
            FrequencyKey key = new FrequencyKey(counts);
            // The HashMap will now use our custom equals() and hashCode()
            anaMap.computeIfAbsent(key,k->new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anaMap.values());
    }
}

