package com.welcomecure.gridviewedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridview;
    private Button button;
    private EditText edit;
    private TextView textview;
    private List<String> list = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");

        gridview = (GridView) findViewById(R.id.gridView);
        button = (Button) findViewById(R.id.button);
        edit = (EditText) findViewById(R.id.edit);
        textview = (TextView) findViewById(R.id.textview);
        gridview.setAdapter(new CustomAdapter(list,this ));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<String> x = Constants.getInstance().getEditTextValues();
                String value = x.get(Integer.parseInt(edit.getText().toString()));

                textview.setText(value);

            }
        });
    }
}
