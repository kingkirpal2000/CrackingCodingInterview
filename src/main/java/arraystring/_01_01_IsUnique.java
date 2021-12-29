package arraystring;

import java.util.ArrayList;
// import java.util.Set;
// import java.util.stream.Collectors;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 */

class _01_01_IsUnique {

    // time o(n)
    // space o(1)
    // boolean isUnique(String str) {
    //     Set<Integer> set = str.chars().boxed().collect(Collectors.toSet());
    //     return set.size() == str.length();
    // }

    public boolean isUnique(String str){
        ArrayList<Character> memo = new ArrayList<Character>();
        for(int i = 0; i < str.length(); i++){
            if(memo.contains(str.charAt(i))) return false;
            else memo.add(str.charAt(i));
        }
        return true;
    }

}
