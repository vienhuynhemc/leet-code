/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */

class ListNode {
    constructor(val, next) {
        this.val = (val === undefined ? 0 : val);
        this.next = (next === undefined ? null : next);
    }
}

function addNodeToTheLast(root, child) {
    if (root.next != null) {
        addNodeToTheLast(root.next, child);
    } else {
        root.next = child;
    }
}

var addTwoNumbers = function (l1, l2) {
    let result = null;
    let isHandle = false;
    let assistant = 0;
    while (l1 != null || l2 != null) {
        isHandle = true;
        let value = 0;
        if (l1 != null && l2 != null) {
            value = l1.val + l2.val + assistant;
        } else if (l1 != null) {
            value = l1.val + assistant;
        } else if (l2 != null) {
            value = l2.val + assistant;
        }
        assistant = 0;
        if (value > 9) {
            assistant = parseInt(value / 10);
            value = value % 10;
        }
        if (result == null) {
            result = new ListNode(value, null);
        } else {
            addNodeToTheLast(result, new ListNode(value, null));
        }
        if (l1 != null) {
            l1 = l1.next;
        }
        if (l2 != null) {
            l2 = l2.next;
        }
    }
    if (!isHandle) {
        let value = l1.val + l2.val;
        if (value > 9) {
            assistant = parseInt(value / 10);
            value = value - 10;
        }
        result = new ListNode(value, null);
    }
    if (assistant != 0) {
        addNodeToTheLast(result, new ListNode(assistant, null));
    }
    return result;
};

console.log(
    addTwoNumbers(
        new ListNode(
            2,
            new ListNode(
                4,
                new ListNode(
                    3,
                    null
                )
            )
        ),
        new ListNode(
            5,
            new ListNode(
                6,
                new ListNode(
                    4,
                    null
                )
            )
        )
    )
);
console.log(
    addTwoNumbers(
        new ListNode(0, null),
        new ListNode(0, null)
    )
);
console.log(
    addTwoNumbers(
        new ListNode(
            9,
            new ListNode(
                9,
                new ListNode(
                    9,
                    new ListNode(
                        9,
                        new ListNode(
                            9,
                            new ListNode(
                                9,
                                new ListNode(
                                    9,
                                    null
                                )
                            )
                        )
                    )
                )
            )
        ),
        new ListNode(
            9,
            new ListNode(
                9,
                new ListNode(
                    9,
                    new ListNode(
                        9,
                        null
                    )
                )
            )
        )
    )
)