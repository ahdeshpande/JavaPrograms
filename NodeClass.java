/**
 * Created by ahdeshpande on 10/9/16.
 */

class NodeClass {
    // Reference to next node
    NodeClass objNext;

    // Data
    Object objData;

    // Constructor
    public NodeClass(Object objValue) {
        objNext = null;
        objData = objValue;
    }

    // Constructor
    public NodeClass(NodeClass objNextNode, Object objValue) {
        objNext = objNextNode;
        objData = objValue;
    }

    // Get Value Functions
    public Object GetData() {
        return objData;
    }

    public NodeClass GetNext() {
        return objNext;
    }

    // Set Value Functions
    public void SetData(Object objValue) {
        objData = objValue;
    }

    public void SetNext(NodeClass objNextNode) {
        objNext = objNextNode;
    }
}