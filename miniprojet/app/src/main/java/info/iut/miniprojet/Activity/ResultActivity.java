package info.iut.miniprojet.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import info.iut.miniprojet.R;

/**
 * Created by dqminh on 04/03/2018.
 */

public class ResultActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int score = intent.getIntExtra("RIGHT_ANSWER_COUNT", 0);

        TextView resultLabel = (TextView) findViewById(R.id.resultLabel);
        resultLabel.setText(score + " /5");
    }

    public void returnTop(View view){
        Intent intent = new Intent(getApplicationContext(), StartActivity.class);
        startActivity(intent);
    }
}
