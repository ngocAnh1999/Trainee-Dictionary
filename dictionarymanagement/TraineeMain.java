/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionarymanagement;

import java.util.Scanner;

/**
 *
 * @author Admin: huyengocao
 */
public class TraineeMain {
    public static void main(String[] args) {
                System.out.println("Welcom to dictionary look up!");
                DictionaryCommandline dicC = new DictionaryCommandline();
                dicC.dictionaryAdvanced();
    }

}