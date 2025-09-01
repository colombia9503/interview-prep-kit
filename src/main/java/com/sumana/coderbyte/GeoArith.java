package com.sumana.coderbyte;

public class GeoArith {

    public static String ArithGeo(int[] arr) {
        String result = "-1";

        int geoPattern = arr[1] / arr[0];
        int arithPattern = arr[1] - arr[0];


        for (int i = 2; i < arr.length; i++) {
            int currGeoPattern = arr[i] / arr[i - 1];
            int currArithPattern = arr[i] - arr[i - 1];

            if (currArithPattern == arithPattern) {
                result = "Arithmetic";
            } else if (currGeoPattern == geoPattern) {
                result = "Geometric";
            } else {
                return "-1";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(ArithGeo(new int[] {1,2,3,4,5,10,20}));
    }
}
