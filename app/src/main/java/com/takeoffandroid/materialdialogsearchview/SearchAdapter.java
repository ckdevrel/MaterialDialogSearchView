package com.takeoffandroid.materialdialogsearchview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SearchAdapter extends BaseAdapter {

    private Context mContext;
    private String[] mCountries;
    private LayoutInflater mLayoutInflater;


    public SearchAdapter(Context context, String[] countries) {
        this.mContext = context;
        this.mCountries =countries;
    }


    public void updateList (String[] filterList) {
        this.mCountries = filterList;
        notifyDataSetChanged ();
    }

    @Override
    public int getCount() {
        return mCountries.length;
    }

    @Override
    public String getItem(int position) {
        return mCountries[position];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder = null;
        if(v==null){

            holder = new ViewHolder();

            mLayoutInflater = (LayoutInflater)mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);

            v = mLayoutInflater.inflate(R.layout.list_item_search, parent, false);
            holder.txtCountry = (TextView)v.findViewById(R.id.txt_country);
            v.setTag(holder);
        }else{

            holder = (ViewHolder) v.getTag();
        }

        holder.txtCountry.setText(mCountries[position]);

        return v;
    }

}

class ViewHolder{

     TextView txtCountry;
}





