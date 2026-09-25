class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int best = 0;
        Map<Character, Integer> window = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            char c1 = s.charAt(right);
            window.merge(c1, 1 , Integer::sum);
            int max = Collections.max(window.entrySet(), Map.Entry.comparingByValue()).getValue();

            while((right - left + 1) - max > k){
                char c2 = s.charAt(left);
                window.merge(c2, -1, Integer::sum);
                if(window.get(c2) == 0) window.remove(c2);
                left++;
            }
            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}
