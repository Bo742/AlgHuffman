package com.company;

public class Word {
    private String word;
    private int chance;
    private int length;
    private String code;


    public Word(){
        length=0;
        code="";
    }


    public void setWord(String value){
        word = value;
    }

    public void setChance(int value){
        chance = value;
    }

    public void setLength(int value){
        length = value;
    }

    public void setCode(String value){
        code = value;
    }

    public String getWord() {
        return word;
    }

    public int getChance() {
        return chance;
    }

    public int getLength() {
        return length;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString(){
        String str = "Word:"+word+", chance:"+chance+", length:"+length+", code:" + code;
        return str;
    }
}
