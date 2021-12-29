package arraystring;

/**
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string. You can
 * assume the string has only uppercase and lowercase letters (a - z).
 */
class _01_06_StringCompression {
    String compress(String s) {
        if (s.length() < 3) {
            return s;
        }
        // sCopy = sCopy.concat(sCopy);
        String compressed = "";
        int i = 0;
        char current = s.charAt(i);
        int occurance = 1;
        while (i < s.length() - 1) {
            if (i == s.length() - 2) {
                if (s.charAt(i + 1) == current) {
                    occurance++;
                    compressed = compressed.concat(String.valueOf(occurance));
                    compressed = compressed.concat(String.valueOf(current));
                    i++;
                } else {
                    compressed = compressed.concat(String.valueOf(occurance));
                    compressed = compressed.concat(String.valueOf(current));
                    i++;
                    compressed = compressed.concat(String.valueOf(1));
                    compressed = compressed.concat(String.valueOf(s.charAt(i)));
                }
            } else if (s.charAt(i + 1) == current) {
                occurance++;
                i++;
            } else {
                compressed = compressed.concat(String.valueOf(occurance));
                compressed = compressed.concat(String.valueOf(current));
                i++;
                current = s.charAt(i);
                occurance = 1;
            }
        }

        if (compressed.length() == s.length()) {
            return s;
        }
        return compressed;
    }

    public static void main(String[] args) {
        _01_06_StringCompression obj = new _01_06_StringCompression();
        System.out.println(obj.compress("aaabbaa"));
    }
}
