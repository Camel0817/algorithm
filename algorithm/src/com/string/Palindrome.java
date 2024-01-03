package com.string;

class Palindrome {
    /*
     *   팰린드롬이란..
     *       앞뒤가 똑같은 단어나 문장으로,
     *       뒤집어도 같은 말이 되는 단어 또는 문장을 팰린드롬이라고한다.
     *       우리말로는 회문이라 부르며,
     *       문장 중에서는 대표적으로 '소주 만 병만 주소' 같은 문장이 이에 해당한다.
     * */

    public static void main(String[] args) {
        String s = "Do geese see God?";

        boolean isPalindrome;

        isPalindrome = palindrome01(s);
        System.out.println(isPalindrome);

        isPalindrome = false;

        isPalindrome = palindrome02(s);
        System.out.println(isPalindrome);
    }

    /*
    *  처음과 끝을 비교해서 회문인지 판독
    *   사용한 것
    *       String.charAt(int index) return char
    *       Character.isLetterorDigit(char c) return boolean
    *       Character.toLowerCase(char c) return char
    * */
    private static boolean palindrome01(String s) {
        int start = 0;
        int end = s.length() - 1;
        boolean isPalindrome = true;
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                } else {
                    start++;
                    end--;
                }
            }
        }
        return true;
    }

    /*
    * 정규식과 StringBuilder을 이용한 회문 판독
    *   사용한 것
    *       정규식 : [^A-Za-z0-9]
    *       new StringBuilder(String)
    *       StringBuilder.reverse(String) return StringBuilder
    *       String.toLowerCase() return String
    *       toString() return String
    *
    *       코드가 간결해졌지만,
    *       01번의 원시자료형을 사용한 비교보다
    *       클래스를 직접 뵤기하는 풀이는 실행속도가 느리다
    *       정규식까지 사용해 속도 저하가 매우 크다.
    * */
    private static boolean palindrome02(String s) {

        String s_filtered = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();

        String s_reversed = new StringBuilder(s_filtered).reverse().toString();

        return s_filtered.equals(s_reversed);

    }
}
