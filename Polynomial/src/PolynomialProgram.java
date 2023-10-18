public class PolynomialProgram {
    public static void main(String[] args) throws Exception {
        Polynomial p = new Polynomial(new Term(4, 1)); //4x
        p.add(new Polynomial(new Term(7, 1))); //7x
        p.add(new Polynomial(new Term(18, 1))); //18x
        p.add(new Polynomial(new Term(2, 7))); //2x^9272
        p.add(new Polynomial(new Term(18, 0))); //18
        p.add(new Polynomial(new Term(20, 0))); //20

        System.out.println(p);
    }
}
