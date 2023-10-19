@SuppressWarnings("DuplicatedCode")
public class PolynomialProgram {
    public static void main(String[] args) {
        addPolynomialsTestCase1();
        addPolynomialsTestCase2();
        addPolynomialsTestCase3();
        multiplyPolynomials1();
        multiplyPolynomials2();
    }

    public static void addPolynomialsTestCase1() {
        System.out.println("Adding 4x + 8x: ");
        Polynomial p = new Polynomial(new Term(4, 1)); // 4x
        p.add(new Polynomial(new Term(8, 1))); // 7x
        p.print();
    }

    public static void addPolynomialsTestCase2() {
        System.out.println("\nAdding (2x + 7) + 3x: ");
        Polynomial p = new Polynomial(new Term(2, 1)); // 4x
        p.add(new Polynomial(new Term(7, 0)));
        Polynomial p2 = new Polynomial(new Term(3, 1)); // 4x
        p.add(p2);
        p.print();
    }

    public static void addPolynomialsTestCase3() {
        System.out.println("\nAdding (3x² + 2x) + (2x² + 3x + 3): ");
        Polynomial p = new Polynomial(new Term(3, 2)); // 3x²
        p.add(new Polynomial(new Term(2, 1))); // 2
        Polynomial p2 = new Polynomial(new Term(2, 2)); // 2x²
        p2.add(new Polynomial(new Term(3, 1))); //3x
        p2.add(new Polynomial(new Term(3, 0))); //3
        p.add(p2);
        p.print();
    }

    public static void multiplyPolynomials1() {
        System.out.println("\n\nMultiplying (2x²)(3x³): ");
        Polynomial p = new Polynomial(new Term(2, 2)); // 2x²
        p.multiply(new Polynomial(new Term(3, 3))); //3x³
        p.print();
    }

    public static void multiplyPolynomials2() {
        System.out.println("\nMultiplying (3x² + 2x)(2x² + 3x + 3): ");
        Polynomial p = new Polynomial(new Term(3, 2)); // 3x²
        p.add(new Polynomial(new Term(2, 1))); // + 2x
        Polynomial p2 = new Polynomial(new Term(2, 2)); // 2x²
        p2.add(new Polynomial(new Term(3, 1))); // 3x
        p2.add(new Polynomial(new Term(3, 0))); // 3

        p.multiply(p2);
        p.print();
    }

}
