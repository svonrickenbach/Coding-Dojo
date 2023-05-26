class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class SLL {
    constructor(head = null) {
        this.head = head;
    }

    // Add Front
    addFront(data) {
        if (this.head === null) {
            this.head = new Node(data);
            return this.head;
        }
        if (this.head !== null) {
            const temp = this.head;
            this.head = new Node(data);
            this.head.next = temp;
            return this.head;
        }
    }

    // Remove Front
    removeFront() {
        if (this.head === null) {
            return null;
        }
        if (this.head !== null) {
            const temp = this.head;
            this.head = this.head.next;
            return this.head;
        }
    }

    // Front
    front() {
        if (this.head === null) {
            return null;
        }
        if (this.head !== null) {
            return this.head.data;
        }
    }
}

const SLL1 = new SLL()
// console.log(SLL1);
console.log(SLL1.addFront(18));
console.log(SLL1.addFront(5));
console.log(SLL1.addFront(73));
console.log(SLL1.removeFront());
console.log(SLL1.removeFront());
console.log(SLL1.front());