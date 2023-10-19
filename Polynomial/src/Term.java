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

    @SuppressWarnings("UnnecessaryUnicodeEscape")
    @Override
    public String toString() {
        StringBuilder power = new StringBuilder();
        int modpow = this.power;
        while (modpow != 0) {
            int pow = Math.abs(modpow) % 10;
            if(pow == 2) power.insert(0, "²"); //\u00B2
            if(pow == 3) power.insert(0, "³"); //\u00B3
            if(pow == 4) power.insert(0, "⁴"); //\u2074
            if(pow == 5) power.insert(0, "⁵"); //\u2075
            if(pow == 6) power.insert(0, "⁶"); //\u2076
            if(pow == 7) power.insert(0, "⁷"); //\u2077
            if(pow == 8) power.insert(0, "⁸"); //\u2078
            if(pow == 9) power.insert(0, "⁹"); //\u2079
            modpow /= 10;
        }
        if(this.power == 0) return coefficient + "";
        if(this.power < 0) power.insert(0, "⁻"); //\u207B
        return coefficient + "x" + power;
    }
}
