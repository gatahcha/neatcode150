package valid_palindrome;

class Solution {
    public boolean isPalindrome(String s) {
        
        //abccba
        char[] charArray = s.toCharArray();
        StringBuilder filteredStr = new StringBuilder();

        for (char k : charArray ){
            if ( ( k >= 'a' && k<= 'z') ||
                 ( k >= 'A' && k<= 'Z') || 
                 ( k >= '0' && k<= '9') ){
                    filteredStr.append(k);
                 }
        }
        
        String Str = filteredStr.toString().toLowerCase();

        for (int i = 0 ; i < Str.length()/2; i++){
            if (Str.charAt(i) != Str.charAt(Str.length()-1-i)) return false;
        }

        
        return true;
    }
}
