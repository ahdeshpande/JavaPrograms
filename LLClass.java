/**
 * Created by ahdeshpande on 10/9/16.
 */

public class LLClass {

    // Count of elements
    private static int iCounter;
    // Head of list
    private NodeClass objHeadNode;

    // Default Constructor
    public LLClass() {

    }

    // List count functions
    public void IncrementCounter() {
        iCounter++;
    }

    public void DecrementCounter() {
        iCounter--;
    }

    public int GetCounter() {
        return iCounter;
    }

    public int Size() {
        return GetCounter();
    }

    // Print list functions
    public String ToString() {
        String strOutput = "";

        if (objHeadNode != null) {
            NodeClass objIterator = objHeadNode.GetNext();
            while (objIterator != null) {
                strOutput += "[" + objIterator.GetData().toString() + "]";
                objIterator = objIterator.GetNext();
            }
        }
        return strOutput;
    }

    // Adds the Node at the end of the list
    public void AddNode(Object objData) {
        // If head node
        if (objHeadNode == null) {
            objHeadNode = new NodeClass(objData);
        }

        NodeClass objNode = new NodeClass(objData);
        NodeClass objIterator = objHeadNode;

        // Iterate through the list to reach the end
        if (objIterator != null) {
            while (objIterator.GetNext() != null) {
                objIterator = objIterator.GetNext();
            }

            // After reaching end, add the node
            objIterator.SetNext(objNode);
        }

        // Increment the counter
        IncrementCounter();
    }

    // Gets the Node Data at the specified Index
    public Object GetNodeData(int iIndex) {
        // Check if Index less than 0
        if (iIndex < 0) {
            return null;
        }

        NodeClass objNode = null;

        // Check if Head is not null
        if (objHeadNode != null) {
            objNode = objHeadNode.GetNext();
            for (int iIterator = 0; iIterator < iIndex; iIterator++) {
                if (objNode.GetNext() == null) {
                    return null;
                }
                objNode = objNode.GetNext();
            }
            return objNode.GetData();
        }
        return objNode.GetData();
    }

    // Removes the Node at at the specified Index
    public boolean RemoveNode(int iIndex) {
        // Check if Index is out of range [0,size]
        if (iIndex < 0 || iIndex > Size())
            return false;

        NodeClass objIterator = objHeadNode;
        if (objHeadNode != null) {
            for (int iIterator = 0; iIterator < iIndex; iIterator++) {
                if (objIterator.GetNext() == null)
                    return false;

                objIterator = objIterator.GetNext();
            }
            objIterator.SetNext(objIterator.GetNext().GetNext());

            // Decrement Counter
            DecrementCounter();
            return true;
        }
        return false;
    }

    // Insert the Node at the specified Index
    public void InsertNode(Object objData, int iIndex)
    {
        NodeClass objNode = new NodeClass(objData);
        NodeClass objIterator = objHeadNode;

        // Check if not null
        if(objIterator !=null)
        {
            // Iterate to the Index
            for(int iIterator=0; iIterator<iIndex && objIterator.GetNext()!=null; iIterator++)
            {
                objIterator = objIterator.GetNext();
            }

            // Set new node's ref to iterator's next ref
            objNode.SetNext(objIterator.GetNext());

            // Set Iterator's net ref to new node
            objIterator.SetNext(objNode);

            // Increment Counter
            IncrementCounter();
        }
    }

}
