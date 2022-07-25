package ru.job4j.max;

public class Reduce {
    private int[] array;

    public void to(int[] ary) {
        this.array = ary;
    }

    public void print() {
        for (int index = 0; index < array.length; index++) {
            System.out.println(array[index]);
        }
    }

    public static void main(String[] args) {
        int[] ary = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(ary);
        reduce.print();
    }
}
