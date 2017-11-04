package com.swaqny.differantimages;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import at.lukle.clickableareasimage.ClickableArea;
import at.lukle.clickableareasimage.ClickableAreasImage;
import at.lukle.clickableareasimage.OnClickableAreaClickedListener;
import uk.co.senab.photoview.PhotoViewAttacher;

public class ShowActivity extends AppCompatActivity implements OnClickableAreaClickedListener {
    ImageView image;
     TextView theresult ;
    ArrayList<ClickableArea> setclickableAreas ;
    Button clear  ,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        clear= (Button)findViewById(R.id.clear);
        back=(Button)findViewById(R.id.back);
        image=(ImageView)findViewById(R.id.image);
        theresult=(TextView)findViewById(R.id.theresult);
//        setclickableAreas = (ArrayList<ClickableArea>)getIntent().getSerializableExtra("mylist");

//        setclickableAreas  =ArrayList<ClickableArea>getIntent().getSerializableExtra("LIST");//HERE IT IS SUDDENLY A SINGLE OBJECT
//        setclickableAreas = (ArrayList<ClickableArea>)getIntent().getExtras().getSerializable("mylist");
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Gson gson = new Gson();
        String json = sharedPrefs.getString("getData", null);
        Type type = new TypeToken<ArrayList<ClickableArea>>() {}.getType();
        setclickableAreas = gson.fromJson(json, type);
        Toast.makeText(this, setclickableAreas.get(0)+"", Toast.LENGTH_SHORT).show();
        theresult.setText(setclickableAreas.get(0)+"");
//

        ClickableAreasImage clickableAreasImage = new ClickableAreasImage(new PhotoViewAttacher(image), this);
        ArrayList<ClickableArea> clickableAreas = setclickableAreas ;
        clickableAreasImage.setClickableAreas(setclickableAreas);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPrefs.edit();
                editor.clear();
                editor.commit();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowActivity.this,MainActivity.class);
                startActivity(intent);


            }
        });


    }

    @Override
    public void onClickableAreaTouched(Object o) {
        String text =  o.toString();
        String name = o.toString().substring(8).replace("}", "");
        Toast.makeText(this,  name+"", Toast.LENGTH_SHORT).show();
        theresult.setText(name+"");

    }
}
