package info.iut.miniprojet.Continent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import info.iut.miniprojet.R;

/**
 * Created by dqminh on 27/03/2018.
 */

public class ContinentAdapter extends BaseAdapter{
    private ListeContinent mListC;

    //Le contexte dans lequel est présent notre adapter
    private Context mContext;

    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;


    public ContinentAdapter(Context context, ListeContinent aListC) {
        mContext = context;
        mListC = aListC;
        mInflater = LayoutInflater.from(mContext);
    }

    public int getCount() {
        return mListC.size();
    }

    public Object getItem(int position) {
        return mListC.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;

        //(1) : Réutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item à partir du  layout XML ""
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.listview_item, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView tvContent = (TextView) layoutItem.findViewById(R.id.textContinent);

        //(3) : Renseignement des valeurs
        tvContent.setText(mListC.get(position).getNom());

        tvContent.setTag(position);

        tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer position = (Integer)view.getTag();
                sendListener(mListC.get(position));
            }
        });

        //On retourne l'item créé.
        return layoutItem;
    }

    //abonnement pour click sur le nom...
    private ArrayList<ContentAdapterListener> mListListener = new ArrayList<ContentAdapterListener>();
    public void addListener(ContentAdapterListener aListener) {
        mListListener.add(aListener);
    }
    private void sendListener(Continent item) {
        for(int i = mListListener.size()-1; i >= 0; i--) {
            mListListener.get(i).onClickNom(item);
        }
    }

    // Interface pour écouter les évènements sur le nom du diplome

    public interface ContentAdapterListener {
        public void onClickNom(Continent item);
    }



}
