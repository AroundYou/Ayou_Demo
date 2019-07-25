package com.example.RJRJ.controller;


import java.util.*;

public class Main {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static ListNode mergeKLists(ListNode[] lists) {
        // TODO 请在此处填写你的代码，也可以选择不用此模板自己编写
        ListNode node = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode nodeSort = lists[i];
            sort(node, nodeSort);
        }
        return node;
    }

    public static void sort(ListNode a, ListNode b){
         ListNode c = a;
        ListNode d = new ListNode(-1);
        while(b != null){
            while(c != null){
                if(b.val >= c.val){
                    d = c;
                    c = c.next;
                }else{
                    ListNode bb = new ListNode(b.val);
                  //  if(c.next != null)
                        bb.next = d.next;
                    if(d.val > 0) {
                        d.next = bb;
                    }
                    c=c.next;
                    break;
                }
            }
            b = b.next;
        }
            
         
    }
    
    static ListNode string2ListNode(String str) {
        StringTokenizer token = new StringTokenizer(str, ",");
        ListNode head, foot;
        head = foot = new ListNode(0);
        while(token.hasMoreTokens()) {
            int val = Integer.parseInt(token.nextToken());
            foot = foot.next = new ListNode(val);
        }
        return head.next;
    }

    static String listNode2String(ListNode listNode) {
        StringBuilder result = new StringBuilder();
        while (listNode != null) {
            result.append(listNode.val).append(",");
            listNode = listNode.next;
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<ListNode> list = new ArrayList<>();
        while (!input.hasNext("error")) {
            list.add(string2ListNode(input.next()));
        }
        ListNode[] listNode = list.toArray(new ListNode[list.size()]);
        System.out.print(listNode2String(mergeKLists(listNode)));
    }

}
