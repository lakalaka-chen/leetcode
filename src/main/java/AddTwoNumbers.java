class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode p = result;
        int num = 0; // num同时可以表示进位
        while (l1!=null || l2!=null) {
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(num % 10);
            p = p.next;
            num = num/10;
        }
        if (num == 1)
            p.next = new ListNode(1);
        return result.next;
    }
}