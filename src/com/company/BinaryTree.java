package com.company;

public class BinaryTree {
    private Word root;
    private BinaryTree leftChild;
    private BinaryTree rightChild;

    public BinaryTree(){
        root = new Word();
        leftChild=null;
        rightChild=null;
    }

    public BinaryTree(Word root){
        this.root = root;
    }
    public void addChild(BinaryTree newWord){
        if(leftChild==null){
            leftChild=newWord;
        }
        else{
            if(leftChild.getChance()<=newWord.getChance()){
                rightChild=newWord;
            }
            else{
                rightChild=leftChild;
                leftChild=newWord;
            }
        }
    }

    public BinaryTree getLeftChild() {
        return leftChild;
    }

    public BinaryTree getRightChild() {
        return rightChild;
    }

    public void setLeftChild(BinaryTree leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryTree rightChild) {
        this.rightChild = rightChild;
    }
    public void setRoot(Word root){
        this.root = root;
    }

    public int getChance(){
        return root.getChance();
    }

    public void setChance(int value){
        root.setChance(value);
    }

    public Word getRoot(){
        return root;
    }
}
