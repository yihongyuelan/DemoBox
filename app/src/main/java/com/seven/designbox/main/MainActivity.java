package com.seven.designbox.main;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.seven.designbox.R;
import com.seven.designbox.designpatterns.common.PatternsConstant;
import com.seven.designbox.designpatterns.common.PatternsDetail;

/**
 * The main activity of the API library demo gallery.
 * <p>
 * The main layout lists the demonstrated features, with buttons to launch them.
 */
public final class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {


    /**
     * A custom array adapter that shows a {@link FeatureView} containing details about the demo.
     */
    private static class CustomArrayAdapter extends ArrayAdapter<PatternsDetail> {

        /**
         * @param patterns An array containing the details of the demos to be displayed.
         */
        public CustomArrayAdapter(Context context, PatternsDetail[] patterns) {
            super(context, R.layout.feature, R.id.title, patterns);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            FeatureView featureView;
            if (convertView instanceof FeatureView) {
                featureView = (FeatureView) convertView;
            } else {
                featureView = new FeatureView(getContext());
            }

            PatternsDetail pattern = getItem(position);

            featureView.setTitleId(pattern.titleId);
            featureView.setDescriptionId(pattern.desId);

            Resources resources = getContext().getResources();
            String title = resources.getString(pattern.titleId);
            String description = resources.getString(pattern.desId);
            featureView.setContentDescription(title + ". " + description);

            return featureView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ListView list = (ListView) findViewById(R.id.list);

        ListAdapter adapter = new CustomArrayAdapter(this, PatternsConstant.PATTERN_LISTS);

        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        list.setEmptyView(findViewById(R.id.empty));
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle item selection
//        if (item.getItemId() == R.id.menu_legal) {
//            startActivity(new Intent(this, LegalInfoActivity.class));
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        PatternsDetail patttern = (PatternsDetail) parent.getAdapter().getItem(position);
        startActivity(new Intent(this, patttern.patternClass));
    }
}
