package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] objArr;
    public ArrayUtility(T[] inputArray) {
        this.objArr = inputArray;
    }

    public T[] removeValue(T valueToRemove) {
        // find number of times valueToRemove appears in original array
        int count = getNumberOfOccurrences(valueToRemove);

        // setting up new array and index variables
        T[] newArr = (T[]) Array.newInstance(this.objArr.getClass().getComponentType(), this.objArr.length-count);
        int j = 0;
        int i = 0;

        while(i<newArr.length){
            if(this.objArr[j].equals(valueToRemove) ){
                j++;
            }
            else{
                newArr[i] = this.objArr[j];
                j++;
                i++;
            }
        }

        return newArr;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int count = 0;
        for(int i = 0; i < this.objArr.length; i++){
            if(this.objArr[i].equals(valueToEvaluate)){
                count++;
            }
        }

        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        // creating new array of the two arrays to be merged
        T[] newMergedArr = (T[]) Array.newInstance(this.objArr.getClass().getComponentType(), this.objArr.length+arrayToMerge.length);
        System.arraycopy(this.objArr, 0, newMergedArr, 0, this.objArr.length);
        System.arraycopy(arrayToMerge, 0, newMergedArr, this.objArr.length, arrayToMerge.length);

        // setting max as the first value in the array
        T max = newMergedArr[0];
        int currentMax = getNumberOfOccurrences(newMergedArr[0]);

        // looping through the array to find the value with the max number of occurrences
        for(int i = 1; i < newMergedArr.length; i++){
            if(currentMax < getNumberOfOccurrences(newMergedArr[i])){
                currentMax = getNumberOfOccurrences(newMergedArr[i]);
                max = newMergedArr[i];
            }
        }

        return max;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] newMergedArr = (T[]) Array.newInstance(this.objArr.getClass().getComponentType(), this.objArr.length+arrayToMerge.length);
        System.arraycopy(this.objArr, 0, newMergedArr, 0, this.objArr.length);
        System.arraycopy(arrayToMerge, 0, newMergedArr, this.objArr.length, arrayToMerge.length);

        int count = 0;
        for(int i = 0; i < newMergedArr.length; i++){
            if(newMergedArr[i].equals(valueToEvaluate)){
                count++;
            }
        }

        return count;
    }
}
