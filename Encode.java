package com.coderush2022;

import java.util.Scanner;

public class Encode {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        String[] splited = str.split(" ");

        int i;

        String ans = "";

        for(i = 0; i < splited.length; i++) {
            if(isInteger(splited[i])) {
                if(Integer.parseInt(splited[i]) <= -65 && Integer.parseInt(splited[i]) >= -90 ||Integer.parseInt(splited[i]) <= -97 && Integer.parseInt(splited[i]) >= -122){
                    ans = ans + (char) (Integer.parseInt(splited[i])*(-1)) + 32+ " ";
                }
                else if(Integer.parseInt(splited[i]) == 0) {
                    ans = ans;
                }
                else {
                    ans = ans + (char) (Integer.parseInt(splited[i])*(-1)) + " ";
                }
            }

            else {
                ans = ans + splited[i] + " ";
            }

        }
        System.out.println(ans.trim());

    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

}