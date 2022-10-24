package com.coderush2022;
import java.util.Scanner;

public class MightyRing {


    static int[] getInputValues(String input) {
        int[] interInput;
        String[] splitInput = input.split(" ");
        interInput = new int[splitInput.length];
        for (int i = 0;i< splitInput.length;i++) {
            int x = Integer.parseInt(splitInput[i]);
            interInput[i] = x;
        }
        return interInput;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cell playground[][] = new Cell[10][10];
        
        for(int i = 0; i < playground.length; i++) {
        	for(int j = 0; j < playground[i].length; j++) {
        		playground[i][j] = new Cell();
        	}
        }
        int sum;
//        1
        String castleCellInput = scanner.nextLine();
        int[] castleCell = getInputValues(castleCellInput);
//        2
        String prodoCellInput = scanner.nextLine();
        int[] prodoCell = getInputValues(prodoCellInput);
        //        3
        String aCellInput = scanner.nextLine();
        int[] aCell = getInputValues(aCellInput);
        //        4
        String bxCellInput = scanner.nextLine();
        int[] bxCell = getInputValues(bxCellInput);
        //        5
        String byCellInput = scanner.nextLine();
        int[] byCell = getInputValues(byCellInput);
        //        6
        String cxCellInput = scanner.nextLine();
        int[] cxCell = getInputValues(cxCellInput);
        //        7
        String cyCellInput = scanner.nextLine();
        int[] cyCell = getInputValues(cyCellInput);
        //        8
        String dxCellInput = scanner.nextLine();
        int[] dxCell = getInputValues(dxCellInput);
        //        9
        String dyCellInput = scanner.nextLine();
        int[] dyCell = getInputValues(dyCellInput);
        
        sum = 20;
        
//        System.out.println(aCell[0]);
//        System.out.println(aCell[1]);
//        System.out.println(playground[aCell[0]][aCell[1]]);

//        set Cell A 8 ponits
        playground[aCell[0]][aCell[1]].setCellValue(3);
        playground[aCell[0]][aCell[1]].setGuardPoint(8);

//        set B values
        for(int i = 0; i< bxCell.length;i++){
            playground[bxCell[i]][byCell[i]].setCellValue(3);
            playground[bxCell[i]][byCell[i]].setGuardPoint(4);
        }
//        set c values
        for(int i = 0; i< cxCell.length;i++){
            playground[cxCell[i]][cyCell[i]].setCellValue(3);
            playground[cxCell[i]][cyCell[i]].setGuardPoint(3);
        }

//        set d
        //        set c values
        for(int i = 0; i< dxCell.length;i++){
            playground[dxCell[i]][dyCell[i]].setCellValue(3);
            playground[dxCell[i]][dyCell[i]].setGuardPoint(1);
        }

//        set destination
        playground[castleCell[0]][castleCell[1]].setCellValue(2);

        playground[prodoCell[0]][prodoCell[1]].setCellValue(1);

//        set volcano = -1
        playground[9][9].setCellValue(-1);
        
        System.out.println(sum);

    }
}


class Cell {
    int cellValue;
    int guardPoint;

    public void setCellValue(int cellValue) {
        this.cellValue = cellValue;
    }

    public void setGuardPoint(int guardPoint) {
        this.guardPoint = guardPoint;
    }

    public int getCellValue() {
        return cellValue;
    }

    public int getGuardPoint() {
        return guardPoint;
    }
}