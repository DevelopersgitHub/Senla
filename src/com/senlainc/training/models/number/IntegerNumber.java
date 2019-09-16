package com.senlainc.training.models.number;

public class IntegerNumber {
    private int number;

    public IntegerNumber(int number) {
        this.number = number;
    }

    private boolean isEven() {
        return this.number % 2 == 0;
    }

    private boolean isComposite() {
        for (int i = 2; i < this.number; i++) {
            if (this.number % i == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "integer = " + number +
                (this.isEven() ? " even" : " odd") +
                (this.isComposite() ? " composite\n" : " simple\n");
    }
}
