package com.yukangming.basic;

import java.util.Scanner;
import java.util.*;

public class InterviewCode {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();

            int[][] matrax = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    matrax[i][j] = in.nextInt();
            }

            for (int i = 0; i < n; i++)
                for (int j = i; j < n; j++) {
                    int temp = matrax[i][j];
                    matrax[i][j] = matrax[j][i];
                    matrax[j][i] = temp;
                }

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    System.out.println(matrax[i][j]);
        }

        int n = (int) Math.sqrt(9.0);

    }
