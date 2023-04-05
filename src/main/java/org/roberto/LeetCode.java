package org.roberto;

import java.util.HashMap;

class LeetCode {

    static class Pair<X, Y, K> {
        protected X index;
        protected Y duplicated;
        protected K secondArrayValue;

        protected Pair(X index, Y duplicated, K secondArrayValue) {
            this.index = index;
            this.duplicated = duplicated;
            this.secondArrayValue = secondArrayValue;
        }
    }


    public static void main(String[] args) {
        System.out.println("Resultado final: " + isIsomorphic("egcd", "adfd"));
    }

    private static void executeLogic(int i, String first, String second, HashMap firstMap) {
        var firstArrayduplicated = firstMap.containsKey(first.toCharArray()[i]);
        if ((i + 1) < first.length()) {
            if (first.toCharArray()[i] != first.toCharArray()[i + 1]) {
                firstMap.put(first.toCharArray()[i], new Pair(i, firstArrayduplicated, second.toCharArray()[i]));
            }
        } else {
            firstMap.put(first.toCharArray()[i], new Pair(i, firstArrayduplicated, second.toCharArray()[i]));
        }
    }

    private static boolean sameLatterInDiferrentPositionsReturnFalse(String first, String second) {
        var isIsomorphic = true;
        var firstMap = new HashMap<Character, Pair<Integer, Boolean, Character>>();
        for (var i = 0; i < first.length(); i++) {
            executeLogic(i, first, second, firstMap);
        }
        for (var entry : firstMap.entrySet()) {
            if (entry.getValue().duplicated) {
                for (var i = 0; i < first.length(); i++) {
                    if (first.toCharArray()[i] == entry.getKey()) {
                        if (second.toCharArray()[i] != entry.getValue().secondArrayValue) {
                            System.out.println("1: " + first.toCharArray()[i]);
                            System.out.println("2: " + entry.getValue().secondArrayValue);
                            isIsomorphic = false;
                        }
                    }
                }
            }
        }
        return isIsomorphic;
    }

    private static boolean executeIsIsomorphic(String s, String t) {
        var isIsomorphic = true;
        var map = new HashMap<Character, Pair<Integer, Boolean, Character>>();
        for (var i = 0; i < s.length(); i++) {
            System.out.println(s.toCharArray()[i]);
            System.out.println("I: " + i);
            System.out.println("Length: " + s.length());
            if ((i + 1) < s.length() && s.toCharArray()[i] == s.toCharArray()[i + 1]) {
                if (!map.containsKey(s.toCharArray()[i])) {
                    map.put(s.toCharArray()[i], new Pair(i, true, t.toCharArray()[i]));
                }
                if (t.toCharArray()[i] != t.toCharArray()[i + 1] ||
                        t.toCharArray()[i] != map.get(s.toCharArray()[i]).secondArrayValue) {
                    System.out.println("Colocou false 2");
                    isIsomorphic = false;
                }
            }
        }
        if (isIsomorphic) {
            isIsomorphic = sameLatterInDiferrentPositionsReturnFalse(s, t);
        }
        return isIsomorphic;
    }

    public static boolean isIsomorphic(String s, String t) {
        System.out.println(s);
        System.out.println(t);
        var isIsomorphic = true;
        isIsomorphic = executeIsIsomorphic(s, t);
        if (isIsomorphic) {
            isIsomorphic = executeIsIsomorphic(t, s);
        }
        return isIsomorphic;
    }

}