package arraystring;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 * <p>
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco cta", etc.)
 */
class _01_04_PalindromePermutation {
    boolean check(String s) {
        

        Set<Character> list = new HashSet<>();

        for(char c : s.toCharArray()){
            if(c == ' ') continue;
            if(list.contains(c)) list.remove(c);
            else list.add(c);
        }

        return list.size() < 2;

    }
}
