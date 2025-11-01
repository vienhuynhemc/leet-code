/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */

class ListNode {
  constructor(val, next) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

var mergeTwoLists = function (list1, list2) {
  if (list1 == null && list2 == null) {
    return null;
  }
  if (
    list1 != null &&
    list1.val == null &&
    list2 != null &&
    list2.val == null
  ) {
    return null;
  }
  if (
    list1 != null &&
    list2 != null &&
    list1.next == null &&
    list2.next == null &&
    ((list1.val != null && list2.val == null) ||
      (list1.val == null && list2.val != null))
  ) {
    return new ListNode(
      list1.val == null ? 0 : list1.val + list2.val == null ? 0 : list2.val,
    );
  }
  let item1 = list1;
  let item2 = list2;
  let result = null;
  while (item1 != null || item2 != null) {
    let value;
    if (
      item1 != null &&
      item1.val != null &&
      item2 != null &&
      item2.val != null
    ) {
      if (item1.val < item2.val) {
        value = item1.val;
        item1 = item1.next;
      } else {
        value = item2.val;
        item2 = item2.next;
      }
    } else if (item1 != null && item1.val != null) {
      value = item1.val;
      item1 = item1.next;
    } else if (item2 != null && item2.val != null) {
      value = item2.val;
      item2 = item2.next;
    }
    if (result == null) {
      result = new ListNode(value, null);
    } else {
      addNodeToTheLast(result, new ListNode(value, null));
    }
  }
  return result;
};

function addNodeToTheLast(root, child) {
  if (root.next != null) {
    addNodeToTheLast(root.next, child);
  } else {
    root.next = child;
  }
}

console.log(
  mergeTwoLists(
    new ListNode(1, new ListNode(2, new ListNode(4, null))),
    new ListNode(1, new ListNode(3, new ListNode(4, null))),
  ),
);
console.log(mergeTwoLists(new ListNode(null, null), new ListNode(null, null)));
console.log(mergeTwoLists(new ListNode(null, null), new ListNode(0, null)));
console.log(mergeTwoLists(new ListNode(2, null), new ListNode(1, null)));
