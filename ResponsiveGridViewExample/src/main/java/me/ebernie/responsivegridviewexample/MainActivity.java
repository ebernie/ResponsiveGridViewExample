package me.ebernie.responsivegridviewexample;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String[] content = new String[35];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 0; i < content.length; i++) {
            content[i] = "Grid content " + i;
        }
        GridView gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(new MyGridAdapter(this, R.layout.grid_row, content));
    }

    private class MyGridAdapter extends ArrayAdapter<String> {

        private final String[] content;
        private final int layout;

        public MyGridAdapter(Context context, int textViewResourceId, String[] content) {
            super(context, textViewResourceId);
            this.content = content;
            this.layout = textViewResourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                convertView = getLayoutInflater().inflate(layout, null);
                ViewHolder holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }

            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.text.setText(getItem(position));

            return convertView;
        }

        @Override
        public int getCount() {
            return content.length;
        }

        @Override
        public String getItem(int position) {
            return content[position];
        }

        private class ViewHolder {
            final TextView text;

            ViewHolder(View view) {
                this.text = (TextView) view.findViewById(R.id.text);
            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
