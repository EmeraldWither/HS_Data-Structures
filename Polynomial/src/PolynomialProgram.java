public class PolynomialProgram {
    public static void main(String[] args) throws Exception {
        multiplyPolynomials();
    }

    public static void addPolynomials() {
        Polynomial p = new Polynomial(new Term(3, 2)); // 4x
        p.add(new Polynomial(new Term(2, 1))); // 7x

        Polynomial p2 = new Polynomial(new Term(3, 1));
        p2.add(new Polynomial(new Term(2, 2)));
        p2.add(new Polynomial(new Term(3, 0)));
        p2.print();

        p.add(p2);
        p.print();
    }

    public static void multiplyPolynomials() {
        Polynomial p = new Polynomial(new Term(3, 2)); // 3x^2
        p.add(new Polynomial(new Term(2, 1))); // + 2x
        Polynomial p2 = new Polynomial(new Term(2, 2)); // 2x^2
        p2.add(new Polynomial(new Term(3, 1)));
        p2.add(new Polynomial(new Term(3, 0)));

        p.multiply(p2);
        p.print();
    }

}
