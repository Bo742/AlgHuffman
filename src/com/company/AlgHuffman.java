package com.company;

import java.util.ArrayList;

public class AlgHuffman {
    private ArrayList<BinaryTree> listTree;

    public AlgHuffman(){
        listTree = new ArrayList<BinaryTree>();
    }

    public void setTree(Word root){
        listTree.add(new BinaryTree());
        listTree.get(listTree.size()-1).setRoot(root);
    }

    public void setLength(){
        createTree();
        BinaryTree maxTree = listTree.get(listTree.size()-1);
        maxTree.getRoot().setLength(0);
        maxTree.getLeftChild().getRoot().setLength(1);
        maxTree.getRightChild().getRoot().setLength(1);
        for (int i = listTree.size()-2; i >= 0 ; i--) {
            BinaryTree binaryTree = listTree.get(i);
            if(binaryTree.getLeftChild()!=null){
                binaryTree.getLeftChild().getRoot().setLength(binaryTree.getRoot().getLength()+1);
                binaryTree.getRightChild().getRoot().setLength(binaryTree.getRoot().getLength()+1);
            }
        }
    }

    public void createTree(){
        PriorityQueue queue = new PriorityQueue();
        for (int i = 0; i < listTree.size(); i++) {
            queue.insert(listTree.get(i));
        }
        int nElems=queue.getElems();
        while (nElems>1){
            listTree.add(new BinaryTree());
            listTree.get(listTree.size()-1).setRoot(new Word());
            BinaryTree firstChild = queue.remove();
            BinaryTree secondChild = queue.remove();
            listTree.get(listTree.size()-1).addChild(firstChild);
            listTree.get(listTree.size()-1).addChild(secondChild);
            listTree.get(listTree.size()-1).setChance(firstChild.getRoot().getChance()+secondChild.getRoot().getChance());
            queue.insert(listTree.get(listTree.size()-1));
            nElems = queue.getElems();
        }
    }

}
