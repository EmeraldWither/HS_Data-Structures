public class QuizzesAndMeasureableCW {
    public static void main(String[] args) throws Exception {
        System.out.println("part 1");
        Measureable[] values = new Measureable[5];
        values[0] = new Value(10);
        values[1] = new Value(50);
        values[2] = new Value(192);
        values[3] = new Value(209);
        values[4] = new Value(-5);
        System.out.println("Max Value: " + Data.getMax(values).getMeasure());

        System.out.println("\n\n Part 2");
        Measureable[] quizzes = new Measureable[5];
        quizzes[0] = new Quiz(32);
        quizzes[1] = new Quiz(87);
        quizzes[2] = new Quiz(92);
        quizzes[3] = new Quiz(83);
        quizzes[4] = new Quiz(73);

        for (Measureable quizzes2 : quizzes) {
            System.out.println(quizzes2.toString());
        }

        System.out.println("Average Grade: " + Data.average(quizzes));
        System.out.println("Best Grade: " + Data.getMax(quizzes));

    }
}
