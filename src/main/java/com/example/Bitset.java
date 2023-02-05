package com.example;

public class Bitset {

  private final static int intSize = 64;
  private final long[] data;
  private final int size;

  Bitset(int size) {
    this.size = size;
    this.data = new long[(size + intSize - 1) / intSize];
  }

  // set Function
  public void setFunction(int index) {
    int intIndex = index / intSize;     //intindex is a index of the int in the bits array
    int bitIndex = index % intSize;     //bitIndex is a changeable bit
    data[intIndex] |= 1L << bitIndex;
    //Փոփոխվող բիթի ինդեքսը կամ է անում հիմնական տարրի ինդեքսի հետ
  }

  //reset Function
  public void resetFunction(int index) {
    int intIndex = index / intSize;     //intindex is a index of the int in the bits array
    int bitIndex = index % intSize;     //bitIndex is a changeable bit
    data[intIndex] &= 1L << bitIndex;
    //Փոփոխվող բիթի ինդեքսը ԵՎ է անում հիմնական տարրի ինդեքսի հետ
  }

  public boolean getFunction(int index) {
    int intIndex = index / intSize;      //intindex is a index of the int in the bits array
    int bitIndex = index / intSize;      //bitIndex is a changeable bit
    return (data[intIndex] & (1L << bitIndex)) != 0;
  }

  public int size() {
    return size;
  }

  public static void main(String[] args) {
    Bitset bitset = new Bitset(400);
    bitset.setFunction(0);
    bitset.setFunction(6);
    bitset.setFunction(50);
    System.out.println("Bit at index 0: " + bitset.getFunction(0));
    System.out.println("Bit at index 6: " + bitset.getFunction(1));
    System.out.println("Bit at index 50: " + bitset.getFunction(50));
    bitset.resetFunction(0);
    System.out.println("Bit at index 0 after reset: " + bitset.getFunction(0));
    System.out.println("Number of bits: " + bitset.size());

  }

}

