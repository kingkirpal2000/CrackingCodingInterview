package arraystring;

/**
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, sl and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring (e.g.,"waterbottle" is a
 * rotation of"erbottlewat").
 */
class _01_09_StringRotation {
    boolean isSubstring(String s1, String s2) {
        char[] s2arr = s2.toCharArray();
        for (int i = 0; i < s2arr.length; i++) {
            if (s1.contains(String.valueOf(s2arr[i]))) {
                s1 = s1.replaceFirst(String.valueOf(s2arr[i]), "");

            } else {
                return false;
            }
        }
        return true;
    }

    boolean rotated(String original, String result) {
        if (original.length() != result.length()) {
            return false;
        }
        return isSubstring(original, result);
    }

    public static void main(String[] args) {
        _01_09_StringRotation obj = new _01_09_StringRotation();
        boolean answer = obj.isSubstring("hello", "hello");
        if (answer == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
