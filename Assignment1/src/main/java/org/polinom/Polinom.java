package org.polinom;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

    private HashMap<Integer, Integer> terms = new HashMap<>();

    public Polinom(String string) {

        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(string);
        Integer x = 0;
        while (matcher.find()) {
            x = x + 1;
            String stringulet = new String(matcher.group(1));

            int value = getPower(stringulet);

            if (x.equals(1)) {
                terms.put(value, getCoef(stringulet));
                if (stringulet.charAt(stringulet.length() - 1) == 'x') {

                    terms.remove(value);
                    terms.put(1, getCoef(stringulet));

                } else terms.put(value, getCoef(stringulet));
            } else {

                terms.put(value, getCoef(stringulet));

                if (stringulet.charAt(stringulet.length() - 1) == 'x') {

                    terms.remove(value);
                    terms.put(1, getCoef(stringulet));

                } else terms.put(value, getCoef(stringulet));

            }
        }

        System.out.println(terms);
    }


    public static Integer getCoef(String s) {
        String pattern = "([+-]?\\d*)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(s);
        Integer i = null;
        Integer sign = 1;
        if (m.find()) {
            String u = m.group(1);
            if (u == null) return 1;
            if (u == "-") return -1;
           try{ i = Integer.parseInt(u);}
           catch (NumberFormatException e){ i=1; }
        }

        return i;
    }


    public static Integer getPower(String s) {
        Integer i = null;
        int index = s.lastIndexOf("^");
        if (index >= 0) {
            String pwr = s.substring(index + 1);
            try {
                i = Integer.parseInt(pwr);
            } catch (NumberFormatException e) {
            }
        } else {
            if (s.equals("x")) i = 1;
            else i = 0;
        }
        return i;
    }

    public boolean containsKey(Integer key) {

        return terms.containsKey(key);
    }

    public Integer get(Integer key) {
        return terms.get(key);
    }

    public void remove(Integer key) {
        terms.remove(key);
    }

    public Set<Integer> keySet() {
        return terms.keySet();
    }

    public Set<Integer> keySorted(){
        Map<Integer, Integer> sorted = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        sorted.putAll(terms);
        return terms.keySet();
    }

    public void put(Integer key, Integer i) {
        terms.put(key, i);
    }

    public String toString() {

        StringBuilder s = new StringBuilder();
        boolean prim = true;
        for (Integer i : terms.keySet()) {
            int power = i;
            int coef = get(i);
            if (coef == 0) continue;
            if (prim) {
                prim = false;
                if (coef < 0) {
                    s.append("-");
                    coef = -coef;
                }
            } else {
                s.append(coef < 0 ? "-" : "+");
                coef = Math.abs(coef);
            }
            if (coef != 1 || power == 0) s.append(coef);
            if (power > 0) {
                s.append("x");
                if (power > 1) s.append("^").append(power);
            }
        }
        if (prim) s.append("0");
        return s.toString();
    }

    public int getOrDefault(int i, int i1) { //returns the value to which the specified key is mapped

        Integer value = terms.get(i);
        return (value != null) ? value : i1;
    }

    public int size() {
        return terms.size();
    }

    public int[] getCoefficients() {
        int degree= Collections.max(terms.keySet());
        int[] coeff= new int[degree+1];
        for (int i=0;i<=degree;i++){
            coeff[i]=terms.getOrDefault(i,0);
        }
        return coeff;
    }

//    public int[] getPower() {
//        int degree= Collections.max(terms.keySet());
//        int[] powers = new int [degree+1];
//        for (int i=0;i<=degree;i++){
//            powers[i]=i;
//        }
//        return powers;
//    }


    public void setValue(int key, int i) {
        terms.put(key,i);
    }
}