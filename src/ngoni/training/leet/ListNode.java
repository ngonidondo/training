package ngoni.training.leet;

public class ListNode {

	public int lengthOfLongestSubstring(String s) {
        String lastChar = "";
        int maxSubStrSize = 0;
        int currentSubStrSize=0;
        for(int i =0; i < s.length(); i++){
            if(lastChar.indexOf(s.charAt(i)) != -1){
            		lastChar = lastChar.substring(lastChar.indexOf(s.charAt(i)) + 1)+ s.charAt(i);
                currentSubStrSize=lastChar.length();
            }else{
            		lastChar = lastChar + s.charAt(i);
                currentSubStrSize++;
            }
            
            if(maxSubStrSize < currentSubStrSize ){
                maxSubStrSize =currentSubStrSize;
            }
        }
        return maxSubStrSize;
    }
    
    public static void main(String args[]){
        ListNode sln = new ListNode();
        System.out.println(sln.lengthOfLongestSubstring("dvdf"));
    }
}
