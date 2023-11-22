public class LongestSubstring {
    public static void main(String[] args) {
        String input = "abcabcbb";
        String input2 = "bbbbb";
        String input3 = "pwwkew";
        System.out.println(getLongestSubstring(input));
        System.out.println(getLongestSubstring(input2));
        System.out.println(getLongestSubstring(input3));
    }

    private static int getLongestSubstring(String input) {
        String longest = "";
        for (int i = 0; i < input.length(); i++) {
            String s = "";
            for (int j = i; j < input.length(); j++) {
                if (!s.contains(input.charAt(j) + "")) {
                    s += input.charAt(j);
                } else {
                    break;
                }
                if (longest.length() < s.length())
                    longest = s;
            }
        }
        System.out.println("Word: " + longest);
        return longest.length();

    }
}
