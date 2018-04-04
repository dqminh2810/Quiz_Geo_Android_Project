package info.iut.miniprojet.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import info.iut.miniprojet.Fragment.FragmentHowToPlay;
import info.iut.miniprojet.R;

public class StartActivity extends AppCompatActivity {
    Animation fade;
    TextView titre;
    ImageButton btshr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //animation du text capital quiz
        titre = (TextView)findViewById(R.id.titre);
        fade = AnimationUtils.loadAnimation(this, R.anim.fade);
        titre.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View arg0) {
                titre.startAnimation(fade);
            }});
    }

    public void start(View view){
        Intent intent = new Intent(getApplicationContext(), ContinentActivity.class);
        startActivity(intent);
    }
    public void guideGame(View view){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.howtoplayfrag, new FragmentHowToPlay()) .commit();
    }
    public void quitGame(View view){
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
    public void shareGame(View view){
        String shareBody = "Voici le lien vers CapitalQuiz : www.capitalquizz.com !";
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Decouvrez capital quiz !");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent,"Partager en utilisant"));
    }
}
