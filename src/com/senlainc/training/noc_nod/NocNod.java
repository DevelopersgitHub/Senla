package com.senlainc.training.noc_nod;

public class NocNod {
    private int number;
    private int number1;

    public NocNod(int number, int number1) {
        this.number = number;
        this.number1 = number1;
    }

    private int getNoc() {
        if (number != 0 && number1 != 0) {
            int count = 1;
            boolean condition = true;
            while (condition) {
                if ((count % number == 0) && (count % number1 == 0)) {
                    condition = false;
                } else {
                    count++;
                }
            }
            return count;
        }
        return 0;
    }

    private int getNod() {
        if (number != 0 && number1 != 0) {
            int count = Math.max(number, number1);
            while (count != 0) {
                if ((number % count == 0) && (number1 % count == 0)) {
                    return count;
                }
                count--;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "\tNumbers: " + number + ", " + number1 +
                " NOC: " + (this.getNoc()) +
                " NOD: " + this.getNod()
                + "\n";
    }
}
