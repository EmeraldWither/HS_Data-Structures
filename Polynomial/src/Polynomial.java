import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {
    private LinkedList<Term> terms = new LinkedList<>();

    public Polynomial(Term term) {
        terms.add(term);
    }

    public void add(Polynomial poly) {
        LinkedList<Term> other = poly.terms;
        // loop over our outer list to get the terms
        for (Term term : other) {
            // step 1: add to the other list
            int power = term.getPower();
            int coefficents = term.getCoefficient();
            // step 2: loop through list looking for terms with the same power
            ListIterator<Term> itr = terms.listIterator();
            while (itr.hasNext()) {
                Term term2 = itr.next();
                if (term2.getPower() == power) {
                    // step 2a: remove it
                    itr.remove();
                    // add the coefficents together
                    coefficents += term2.getCoefficient();
                }
            }
            // make a new term with the combined coefficents and the power
            Term term3 = new Term(coefficents, power);
            // and add it to the end
            itr.add(term3);
        }
        // sort now by the power
        terms.sort((o1, o2) -> o2.getPower() - o1.getPower());
    }

    @SuppressWarnings("UnusedReturnValue")
    public Polynomial multiply(Polynomial poly) {
        LinkedList<Term> other = poly.terms;

        // create another list of our polynomaials that we will add together
        // after all the terms have been multiplied
        Polynomial[] polynomials = new Polynomial[this.terms.size()];
        int i = 0;
        for (Term term : terms) {
            // step 1: loop over our list
            Polynomial p1 = null;
            for (Term term2 : other) {
                // multiply coeffecients, and add power
                int coefficent = term.getCoefficient() * term2.getCoefficient();
                int power = term.getPower() + term2.getPower();
                //if this is the 1st term, we should make it as such
                if (p1 == null) {
                    p1 = new Polynomial(new Term(coefficent, power));
                } else {
                    //add the new term to the old one
                    p1.add(new Polynomial(new Term(coefficent, power)));
                }
            }
            assert p1 != null;
            polynomials[i] = p1;
            i++;
        }
        //add all of our terms together
        for (int j = 1; j < polynomials.length; j++) {
            polynomials[0].add(polynomials[j]);
        }
        this.terms = polynomials[0].terms;
        // no need to call sort again as the add method already sorts for us
        return this;
    }

    @Override
    public String toString() {
        boolean first = true;
        StringBuilder text = new StringBuilder();
        for (Term term : terms) {
            //makes sure that the 1st number doesnt get a "+5x + 3"
            if (!first) {
                if (term.getCoefficient() >= 0) {
                    text.append(" + ");
                }
            }
            //call the toString on term
            text.append(term);
            first = false;
        }
        return text.toString();
    }

    public void print() {
        System.out.println(this);
    }
}
