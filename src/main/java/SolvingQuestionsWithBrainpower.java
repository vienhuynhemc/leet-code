
public class SolvingQuestionsWithBrainpower {

    public long mostPoints(int[][] questions) {
        if (questions.length == 1) {
            return questions[0][0];
        }
        int start = questions.length - 1;
        long[] data = new long[questions.length];
        while (start > -1) {
            int nextQuestion = questions[start][1] + start + 1;
            long currentData = nextQuestion < data.length ? questions[start][0] + data[nextQuestion] : questions[start][0];
            data[start] = start + 1 < questions.length ? Math.max(currentData, data[start + 1]) : currentData;
            start--;
        }
        return data[0];
    }

    public static void main(String[] args) {
        SolvingQuestionsWithBrainpower solvingQuestionsWithBrainpower = new SolvingQuestionsWithBrainpower();
        System.out.println(solvingQuestionsWithBrainpower.mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}));
        System.out.println(solvingQuestionsWithBrainpower.mostPoints(new int[][]{{21, 5}, {92, 3}, {72, 2}, {39, 4}, {58, 2}, {5, 5}, {49, 4}, {65, 3}}));
    }

}
