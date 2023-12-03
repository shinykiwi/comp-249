package a3;

import java.util.NoSuchElementException;

public class CellList {
    private CellNode head;
    private int size;

    public class CellNode implements Cloneable{
        private CellPhone cellPhone;
        private CellNode next;


        public CellNode getCellNode() {
            return next;
        }

        public CellPhone getCellPhone() {
            return cellPhone;
        }

        public void setNext(CellNode next) {
            this.next = next;
        }

        public void setCellPhone(CellPhone cellPhone) {
            this.cellPhone = cellPhone;
        }

        public CellNode(){
            this.cellPhone = null;
            this.next = null;
        }

        public CellNode(CellPhone cp, CellNode cn){
            this.cellPhone = cp;
            this.next = cn;
        }

        public CellNode(CellNode cn){
            this.next = new CellNode(cn.getCellNode());
            this.cellPhone = new CellPhone(cn.getCellPhone());
        }
        public CellNode clone(){
            return new CellNode(this.cellPhone.clone(), this.clone());
        }

        public String toString(){
            return cellPhone.toString() + " --> " + next;
        }

        public boolean equals(CellNode cellNode){
            if (cellNode.cellPhone.equals(this.cellPhone)){
                if (cellNode.next.equals(this.next)){
                    return true;
                }
            }
            return false;
        }
    }

    public CellList(){
        head = null;
        size = 0;
    }

    public CellList(CellList list){
        this.head = new CellNode(list.head);
        this.size = list.size;
        CellNode temp = head;
        CellNode other = list.head;
        for (int i = 0; i < size; i++){
            temp.next = new CellNode(other);
            temp = temp.next;
            other = other.next;
        }
    }

    public void addToStart(CellPhone cellPhone){

        // Creating a new node, setting its value
        CellNode c = new CellNode();
        c.setCellPhone(cellPhone);

        if (head == null){
            head = c;
        }
        else{
            // Keeping the value of the head pointer
            CellNode temp = head;

            // Setting the head to the new node, and point it's next node to what head originally pointed to
            head = c;
            c.setNext(temp);
        }
        size++;


    }
    public void insertAtIndex(CellPhone cellPhone, int index) throws NoSuchElementException{
        if (index  >= 0 && index <  size){
            // If it's just adding to the start
            if (index == 0){
                addToStart(cellPhone);
            }
            // Adding anywhere else but the start
            else{
                // Creating the new node
                CellNode c = new CellNode();
                c.cellPhone = cellPhone;

                CellNode temp = head;

                for (int i = 0; i < index - 1;i++){
                    temp = temp.next;
                }

                c.setNext(temp.next);
                temp.next = c;
            }
        }
        else {
            throw new NoSuchElementException();
        }

    }

    public void deleteFromStart(){
        CellNode temp = head.next;
        head.next = null;
        head = temp;
        size--;
    }

    public void deleteFromIndex(int index) throws NoSuchElementException{
        if (index >= 0 && index < size){
            if (index == 0){
                deleteFromStart();
            }
            else{
                CellNode temp = head;
                for (int i = 0; i< index -1; i++){
                    temp = temp.next;
                }
                CellNode temp2 = temp.next;
                temp.next = temp2.next;
                temp2.next = null;
                size--;
            }
        }
        else{
            throw new NoSuchElementException();
        }
    }

    public void replaceAtIndex(CellPhone cellPhone, int index){
        if (index >= 0 && index < size){
            CellNode temp = head;
            for (int i = 0; i<index; i++){
                temp = temp.next;
            }

            temp.cellPhone = cellPhone;
        }
        else{
            return;
        }
    }

    public boolean contains(long serialNumber){
        CellNode temp = head;
        for (int i = 0; i < size; i++){
            if (temp.cellPhone.getSerialNum() == serialNumber){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // WARNING: This method may result in a privacy leak because here we are returning a pointer to the node which gives
    // the user access to the entire list following that node -- which poses a risk if the returned node is manipulated to
    // point towards null, causing the rest of the data to be garbage collected and lost
    public CellNode find(long serialNumber){
        CellNode temp = head;
        for (int i = 0; i < size; i++){
            if (temp.cellPhone.getSerialNum() == serialNumber){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void showContents(){
        System.out.println(head);
    }

    public boolean equals(CellList cellList){
        if (cellList.size == size) {
            return cellList.head.equals(this.head); // calls a recursive equals method
        }
        return false;

    }

}
