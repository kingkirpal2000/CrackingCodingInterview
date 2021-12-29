package arraystring;

// import java.util.HashMap;
// import java.util.Map;
import java.util.*;

/**
 * Given two strings,write a method to decide if one is a permutation of the other.
 */
class _01_02_CheckPermutation {
    // boolean check(String a, String b) {
    //     return computeFrequency(a).equals(computeFrequency(b));
    // }

    // private Map<Character, Integer> computeFrequency(String s) {
    //     Map<Character, Integer> freq = new HashMap<>();
    //     for (int i = 0; i < s.length(); i++) {
    //         freq.merge(s.charAt(i), 1, (ov, v) -> ov + v);
    //     }
    //     return freq;
    // }

    public boolean check(String s1, String s2){

        if(s1.length() != s2.length()){
            return false;
        }

        ArrayList<Character> s1Checklist = new ArrayList<Character>();
        for(int i = 0; i < s1.length(); i++){
            s1Checklist.add(s1.charAt(i));
        }
    
        for(int i = 0; i < s2.length(); i++){
         
            if(s1Checklist.contains(s2.charAt(i))){
                s1Checklist.remove(s1Checklist.indexOf(s2.charAt(i)));
            } else{
                
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args){
        _01_02_CheckPermutation obj = new _01_02_CheckPermutation();
        System.out.println(obj.check("hello", "lloeh"));
    }
}
