package info.iut.miniprojet.Quiz;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by dqminh on 27/03/2018.
 */

public class ListeQuiz {

    public ArrayList<Quiz> listeQuiz;

    public ListeQuiz() {
        listeQuiz = new ArrayList<Quiz>();
    }

    public int size() {
        return listeQuiz.size();
    }

    public Quiz get(int position) {
        return listeQuiz.get(position);
    }


    public void construireListe(Context context, int category) {
        // Création de la liste des quiz

        try {
            // Récupération du fichier json
            JSONArray jsonArray = new JSONArray(getJSONFromAsset(context, category));

            if(jsonArray!=null)
                // Récupération des quiz
                for (int i = 0; i < jsonArray.length(); i++) {
                    listeQuiz.add(getQuizFromJSONObject(jsonArray.getJSONObject(i), context));
                }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    // Fonction pour récuperer un quiz
    private Quiz getQuizFromJSONObject(JSONObject jsonObject, Context context) throws JSONException {

        //Pays
        String pays = jsonObject.getString("pays");
        // Bonne réponse
        String bonnereponse = jsonObject.getString("bonnereponse");
        //CHOIX
        String choix2 = jsonObject.getString("choix2");
        String choix3 = jsonObject.getString("choix3");
        String choix4 = jsonObject.getString("choix4");

        ArrayList<String> quizData = new ArrayList<String>();
        quizData.add(pays);
        quizData.add(bonnereponse);
        quizData.add(choix2);
        quizData.add(choix3);
        quizData.add(choix4);

        Quiz q = new Quiz(pays, bonnereponse, quizData);

        return q;
    }



    //lecture du fichier en string
    private  String getJSONFromAsset(Context context, int category) {
        String json = null;
        try {
            InputStream is = null;
            if(category==0){
                is = context.getAssets().open("QuizData.json");
            }else if(category==1){
                is = context.getAssets().open("QuizDataAsie.json");
            }else if(category==2){
                is = context.getAssets().open("QuizDataAmerique.json");
            }else if(category==3){
                is = context.getAssets().open("QuizDataEurope.json");
            }
            //TODO quand on ajoute les autres fichiers
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }


}
