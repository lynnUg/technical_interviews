public class Solution {

    public String longestPalindrome(String s) {

        for(int len = s.length(); len > 0; --len) {

            for(int j = 0; j <= s.length() - len; ++j) {
                String sub = s.substring(j, j + len);

                if(isPalindrome(sub))

                    return sub;

            }

        }

        return new String();
    }

     

    private boolean isPalindrome(String s) {

        if(s.length() <= 1)

            return true;

        else

            return s.charAt(0) == s.charAt(s.length()-1) && 

                isPalindrome(s.substring(1,s.length()-1));

    }

}
