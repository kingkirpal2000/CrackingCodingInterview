package arraystring;
import java.util.HashSet;
import java.util.Set;
/**
 * There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * <p>
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
class _01_05_OneAway {
    boolean isOneAway(String a, String b) {
       if(a.equals(b)){
           return true;
       } else if (a.length() == b.length()-1){ //recursiveRemove
            return Remove(b, a);
       } else if (b.length() == a.length()-1){ //recursiveRemove
            return Remove(a, b);
       } else if (a.length() == b.length()){ //replaceCharacter
            return replaceCharacter(a, b);
       } else {
           return false;
       }
    }

    boolean Remove(String a, String b){ //bigger string is a
        //Method that will recursively remove one character at a time and break if b matches a
        Set<Character> set = new HashSet<>();
        for(char c : a.toCharArray()){
            set.add(c);
        }
        for(char c : b.toCharArray()){
            if(set.contains(c)) set.remove(c);
            else return false;
        }
        return true;
    }

    

    boolean replaceCharacter(String a, String b){
        //Replace the only different character in the two strings
        //only do this if two strings are equal length
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                String test = a.replace(a.charAt(i), b.charAt(i));
                if(test.equals(b)) return true;
            }
        }

        return false;
    }
    
    
}
