package com.needforcode.corejava.scratch;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode c1=l1;
        ListNode c2=l2;

        ListNode result=null;

        int carry=0;
        while(c1!=null || c2!=null) {
            int sum=0;
            if(c1!=null && c2!=null) {
                sum = (c1.val + c2.val + carry )%10;
                carry = (c1.val + c2.val + carry )/10;
                c1=c1.next;
                c2=c2.next;
            }
            else if(c1==null) {
                sum = (c2.val + carry )%10;
                carry = (c2.val + carry )/10;
                c2=c2.next;
            }
            else if(c2==null) {
                sum=(c1.val + carry)%10;
                carry = (c1.val + carry )/10;
                c1=c1.next;
            } else {
                sum = carry;
            }

            ListNode current = result;
            if(result==null) {
                result = new ListNode(sum);
            } else {
                current.next = new ListNode(sum);
                current = current.next;
            }

        }

        return result;

    }

    public static void main(String[] args) {
        ListNode l1= new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2= new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1,l2);

        System.out.println(result.val + "-" + result.next.val +"-"+ result.next.val);
    }
}
