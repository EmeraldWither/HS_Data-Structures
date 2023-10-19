import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {
    private final LinkedList<Term> terms = new LinkedList<>();

    public Polynomial(Term term) {
        terms.add(term);
    }

    public void add(Polynomial poly) {
        LinkedList<Term> other = poly.terms;
        ListIterator<Term> otherItr = other.listIterator();
        while (otherItr.hasNext()) {
            // step 1: add to the other list
            Term term = otherItr.next();
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
        terms.sort((o1, o2) -> {
            return o2.getPower() - o1.getPower();
        });
    }

    public Polynomial multiply(Polynomial poly) {
        // do steps 1-4
        LinkedList<Term> other = poly.terms;
        ListIterator<Term> otherItr = other.listIterator();
        while (otherItr.hasNext()) {
            // step 1: add to the other list
            Term term = otherItr.next();
            int power = term.getPower();
            int coefficents = term.getCoefficient();
            int powers = term.getPower();
            // step 2: loop through list looking for terms with thr same power
            ListIterator<Term> itr = terms.listIterator();
            while (itr.hasNext()) {
                Term term2 = itr.next();
                if (term.getCoefficient() == term2.getCoefficient()) {
                    // step 2a: remove it
                    itr.remove();
                    // add to coefficents
                    coefficents *= term2.getCoefficient();
                    powers += term2.getPower();
                }

            }
            Term term3 = new Term(coefficents, powers);
            itr.add(term3);
        }
        // sort now
        terms.sort((o1, o2) -> {
            return o2.getPower() - o1.getPower();
        });
        return this;
    }

    @Override
    public String toString() {
        boolean first = true;
        String text = "";
        for (Term term : terms) {
            if (!first) {
                if (term.getCoefficient() >= 0) {
                    text += " + ";
                }
            }
            text += term;
            first = false;
        }
        return text;
    }

    public void print() {
        System.out.println(this);
    }
}
