package info.iut.miniprojet.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import info.iut.miniprojet.Continent.Continent;
import info.iut.miniprojet.Continent.ContinentAdapter;
import info.iut.miniprojet.Continent.ListeContinent;
import info.iut.miniprojet.R;

/**
 * Created by dqminh on 27/03/2018.
 */

public class ContinentActivity extends AppCompatActivity implements ContinentAdapter.ContentAdapterListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        this.setTitle("Choose continent");

        ListeContinent listeContinent = new ListeContinent();
        listeContinent.construireListe();
        ListView lv = (ListView) findViewById(R.id.listView);

        //Création et initialisation de l'Adapter pour les diplomes
        ContinentAdapter adapter = new ContinentAdapter(this, listeContinent);

        //Récupération du composant ListView
        ListView list = (ListView)findViewById(R.id.listView);

        //Initialisation de la liste avec les données
        list.setAdapter(adapter);

        //Ecoute des évènements sur la liste

        adapter.addListener(this);


    }

    @Override
    public void onClickNom(Continent item) {
        int quizCategory = 0;

        switch (item.getNom()){
            case "ASIA":
                quizCategory=1;
                break;
            case "AMERICA":
                quizCategory=2;
                break;
            case "EUROPE":
                quizCategory=3;
                break;
        }

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("QUIZZ_CATEGORY", quizCategory);
        startActivity(intent);
    }
}
