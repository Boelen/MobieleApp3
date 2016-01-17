package com.example.r0316137.mobieleapp3;

/**
 * Created by Tom on 15/01/2016.
 */
public class Questions {

    private int id;
    private String name;
    private String Question;
    private String Answers;
    private String Finished;
    private String RightAnswer;

    public Questions(){}

    public Questions(int id, String name, String Question, String Answers , String RightAnswer, String Finished)
    {
        this.id = id;
        this.name = name;
        this.Question = Question;
        this.Answers = Answers;
        this.RightAnswer = RightAnswer;
        this.Finished = Finished;
    }

    public String getRightAnswer() {
        return RightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        RightAnswer = rightAnswer;
    }

    public String getFinished() {
        return Finished;
    }

    public void setFinished(String finished) {
        Finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswers() {
        return Answers;
    }

    public void setAnswers(String answers) {
        Answers = answers;
    }
}
