class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        java.util.Map<Character, Character> map = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
        );
        for(char ch : s.toCharArray()){
            if(map.containsValue(ch)){
                stack.push(ch);
            }
            else if(map.containsKey(ch)){
                if(stack.isEmpty() || stack.pop() != map.get(ch)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}