import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {
    private LinkedList<Term> terms = new LinkedList<>();

    public Polynomial(Term term) {
        terms.add(term);
    }

    public void add(Polynomial poly) {
        LinkedList<Term> other = poly.terms;
        for (Term term : other) {
            // step 1: add to the other list
            int power = term.getPower();
            int coefficents = term.getCoefficient();
            // step 2: loop through list looking for terms with thr same power
            ListIterator<Term> itr = terms.listIterator();
            while (itr.hasNext()) {
                Term term2 = itr.next();
                if (term2.getPower() == power) {
                    // step 2a: remove it
                    itr.remove();
                    // add to coefficents
                    coefficents += term2.getCoefficient();
                }
            }
            Term term3 = new Term(coefficents, power);
            itr.add(term3);
        }
        // sort now
        terms.sort((o1, o2) -> o2.getPower() - o1.getPower());
    }

    @SuppressWarnings("UnusedReturnValue")
    public Polynomial multiply(Polynomial poly) {
        // do steps 1-4
        LinkedList<Term> other = poly.terms;
        Polynomial[] polynomials = new Polynomial[this.terms.size()];
        int i = 0;
        for (Term term : terms) {
            // step 1: add to the other list
            Polynomial p1 = null;
            for (Term term2 : other) {
                //multiply coeffecients, and add power
                int coefficent = term.getCoefficient() * term2.getCoefficient();
                int power = term.getPower() + term2.getPower();
                if(p1 == null) {
                    p1 = new Polynomial(new Term(coefficent, power));
                }
                else {
                    p1.add(new Polynomial(new Term(coefficent, power)));
                }
            }
            assert p1 != null;
            polynomials[i] = p1;
            i++;
        }
        for (int j = 1; j < polynomials.length; j++) {
            polynomials[0].add(polynomials[j]);
        }
        this.terms = polynomials[0].terms;
        // sort now
        terms.sort((o1, o2) -> o2.getPower() - o1.getPower());
        return this;
    }

    @Override
    public String toString() {
        boolean first = true;
        StringBuilder text = new StringBuilder();
        for (Term term : terms) {
            if (!first) {
                if (term.getCoefficient() >= 0) {
                    text.append(" + ");
                }
            }
            text.append(term);
            first = false;
        }
        return text.toString();
    }

    public void print() {
        System.out.println(this);
    }
}
