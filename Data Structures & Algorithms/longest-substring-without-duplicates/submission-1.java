class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        for(int right = 0; right < s.length(); right++){
            window.merge(s.charAt(right), 1, Integer::sum);

            while(window.get(s.charAt(right)) > 1){
                char cc = s.charAt(left);
                window.merge(cc, -1, Integer::sum);
                if(window.get(cc) == 0) window.remove(cc);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
