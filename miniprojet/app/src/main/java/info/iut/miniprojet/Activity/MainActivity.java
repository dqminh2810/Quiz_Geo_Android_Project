package info.iut.miniprojet.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;
import java.util.Random;

import info.iut.miniprojet.Quiz.ListeQuiz;
import info.iut.miniprojet.Quiz.Quiz;
import info.iut.miniprojet.R;

public class MainActivity extends AppCompatActivity {

    private TextView countLabel, questionLabel;
    private Button answerBtn1, answerBtn2   , answerBtn3, answerBtn4;
    private String rightAnswer;
    private int rightAnswerCount=0;
    private int quizCount=1;
    private static final int QUIZ_COUNT = 5;

    ListeQuiz liste;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //Receive quizCategory from StartActivity
        int quizCategory = getIntent().getIntExtra("QUIZZ_CATEGORY", 0);
        Log.v("QUIZZ_CATEGORY", quizCategory + "");


        liste = new ListeQuiz();
        liste.construireListe(this, quizCategory);



        countLabel = (TextView)findViewById(R.id.countLabel);
        questionLabel = (TextView)findViewById(R.id.questionLabel);
        answerBtn1 = (Button)findViewById(R.id.answerBtn1);
        answerBtn2 = (Button)findViewById(R.id.answerBtn2);
        answerBtn3 = (Button)findViewById(R.id.answerBtn3);
        answerBtn4 = (Button)findViewById(R.id.answerBtn4);


        showNextQuiz();
    }

    public void showNextQuiz(){
        countLabel.setText("Q"+quizCount);

        Random random = new Random();
        int randomNum = random.nextInt(liste.size());

        Quiz quiz = liste.get(randomNum);

        questionLabel.setText(quiz.getQuestion());
        rightAnswer = quiz.getBonnereponse();

        quiz.getQuizData().remove(0);
        Collections.shuffle(quiz.getQuizData());

        answerBtn1.setText(quiz.getQuizData().get(0));
        answerBtn2.setText(quiz.getQuizData().get(1));
        answerBtn3.setText(quiz.getQuizData().get(2));
        answerBtn4.setText(quiz.getQuizData().get(3));

        liste.listeQuiz.remove(randomNum);
    }
    public void checkAnswer(View view){
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if(btnText.equals(rightAnswer)){
            alertTitle="Correct!!";
            rightAnswerCount++;
        }else{
            alertTitle="Wrong...";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer: "+rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(quizCount==QUIZ_COUNT){
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);
                }else{
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}
