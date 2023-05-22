class Node {
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

node1 = new Node(10);
// console.log(node1.data);

class SinglyLinkedList {
    constructor(head = null) {
        this.head = head;
    }

    push(data) {
        if (this.head === null){
            this.head = new Node(data);
            return;
        }
        let pointer = this.head;
        while( pointer.next !== null){
            pointer = pointer.next;
        }
        pointer.next = new Node(data);
    }

    pop() {
        if (this.head === null){
            return null;
        }
        let pointer = this.head;
        if (pointer.next === null){
            this.head = null;
            return pointer.data;
        }
        while (pointer.next.next !== null){
            pointer = pointer.next;
        }
        const temp = pointer.next.data;
        pointer.next = null;
        return temp;

    }

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

class Node {
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

node1 = new Node(10);
// console.log(node1.data);

class SinglyLinkedList {
    constructor(head = null) {
        this.head = head;
    }

    push(data) {
        if (this.head === null){
            this.head = new Node(data);
            return;
        }
        let pointer = this.head;
        while( pointer.next !== null){
            pointer = pointer.next;
        }
        pointer.next = new Node(data);
    }

    pop() {
        if (this.head === null){
            return null;
        }
        let pointer = this.head;
        if (pointer.next === null){
            this.head = null;
            return pointer.data;
        }
        while (pointer.next.next !== null){
            pointer = pointer.next;
        }
        const temp = pointer.next.data;
        pointer.next = null;
        return temp;

    }

    reverse() {
        if (this.head === null){
            return null;
        }
        let pointer = this.head;
        let arr = [];
        arr.push(pointer);
        while (pointer.next !== null){
            arr.push(pointer.next);
            // return arr;
        }
        this.head = arr[arr.length()-1]
        for(i = arr.length()-2; i > 0; i--){
            pointer.next = arr[i]
            pointer = pointer.next
            // return "success!"
        }
    }

}