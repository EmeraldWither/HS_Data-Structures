public class Quiz implements Measureable {
    private int score;

    public Quiz(int score) {
        this.score = score;
    }

    @Override
    public int getMeasure() {
        return this.score;
    }

    public String getLetterGrade() {
        if(score == 100) return "A+";
        if(score <= 65) return "F";
        //find letter
        String grade = "";
        switch((int)Math.ceil(score/10)){
            case 9:
                grade += "A";
                break;
            case 8:
                grade += "B";
                break;
            case 7:
                grade += "C";
                break;
            case 6:
                grade += "D";
                break;
        }
        int small = score % 10;
        if(small >= 7) grade += "+";
        else if(small <= 2) grade += "-";
        return grade;
    }
    @Override
    public String toString() {
        return "Score: " + score + " | Grade: " + getLetterGrade();
    }
    
}
