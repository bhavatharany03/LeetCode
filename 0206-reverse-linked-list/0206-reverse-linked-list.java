/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<Integer> value = new Stack<>();

        while(head != null){
            value.push(head.val);
            head = head.next;
        }

        ListNode reverselist = new ListNode(Integer.MIN_VALUE);
        ListNode ptr = reverselist;

        while(!value.isEmpty()){
            ptr.next = new ListNode(value.pop());
            ptr = ptr.next;
        } 

        return reverselist.next;
    }
}