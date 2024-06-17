package wk4;

public class AVL {
   
    

    public void RR(BSTNode v){
        v.right.parent = v.parent;
        v.parent = v.right;
    }

    public void LL(BSTNode v){
        v.left.parent = v.parent;
        v.parent = v.left;
    }

    public void RL(BSTNode v){
        int newValue = v.right.left.value;
        v.left = new BSTNode(v.value);
        v.value = newValue;
        v.right.left = null;
    }


public void LR(BSTNode v){
        int newValue = v.left.right.value;
        v.right= new BSTNode(v.value);
        v.value = newValue;
        v.left.right = null;
    }




    public void sort(){
        
    }




}
