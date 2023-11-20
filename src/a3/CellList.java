package a3;

public class CellList {
    private CellNode head;
    private int size;

    public class CellNode{
        private CellPhone cellPhone;
        private CellNode cellNode;


        public CellNode getCellNode() {
            return cellNode;
        }

        public CellPhone getCellPhone() {
            return cellPhone;
        }

        public void setCellNode(CellNode cellNode) {
            this.cellNode = cellNode;
        }

        public void setCellPhone(CellPhone cellPhone) {
            this.cellPhone = cellPhone;
        }

        public CellNode(){
            this.cellPhone = null;
            this.cellNode = null;
        }

        public CellNode(CellPhone cp, CellNode cn){
            this.cellPhone = cp;
            this.cellNode = cn;
        }

        public CellNode(CellNode cn){
            this.cellNode = cn.getCellNode();
            this.cellPhone = cn.getCellPhone();
        }

        // TODO: make a clone method
    }

    public void addToStart(CellPhone cellPhone){
        

    }

}
