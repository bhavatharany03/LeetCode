class Solution {
    public String reverseByType(String s) {

        char[] ch = s.toCharArray();
        int n = ch.length;

       
        int start = 0, end = n - 1;

        while(start < end){
            if(!(ch[start] >= 'a' && ch[start] <= 'z')){
                start++;
            }
            else if(!(ch[end] >= 'a' && ch[end] <= 'z')){
                end--;
            }
            else{
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }

       
        start = 0;
        end = n - 1;

        while(start < end){
            if(ch[start] >= 'a' && ch[start] <= 'z'){
                start++;
            }
            else if(ch[end] >= 'a' && ch[end] <= 'z'){
                end--;
            }
            else{
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }

        return new String(ch);
    }
}