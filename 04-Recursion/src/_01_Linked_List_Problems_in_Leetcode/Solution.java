package _01_Linked_List_Problems_in_Leetcode;


/**
 * LeetCode 203
 * <p>
 * Created by xiaolinzi on 2018/7/14.
 */
public class Solution {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode virNode = new ListNode(0);
        virNode.next = head;
        ListNode cur = virNode;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return virNode.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = removeElements(head, 6);
        System.out.println(res);

    }
}
