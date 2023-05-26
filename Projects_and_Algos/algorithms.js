class Node {
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

// node1 = new Node(10);
// // console.log(node1.data);

class SinglyLinkedList {
    constructor(head = null) {
        this.head = head;
    }


//     push(data) {
//         if (this.head === null){
//             this.head = new Node(data);
//             return;
//         }
//         let pointer = this.head;
//         while( pointer.next !== null){
//             pointer = pointer.next;
//         }
//         pointer.next = new Node(data);
//     }

//     pop() {
//         if (this.head === null){
//             return null;
//         }
//         let pointer = this.head;
//         if (pointer.next === null){
//             this.head = null;
//             return pointer.data;
//         }
//         while (pointer.next.next !== null){
//             pointer = pointer.next;
//         }
//         const temp = pointer.next.data;
//         pointer.next = null;
//         return temp;

//     }

    pushToFront(data){
        if (this.head === null){
            this.head = new Node(data);
            return;
        }
        if(this.head != null){
            const temp = this.head;
            this.head = data;
            this.head.next = temp;
        }
    }
}

// class Node {
//     constructor(data){
//         this.data = data;
//         this.next = null;
//     }
// }

// node1 = new Node(10);
// // console.log(node1.data);

// class SinglyLinkedList {
//     constructor(head = null) {
//         this.head = head;
//     }

//     push(data) {
//         if (this.head === null){
//             this.head = new Node(data);
//             return;
//         }
//         let pointer = this.head;
//         while( pointer.next !== null){
//             pointer = pointer.next;
//         }
//         pointer.next = new Node(data);
//     }

//     pop() {
//         if (this.head === null){
//             return null;
//         }
//         let pointer = this.head;
//         if (pointer.next === null){
//             this.head = null;
//             return pointer.data;
//         }
//         while (pointer.next.next !== null){
//             pointer = pointer.next;
//         }
//         const temp = pointer.next.data;
//         pointer.next = null;
//         return temp;

//     }

//     reverse() {
//         if (this.head === null){
//             return null;
//         }
//         let pointer = this.head;
//         let arr = [];
//         arr.push(pointer);
//         while (pointer.next !== null){
//             arr.push(pointer.next);
//             // return arr;
//         }
//         this.head = arr[arr.length()-1]
//         for(i = arr.length()-2; i > 0; i--){
//             pointer.next = arr[i]
//             pointer = pointer.next
//             // return "success!"
//         }
//     }

// }

// class Node
// {
//     constructor(data)
//     {
//         this.data = data;
//         this.left = null;
//         this.right = null;
//     }
// }

// class BinarySearchTree {
//     constructor() {
//         this.root = null;
//     }

//     insert(data) {
//         var newNode = new Node(data);

//         if (this.root === null) {
//             this.root = newNode;
//         }
//         else {
//             this.insertNode(this.root, newNode);
//         }

//         /* you need to call insertNode(node, newNode) at some point */
//     }

//     insertNode(node, newNode) /* node is the current node, newNode is the node to be inserted */ {
//         /* your code goes here */
//         if (newNode.data < node.data){
//             if (node.left === null){
//                 node.left = newNode;
//             }
//             else {
//                 this.insertNode(node.left, newNode);
//             }
//         }
//     }

// }

// const bst = new BinarySearchTree();
// bst.insert(15);
// bst.insert(25);
// bst.insert(10);
// bst.insert(7);
// bst.insert(22);
// bst.insert(17);
// bst.insert(13);
// bst.insert(5);
// console.log(bst.root);

/*
    Node {
        data: 15,
        left: Node {
            data: 10,
            left: Node { data: 7, left: [Node], right: null },
            right: Node { data: 13, left: null, right: null }
        },
        right: Node {
            data: 25,
            left: Node { data: 22, left: [Node], right: null },
            right: null
        }
    }
*/