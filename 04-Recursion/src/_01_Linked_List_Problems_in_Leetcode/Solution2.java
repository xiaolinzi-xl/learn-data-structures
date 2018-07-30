package _01_Linked_List_Problems_in_Leetcode;

/**
 * Created by xiaolinzi on 2018/7/30.
 */
public class Solution2 {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = removeElements(head, 6);
        System.out.println(res);

    }
}
