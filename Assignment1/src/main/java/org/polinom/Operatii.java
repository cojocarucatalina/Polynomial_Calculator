package org.polinom;

import GUI.MainFrame;

import java.util.*;

public class Operatii {


    public static Polinom Adunare(Polinom p, Polinom q) {

        Polinom result = new Polinom("");

        for (Integer key : p.keySet()) {
            if (q.containsKey(key)) {
                result.put(key, p.get(key) + q.get(key));
                q.remove(key);
            } else result.put(key, p.get(key));
        }

        for (Integer key : q.keySet()) result.put(key, q.get(key));

         MainFrame.set(result);
         System.out.println(result.toString());
        return result;
    }

    public static Polinom Scadere(Polinom p, Polinom q){

        Polinom result = new Polinom("");

        for (Integer key : q.keySet()) {
            int valoare=q.get(key);
            q.setValue(key,-valoare);
        }

        result=Operatii.Adunare(p,q);
//        for (Integer key : p.keySet()) {
//            if (q.containsKey(key)) {
//                result.put(key,p.get(key) - q.get(key));
//                q.remove(key);
//            } else
//                result.put(key, p.get(key));
//        }
//        for (Integer key : q.keySet()) {
//            result.put(key, q.get(key));
//        }
        MainFrame.set(result);
        return result;
    }

    public static Polinom Inmultire(Polinom p, Polinom q){

        Polinom result = new Polinom("");
        for (Integer i : p.keySet()){
            for( Integer j : q.keySet()){
                if(!result.containsKey(i+j)) {
                    result.put(i+j, p.get(i)*q.get(j));
                }
                else {   int var=result.get(i+j);
                  //  Integer cheie = i + j;
                    Integer value = p.get(i) * q.get(j);
                    value+=var;
                    result.put(i+j, value);
                }
            }
        }
        MainFrame.set(result);
        return result;

    }

    public static Polinom Impartire(Polinom p, Polinom q){

        Polinom rezult = new  Polinom("");
        Polinom temp = new  Polinom("");
        if (p==null || q==null)  {MainFrame.set(""); return rezult;}
        Integer degreeP=Collections.max(p.keySet());
        Integer degreeQ=Collections.max(q.keySet());
        if (degreeQ > degreeP) {
            rezult.put(0,0);
            MainFrame.set(rezult.toString());
            return rezult;}
        if(q.get(degreeQ).equals(0)) {MainFrame.set("Impartire cu 0"); return rezult;}
        if(degreeQ.equals(0) && q.get(degreeQ).equals(0) ) {MainFrame.set("Impartire cu 0"); return rezult;}
        if(degreeQ.equals(0) && !q.get(degreeQ).equals(0) ) {degreeQ++;}

            while (degreeP >= degreeQ) {
                int tempCoeff=0;
                try{
                tempCoeff = p.get(degreeP) / q.get(degreeQ);}
                catch(NullPointerException e) {MainFrame.set(rezult); return rezult;}
                int tempPower = degreeP - degreeQ;
                temp.put(tempPower, tempCoeff);
                rezult = Operatii.Adunare(rezult, temp);
                p= Operatii.Scadere(p, Operatii.Inmultire(q,temp));
                p.remove(degreeP);
                try{
                degreeP=Collections.max(p.keySet());}
                catch (NoSuchElementException e){MainFrame.set(rezult); return rezult;}
           }
        String imp= new String(" ");
        imp=rezult.toString()+", rest "+p.toString();
        MainFrame.set(imp);
        return rezult;
     }


    public static Polinom Derivare(Polinom p){

        Polinom result= new Polinom("");
        for (Integer i: p.keySet()) {
            int coef = p.get(i) * i;
            if(i>0) result.put(i-1,coef);
        }
        MainFrame.set(result);
        return result;
    }
    public static Polinom Integrare(Polinom p){

        Polinom result= new Polinom("");
        for (Integer i: p.keySet()) {
            int coef = p.get(i)/(i+1);
           result.put(i+1,coef);
        }
        MainFrame.set(result);
        return result;
    }
}
