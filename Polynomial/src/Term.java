public class Term {
    private final int coefficient;
    private final int power;

    public Term(int coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public int getCoefficient() {
        return this.coefficient;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        String power = "";
        int modpow = this.power;
        while (modpow != 0) {
            int pow = Math.abs(modpow) % 10;
            if(pow == 2) power = "\u00B2" + power;
            if(pow == 3) power = "\u00B3" + power;
            if(pow == 4) power = "\u2074" + power;
            if(pow == 5) power = "\u2075" + power;
            if(pow == 6) power = "\u2076" + power;
            if(pow == 7) power = "\u2077" + power;
            if(pow == 8) power = "\u2078" + power;
            if(pow == 9) power = "\u2079" + power;
            modpow /= 10;
        }
        if(this.power == 0) return coefficient + "";
        if(this.power < 0) power = "\u207B" + power;
        return coefficient + "x" + power;
    }
}
