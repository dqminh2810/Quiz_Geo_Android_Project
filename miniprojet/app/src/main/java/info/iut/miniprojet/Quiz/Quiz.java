package info.iut.miniprojet.Quiz;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by dqminh on 09/03/2018.
 */

public class Quiz {
    private String question, bonnereponse;
    private ArrayList<String> quizData;

    public Quiz(String question, String bonnereponse, ArrayList<String> quizData) {
        this.question = question;
        this.bonnereponse = bonnereponse;
        this.quizData = quizData;
    }

    public String getQuestion() {
        return question;
    }

    public String getBonnereponse() {
        return bonnereponse;
    }


    public ArrayList<String> getQuizData() {
        return quizData;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setBonnereponse(String bonnereponse) {
        this.bonnereponse = bonnereponse;
    }


    public void setQuizData(ArrayList<String> quizData) {
        this.quizData = quizData;
    }
}
