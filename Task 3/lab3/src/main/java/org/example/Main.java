package org.example;

public class Main {
    static long sum = 0;

    public static void main(String[] args) {
        String[][] array1 =
        {
            {"7", "7", "7", "7"},
            {"7", "7", "7", "7"},
            {"7", "7", "7", "7"},
            {"7", "7", "7", "7"}
        };

        int[] fibbo = new int[17];
        fibbo[0] = 0;
        fibbo[1] = 1;

        for (int i = 2; i < fibbo.length; i++){
            fibbo[i] = fibbo[i-2] + fibbo[i-1];
        }

        test(array1, fibbo);
    }

    static void test (String[][] array, int[] fibbo){
        int arrRow = array.length;
        int arrColl = array[0].length;

        boolean flag = true;

        if(array.length == 4){
            for (int i = 0; i < arrColl; i++){
                if(array[i].length != 4) {
                    flag = false;
                    break;
                }
            }
        } else flag = false;



        try {
            if(flag){
                for (int i = 0; i < arrRow; i++){
                    for (int j = 0; j < arrColl; j++){
                        try{
                            sum += Integer.valueOf(array[i][j]);
                        }catch (NumberFormatException e){
                            throw new MyArrayDataException(i, j, array[i][j]);
                        }
                    }
                }
            }else{
                throw new MyArraySizeException("Неккоректный размер массива!");
            }
            if(countFibbo(arrRow, arrColl, array, fibbo))
                System.out.println("Сумма элементов массива: " + sum);

        }catch (MyArrayDataException e){
            e.printStackTrace();

        }catch (MyArraySizeException e){
            e.printStackTrace();
        }

    }
    static boolean countFibbo(int arrRow, int arrColl, String[][] array, int[] fibbo){
        boolean flag = true;
        for(int i = 0; i < arrRow; i++){
            for (int j = 0; j < arrColl; j++){
                for (int k = 0; k < fibbo.length; k++){
                    try{
                        if(fibbo[k] == Integer.valueOf(array[i][j])){
                            throw new MyFibonacciException(i+1, j+1, fibbo[k]);
                        }
                    }catch(MyFibonacciException e){
                        flag = false;
                        e.printStackTrace();
                    }
                }
            }
        }
        return flag;
    }
}