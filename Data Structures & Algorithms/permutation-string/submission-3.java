class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int best = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            need.merge(s1.charAt(i), 1, Integer::sum);
        }
        
        for(int right = 0; right < s2.length(); right++){
            window.merge(s2.charAt(right), 1, Integer::sum);

            if(right - left + 1 == s1.length()){
                if(need.equals(window)) return true;
                
                char c = s2.charAt(left);
                window.merge(c, -1, Integer::sum);

                if(window.get(c) == 0) window.remove(c);
                left++;
            }
        }

        return false;
    }
}
