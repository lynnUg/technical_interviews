public class LongestPrefix {

    private static String findLongestPrefix(String[] words){
        String solution = "";
        int len = shortestWord(words);        
        for (int i = 0; i < len; i++) {            
            char tmp = words[0].charAt(i);
            solution += tmp;
            for(String word : words){
                if(word.charAt(i) != tmp){
                    solution = solution.substring(0, solution.length()-1);
                    return solution;
                }
            }                        
        }
        return solution;
    }

    private static int shortestWord(String[] words) {
        int ans = 100;
        for(String word : words){
            ans = Math.min(ans, word.length());
        }
        return ans;
    }

    public static void main(String[] args){
        String[] arr = {"cat","abbba", "abacadabra", "abaout", "ababa"};
        System.out.println("longest prefix is "+findLongestPrefix(arr));
    }
}
