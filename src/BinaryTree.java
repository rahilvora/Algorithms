//import apple.laf.JRSUIUtils;
//
//import java.util.Stack;
//
///**
// * Created by rahilvora on 6/23/16.
// */
//
//public class BinaryTree {
//    TreeNode root;
//    BinaryTree(){
//        root = null;
//    }
//
//    public static void main(String[] args){
//
//        BinaryTree object =  new BinaryTree();
//        object.insertNode(12);
//        object.insertNode(5);
//        object.insertNode(3);
//        object.insertNode(7);
//        object.insertNode(1);
//        object.insertNode(9);
//        object.insertNode(15);
//        object.insertNode(13);
//        object.insertNode(17);
//        object.insertNode(19);
//        object.max();
//        object.min();
//
////        TreeNode temp = object.searchI(18);
////        System.out.println(temp.key);
////
////        TreeNode result = object.searchR(object.root, 18);
////        System.out.println(result.key);
//
////        object.preOrderTraversalR(object.root);
////        System.out.println();
////        object.preOrderTraversalI(object.root);
////        System.out.println();
//
////        object.inOrderTraversalR(object.root);
////        System.out.println();
////        object.inOrderTraversalI(object.root);
////        System.out.println();
//
//        object.postOrderTraversalR(object.root);
//        System.out.println();
//        object.postOrderTraversalI(object.root);
//        System.out.println();
//        object.deleteNode(object.root, 15);
//        object.postOrderTraversalI(object.root);
//
//
//    }
//    public void insertNode(int a ){
//        TreeNode newNode = new TreeNode(a, null, null, null);
//        TreeNode temp1,temp2;
//
//        temp1 = null;
//        temp2 = root;
//
//        while(temp2 != null){
//            temp1 = temp2;
//            if(newNode.key < temp2.key){
//                temp2 = temp2.leftChild;
//            }
//            else {
//                temp2 = temp2.rightChild;
//            }
//        }
//        newNode.parent = temp1;
//        if(temp1 == null){
//            root = newNode;
//        }
//        else if( newNode.key < temp1.key){
//            temp1.leftChild = newNode;
//        }
//        else{
//            temp1.rightChild = newNode;
//        }
//
//    }
//    public void min(){
//
//        TreeNode temp = root;
//        while(temp.leftChild != null){
//            temp = temp.leftChild;
//        }
//        System.out.println(temp.key +" Min Data");
//
//    }
//    public void max(){
//        TreeNode temp = root;
//        while(temp.rightChild != null){
//            temp = temp.rightChild;
//        }
//        System.out.println(temp.key +" Max Data");
//
//    }
//
//    public  TreeNode searchR(TreeNode temp, int a){
//        if(temp == null || temp.key == a){
//            return temp;
//        }else if(temp.key > a){
//            return searchR(temp.leftChild, a);
//        }
//        else {
//            return searchR(temp.rightChild,a);
//        }
//    }
//
//    public TreeNode searchI(int a){
//        TreeNode temp = root;
//
//        while(temp != null && temp.key != a){
//           if(temp.key < a){
//                temp = temp.rightChild;
//           }
//           else{
//                temp = temp.leftChild;
//           }
//        }
//        return temp;
//    }
//
//    public void preOrderTraversalR(TreeNode node){
//        if(node == null){
//            return;
//        }
//        else {
//            System.out.print(node.key +" ");
//            preOrderTraversalR(node.leftChild);
//            preOrderTraversalR(node.rightChild);
//        }
//    }
//    public void preOrderTraversalI(TreeNode root){
//        if(root == null){
//            return;
//        }
//        Stack s =  new Stack();
//        s.push(root);
//        while (!s.empty()){
//            TreeNode node = (TreeNode)  s.pop();
//            System.out.print(node.key + " ");
//            if(node.rightChild != null){
//                s.push(node.rightChild);
//            }
//            if(node.leftChild != null){
//                s.push(node.leftChild);
//            }
//        }
//
//    }
//    public void inOrderTraversalR(TreeNode node){
//        if(node == null){
//            return;
//        }
//        else{
//            inOrderTraversalR(node.leftChild);
//            System.out.print(node.key + " ");
//            inOrderTraversalR(node.rightChild);
//        }
//    }
//    public void inOrderTraversalI(TreeNode node){
//        Stack s = new Stack();
//        while(!s.empty() || node != null){
//            if(node != null){
//                s.push(node);
//                node = node.leftChild;
//            }
//            else{
//                node = (TreeNode) s.pop();
//                System.out.print(node.key + " ");
//                node = node.rightChild;
//            }
//        }
//
//    }
//    public void postOrderTraversalR(TreeNode node){
//        if(node == null){
//            return;
//        }
//        else{
//            postOrderTraversalR(node.leftChild);
//            postOrderTraversalR(node.rightChild);
//            System.out.print(node.key + " ");
//        }
//    }
//    public void postOrderTraversalI(TreeNode node){
//        Stack s = new Stack();
//        TreeNode lastVisitedNode = null;
//        TreeNode peekNode = null;
//        while(!s.empty() || node != null){
//            if(node != null){
//                s.push(node);
//                node = node.leftChild;
//            }
//            else{
//                peekNode = (TreeNode) s.peek();
//                if(peekNode.rightChild != null && lastVisitedNode != peekNode.rightChild){
//                    node = peekNode.rightChild;
//                }
//                else {
//                    System.out.print(peekNode.key + " ");
//                    lastVisitedNode = (TreeNode) s.pop();
//                }
//            }
//        }
//    }
//
//    public TreeNode deleteNode(TreeNode root, int key){
//        if(root == null){
//            return root;
//        }
//        else if(key < root.key){
//            root.leftChild = deleteNode(root.leftChild, key);
//        }
//        else if(key > root.key){
//            root.rightChild = deleteNode(root.rightChild, key);
//        }
//        else{
//            // No child
//            if(root.leftChild == null && root.rightChild == null){
//                root = null;
//            }
//            //only right child
//            else if(root.leftChild == null){
//                root = root.rightChild;
//            }
//            //only left child
//            else if(root.rightChild == null){
//                root = root.leftChild;
//            }
//            //Two children
//            else{
//                TreeNode successor = findMin(root.rightChild);
//                root.key = successor.key;
//                root.rightChild = deleteNode(root.rightChild, successor.key);
//            }
//        }
//        return root;
//    }
//    public static TreeNode findMin(TreeNode root){
//        if(root == null){
//            return root;
//        }
//        TreeNode temp = root;
//        while(temp.leftChild != null){
//            temp = temp.leftChild;
//        }
//        return temp;
//    }
//}
//class TreeNode{
//    int key;
//    TreeNode parent;
//    TreeNode leftChild;
//    TreeNode rightChild;
//    TreeNode(){
//        key = 0;
//        leftChild = null;
//        rightChild = null;
//    }
//    TreeNode(int key, TreeNode parent,TreeNode leftChild, TreeNode rightChild){
//        this.key = key;
//        this.leftChild = leftChild;
//        this.rightChild = rightChild;
//    }
//}