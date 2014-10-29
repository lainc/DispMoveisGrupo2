
/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ufba.mypersonaltrainner.lib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import ufba.mypersonaltrainner.Exercicio;
import ufba.mypersonaltrainner.R;

public class StableArrayAdapter extends ArrayAdapter<Exercicio> {

    final int INVALID_ID = -1;

    private LayoutInflater layoutInflater;

    HashMap<Exercicio, Integer> mIdMap = new HashMap<Exercicio, Integer>();

    public StableArrayAdapter(Context context, int linearLayoutResourceId, List<Exercicio> objects) {
        super(context, linearLayoutResourceId, objects);
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
            layoutInflater = LayoutInflater.from(context);
        }
    }

    @Override
    public long getItemId(int position) {
        if (position < 0 || position >= mIdMap.size()) {
            return INVALID_ID;
        }
        Object item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.view_item_lista_treino, null);
            holder = new ViewHolder();
            holder.nome = (TextView) convertView.findViewById(R.id.nome);
            holder.carga = (TextView) convertView.findViewById(R.id.carga);
            holder.series = (TextView) convertView.findViewById(R.id.series);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Exercicio item = getItem(position);

        holder.nome.setText(item.getNome());
        holder.carga.setText(item.getCarga());
        holder.series.setText(item.getSeries());

        return convertView;
    }

    static class ViewHolder {
        TextView nome;
        TextView series;
        TextView carga;
    }
}
