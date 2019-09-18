package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int chance = 0;
        ArrayList<Word> masWords = new ArrayList<>();
        System.out.print("Введите количество слов:");
        int amount = in.nextInt();

        for (int i = 0; i < amount; i++) {
            in.nextLine();
            masWords.add(new Word());
            System.out.printf("Введите %d слово:", i + 1);
            String str = in.nextLine();
            System.out.printf("Введите его вероятность:");
            int c = in.nextInt();
            masWords.get(i).setChance(c);
            masWords.get(i).setWord(str);
            chance = chance + c;
        }
        if (chance != 100) {
            System.out.println("Вероятность не равна 1,ошибка");
        } else {
            AlgHuffman alg = new AlgHuffman();
            for (int i = 0; i <amount ; i++) {
                alg.setTree(masWords.get(i));
            }
            alg.setLength();

            for (int i = amount-1; i >=1 ; i--) {
                for (int j = 0; j < i ; j++) {
                    if(masWords.get(j).getLength() > masWords.get(j+1).getLength()){
                        Word k = masWords.get(j);
                        masWords.set(j,masWords.get(j+1));
                        masWords.set(j+1,k);
                    }
                }
            }

            PreffixAlg preffixAlg = new PreffixAlg(amount);
            for (int i = 0; i < amount ; i++) {
                preffixAlg.setLengthWord(masWords.get(i).getLength());
            }
            preffixAlg.setCode();
            String [] masCode = preffixAlg.getMasCode();
            for (int i = 0; i < amount ; i++) {
                masWords.get(i).setCode(masCode[i]);
            }

            for (int i = 0; i < amount ; i++) {
                System.out.println(masWords.get(i).toString());
            }


        }
    }

}

