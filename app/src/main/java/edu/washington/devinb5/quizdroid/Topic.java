package edu.washington.devinb5.quizdroid;

import java.util.List;

/**
 * Created by dvn02 on 3/1/2017.
 */

public class Topic {

    private String title, shortDescrip, longDescrip;
    private List<Quiz> questions;

    public Topic(String title, String shortDescrip, String longDescrip, List<Quiz> questions) {
        this.title = title;
        this.shortDescrip = shortDescrip;
        this.longDescrip = longDescrip;
        this.questions = questions;

    }

    public String getTitle() {
        return title;
    }

    public String getShortDescrip() {
        return shortDescrip;
    }

    public String getLongDescrip() {
        return longDescrip;
    }

    public List<Quiz> getQuestions() {
        return questions;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShortDescrip(String shortDescrip) {
        this.shortDescrip = shortDescrip;
    }

    public void setLongDescrip(String longDescrip) {
        this.longDescrip = longDescrip;
    }

    public void setQuestions(List<Quiz> questions) {
        this.questions = questions;
    }

    public void addQuestion(Quiz q) {
        questions.add(q);
    }
}
