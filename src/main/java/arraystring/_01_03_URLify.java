package arraystring;

/**
 * Write a method to replace all spaces in a string with '%20'
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 * <p>
 * EXAMPLE
 * Input:  "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 */
class _01_03_URLify {
    void makeSpace(char[] chars, int index){
      
        for(int i = chars.length-1; i >= index; i--){
            chars[i] = chars[i-1];
        }
    }

    char[] urlify(char[] chars, int trueLength) {
       
        int spaces = 0;
        for(int i = 0; i < trueLength; i++){
            if(chars[i] == ' ') spaces++;
        }

        if(spaces * 2 + trueLength > chars.length) throw new IllegalArgumentException("Given chars array too small to hold new string");

        for(int i = 0; i < trueLength; i++){
            if(chars[i] == ' '){
                chars[i] = '%';
                if(chars[i+1] != ' '){
                    makeSpace(chars, i+1);
                    chars[i+1] = '2';
                } else {
                    chars[i+1] = '2';
                }
                if(chars[i+2] != ' '){
                    makeSpace(chars, i+2);
                    chars[i+2] = '0';
                } else {
                    chars[i+2] = '0';
                }
            }
        }

        return chars;
    }


    public static void main(String[] args){
        char[] arr = "hello world users    ".toCharArray();

        _01_03_URLify obj = new _01_03_URLify();

        obj.urlify(arr, 17);

        System.out.println(arr);
    }
}
