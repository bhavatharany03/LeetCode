class Solution {
    public String reversePrefix(String s, int k) {
        

        int start = 0;

        char[] ch = s.toCharArray();


        int end = k-1;

        while(start<end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end]=temp;

            start++;
            end--;
        }

       s = new String(ch);

       return s;

    }
}