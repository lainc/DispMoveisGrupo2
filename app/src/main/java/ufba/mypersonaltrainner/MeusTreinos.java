package ufba.mypersonaltrainner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import ufba.mypersonaltrainner.lib.DynamicListView;
import ufba.mypersonaltrainner.lib.Queijos;
import ufba.mypersonaltrainner.lib.StableArrayAdapter;


public class MeusTreinos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_treinos);

        ArrayList<String> mListaQueijos = new ArrayList<String>();
        for (int i = 0; i < Queijos.sQueijosStrings.length; ++i) {
            mListaQueijos.add(Queijos.sQueijosStrings[i]);
        }

        StableArrayAdapter adapter = new StableArrayAdapter(this,
                R.layout.view_item_lista_treino, mListaQueijos);
        DynamicListView listView = (DynamicListView) findViewById(R.id.list_training);

        listView.setCheeseList(mListaQueijos);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.meus_treinos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
