package lesson5.HW282623;

import java.util.Arrays;

public class HW {
    public static void main(String[] args) {
        int [] a = {1,2,3,};
        int [] b = {4,5,2,3};
        int [] [] c = new int[][] {
                {1,   3,  5},      // 0
                {4},               // 1
                {-10, 20, -40, 5}  // 2
        };

        System.out.println(Arrays.toString(concat(a,b)));
        System.out.println(Arrays.toString(flatten(c)));

        System.out.println(Arrays.toString(findDuplicates(a,b)));
        System.out.println(Arrays.toString(findUnique(a,b)));


    } //end of main

    //1. Напишите функцию, принимающую на вход два массива целых и возвращающую один массив, содержащий все их элементы
    //public static int [] concat(int [] a, int [] b)
    //Пример: {1,2,3}, {4,5} -> {1,2,3,4,5}

    public static int [] concat(int [] a, int [] b){
       int [] res = new int[a.length + b.length];
       int index = 0;
       for (int i = 0; i < a.length; i++){
           res[index] = a[i];
           index++;


       }
       for (int i = 0; i < b.length; i++){
           res[index] = b[i];
           index++;

       }
       return res;
    }

    //Напишите функцию для "уплощения" передаваемого в нее двухмерного массива.
    //public static int [] flatten(int [] [] a)
    //То есть, если, например, в функцию передается массив {{1,2,3}, {4}} то нужно выдавать массив {1,2,3,4}
    public static int [] flatten(int [] [] a){
        int totallenght = 0;
        for (int i = 0; i < a.length; i++){
            totallenght += a[i].length;
        }
        int [] res = new int[totallenght];
        int index = 0;
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                res[index] = a[i][j];
                index++;
            }
        }
        return res;
    }

    //Напишите функцию, которая найдет в двух массивах одинаковые элементы и вернет их в виде массива
    //(порядок не важен)
    //public static int [] findDuplicates(int [] a, int [] b)
    //Пример: {2,3,1}, {4,5,3,2} -> {2,3}
    //Подумайте над оптимизацией - возможно, предварительная сортировка сможет как-то помочь?
    public static int [] findDuplicates(int [] a, int [] b){
        Arrays.sort(a);
        Arrays.sort(b);
        int [] newArr = concat(a,b);
        int [] arr2 = new int[newArr.length];//TODO[2, 3, 0, 0, 0, 0, 0] вы не могли бы написать в фидбекке как можно было сделать так чтоб выводилось [2, 3] без нулей,спс заранее.
         int index = 0;
           for (int i = 0; i < newArr.length - 1; i++){
               for (int j = i + 1; j < newArr.length; j++){
                   if (newArr[i] == newArr[j]){
                       arr2[index] = newArr[i];
                       index++;
                   }
               }
           }
           int [] res = new int[index];
           for (int i = 0; i < index; i++){
               res[i] = arr2[i];
           }
           return res;
        }

        // Напишите функцию, которая найдет в двух массивах уникальные элементы и вернет их в виде массива
    //(порядок не важен)
    //public static int [] findUnique(int [] a, int [] b)
    //Пример: {2,3,1}, {4,5,3,2} -> {1,4,5}
    //Подумайте над оптимизацией - возможно, предварительная сортировка сможет как-то помочь?
        public static int [] findUnique(int [] a, int [] b){
            Arrays.sort(a);
            Arrays.sort(b);
        int [] newArr = concat(a,b);
        int [] arr2 = new int[newArr.length];
        int index = 0;
        for (int i = 0; i < newArr.length - 1; i++){
            boolean isDuplicate = false;
            for (int j = i + 1; j < newArr.length; j++){
                if (newArr[i] == newArr[j]){
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate){
                if (index < arr2.length){
                    arr2[index] = newArr[i];
                    index++;
                } else {
                    break;
                }
            }
        }

        int [] res = new int[index];
        for (int i = 0 ; i < index; i++){
            res[i] = arr2[i];
        }
        return res;
    }

    }


