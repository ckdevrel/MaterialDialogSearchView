package com.takeoffandroid.materialdialogsearchview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> mCountries;
    private LayoutInflater mLayoutInflater;
    private boolean mIsFilterList;

    public SearchAdapter(Context context, ArrayList<String> countries, boolean isFilterList) {
        this.mContext = context;
        this.mCountries =countries;
        this.mIsFilterList = isFilterList;
    }


    public void updateList(ArrayList<String> filterList, boolean isFilterList) {
        this.mCountries = filterList;
        this.mIsFilterList = isFilterList;
        notifyDataSetChanged ();
    }

    @Override
    public int getCount() {
        return mCountries.size();
    }

    @Override
    public String getItem(int position) {
        return mCountries.get(position);
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

        holder.txtCountry.setText(mCountries.get(position));

        Drawable searchDrawable,recentDrawable;

        if(android.os.Build.VERSION.SDK_INT >= 21){
            searchDrawable = mContext.getResources().getDrawable(R.drawable.ic_magnify_grey600_24dp, null);
            recentDrawable = mContext.getResources().getDrawable(R.drawable.ic_backup_restore_grey600_24dp, null);

        } else {
            searchDrawable = mContext.getResources().getDrawable(R.drawable.ic_magnify_grey600_24dp);
            recentDrawable = mContext.getResources().getDrawable(R.drawable.ic_backup_restore_grey600_24dp);

        }
        if(mIsFilterList) {
            holder.txtCountry.setCompoundDrawablesWithIntrinsicBounds(searchDrawable, null, null, null);
        }else {
            holder.txtCountry.setCompoundDrawablesWithIntrinsicBounds(recentDrawable, null, null, null);

        }
        return v;
    }

}

class ViewHolder{

     TextView txtCountry;
}





