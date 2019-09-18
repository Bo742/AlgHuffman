package com.company;

public class PreffixAlg {
    private int[] masLength;
    private String[] masCode;
    private int amountWord;
    private int elem ;

    public PreffixAlg(int amount){
        amountWord=amount;
        masLength=new int[amountWord];
        masCode = new String[amountWord];
        for (int i = 0; i <amount ; i++) {
            masCode[i] = "";
        }
        elem=0;
    }

    public void setLengthWord(int value){
        masLength[elem]=value;
        elem++;
    }

    public void setFirstWord(){
        for (int i = 0; i < masLength[0]; i++) {
            masCode[0]=masCode[i]+0;
        }
    }

    public void setCode(){
        setFirstWord();
        for (int i = 1; i < amountWord ; i++) {
            if(masCode[i-1].equals("Error")){
                break;
            }

            masCode[i] = Integer.toBinaryString(Integer.parseInt(masCode[i-1],2)+Integer.parseInt("1",2));

            String[] masSymbols = masCode[i].split("");
            int currentLengthCode = masSymbols.length;
            if(currentLengthCode != masLength[i]){
                if(masLength[i-1] == masLength[i]){
                    for (int j = 0; j < masLength[i]-currentLengthCode; j++) {
                        masCode[i]=0+masCode[i];
                    }
                }
                else{
                    for (int j = 0; j < masLength[i]-currentLengthCode; j++) {
                        masCode[i]=masCode[i]+0;
                    }
                }
            }
            if(masCode[i].length()>masLength[i]){
                masCode[i]="Error";
            }

        }
    }

    public String[] getMasCode(){
        return masCode;
    }

}
