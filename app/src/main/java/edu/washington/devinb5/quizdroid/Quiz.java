package edu.washington.devinb5.quizdroid;

/**
 * Created by dvn02 on 3/1/2017.
 */

public class Quiz {
    private String question;
    private int correctAnswer;
    private String[] answers;


    public Quiz(String question, int correctAnswer, String[] answers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String newQuestion) {
        this.question = newQuestion;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int newAnswer) {
        correctAnswer = newAnswer;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] newAnswers) {
        answers = newAnswers;
    }


}
