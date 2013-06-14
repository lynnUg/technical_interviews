public class Exercise_18
{
  public static int strStr(String large, String possibleSubStr)
  {
    for(int i = 0; i < large.length(); i++ ) {
        for(int j = 0; j < possibleSubStr.length() && i+j < large.length(); j++ ) 
        {
            if(possibleSubStr.charAt(j) != large.charAt(i+j)) 
            {
                break;
            }
             else if (j == possibleSubStr.length()-1)
            {
                return i;
            }
        }
    }
    return -1;
}

public static void main (String args[])
{
    String large = "abcde";
    String small = "cd";
    System.out.println(strStr(large, small));
  }
    
}
