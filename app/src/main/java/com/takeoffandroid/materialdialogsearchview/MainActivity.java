package com.takeoffandroid.materialdialogsearchview;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    private String[] country;



    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);


        toolBarData ();

    }

    @Override
    protected void onStart () {
        super.onStart();
    }

    @Override
    protected void onStop () {
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);


        return true;
    }


    @Override
    public boolean onOptionsItemSelected (MenuItem item) {

        int id = item.getItemId ();
        switch (id) {

            case android.R.id.home:
                finish ();
                break;

            case R.id.action_search:
                loadToolBarSearch();
                break;
        }

        return super.onOptionsItemSelected (item);
    }

    private void toolBarData () {
        toolbar = (Toolbar) findViewById (R.id.toolbar);
        toolbar.setTitle("MaterialDialogSearchView");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
//        getSupportActionBar ().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar ().setDisplayShowHomeEnabled(true);
    }

    public void loadToolBarSearch () {

        country = MainActivity.this.getResources().getStringArray(R.array.countries_array);
        View view = MainActivity.this.getLayoutInflater().inflate (R.layout.view_toolbar_search, null);
        LinearLayout parentToolbarSearch = (LinearLayout) view.findViewById (R.id.parent_toolbar_search);
        ImageView imgToolBack = (ImageView) view.findViewById (R.id.img_tool_back);
        final EditText edtToolSearch = (EditText) view.findViewById (R.id.edt_tool_search);
        ImageView imgToolClose = (ImageView) view.findViewById (R.id.img_tool_close);
        final ListView listSearch = (ListView) view.findViewById (R.id.list_search);
        final TextView txtEmpty = (TextView)view.findViewById (R.id.txt_empty);


        edtToolSearch.setHint ("Search your country");

        final Dialog mBottomSheetDialog = new Dialog (MainActivity.this, R.style.MaterialSearch);
        mBottomSheetDialog.setContentView (view);
        mBottomSheetDialog.setCancelable (true);
        mBottomSheetDialog.getWindow ().setLayout (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mBottomSheetDialog.getWindow ().setGravity (Gravity.BOTTOM);
        mBottomSheetDialog.show ();

        mBottomSheetDialog.getWindow().setSoftInputMode (WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        final SearchAdapter searchAdapter = new SearchAdapter (MainActivity.this, country);



//        searchAdapter.SetOnItemClickListener (new SearchAdapter.OnItemClickListener () {
//
//            @Override
//            public void onItemClick (View v, int position, String hotelAddress) {
//
//                mBottomSheetDialog.dismiss ();
//
//                Toast.makeText(MainActivity.this,hotelAddress,Toast.LENGTH_SHORT).show();
//            }
//
//        });

        edtToolSearch.addTextChangedListener (new TextWatcher() {
            @Override
            public void beforeTextChanged (CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged (CharSequence s, int start, int before, int count) {
                ArrayList<String> filterList = new ArrayList<String>();
                boolean isNodata=false;
                if(s.length()>0){
                    for(int i = 0; i<country.length;i++){


                        if(country[i].toLowerCase ().startsWith (s.toString ().trim ().toLowerCase ())){

                            filterList.add(country[i]);

                            listSearch.setVisibility(View.VISIBLE);
                            Utils.setListViewHeightBasedOnChildren(listSearch);
                            listSearch.setAdapter(searchAdapter);

                            String[] filterArray = new String[filterList.size()];
                            filterArray = filterList.toArray(filterArray);
                            searchAdapter.updateList (filterArray);
                            isNodata=true;
                        }
                    }
                    if(!isNodata){
                        listSearch.setVisibility (View.GONE);
                        txtEmpty.setVisibility (View.VISIBLE);
                        txtEmpty.setText ("No data");
                    }
                }else{
                    listSearch.setVisibility (View.GONE);
                    txtEmpty.setVisibility (View.GONE);
//                    searchAdapter.updateList(mHotelAddress);
                }

            }

            @Override
            public void afterTextChanged (Editable s) {

            }
        });

        imgToolBack.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                mBottomSheetDialog.dismiss ();
            }
        });

        imgToolClose.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                mBottomSheetDialog.dismiss ();
            }
        });

//        int toolbarSize = Util.getActionBarHeight (MainActivity.this);
//        parentToolbarSearch.setPadding (toolbarSize / 2, toolbarSize / 2, toolbarSize / 2, toolbarSize / 2);

    }

}
