package RecursionAndBackTracking;

public class wordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordDict = {"leet", "code"};

        boolean result = wordBreak(s, wordDict);
        System.out.println("Can the string be segmented? " + result);
    }

    public static boolean wordBreak(String s, String[] wordDict) {
        java.util.Set<String> wordSet = new java.util.HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        return canBreak(s, wordSet, 0, new Boolean[s.length()]);
    }

    private static boolean canBreak(String s, java.util.Set<String> wordSet, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordSet.contains(s.substring(start, end)) && canBreak(s, wordSet, end, memo)) {
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }
}
