package com.swaqny.differantimages;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import at.lukle.clickableareasimage.ClickableArea;
import at.lukle.clickableareasimage.ClickableAreasImage;
import at.lukle.clickableareasimage.OnClickableAreaClickedListener;
import uk.co.senab.photoview.PhotoViewAttacher;

public class MainActivity extends AppCompatActivity    {
 TextView allmagure ;
 ImageView image ;
 EditText interNameReact;
    ArrayList<ClickableArea> setclickableAreas ,getData;
    ArrayList<String> names;
 Button go ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DragRectView view = (DragRectView) findViewById(R.id.dragRect);
        image =(ImageView)findViewById(R.id.image);
        allmagure =(TextView)findViewById(R.id.allmagure);
        interNameReact=(EditText)findViewById(R.id.interNameReact);
        setclickableAreas = new ArrayList<>();
        getData= new ArrayList<>();
        go =(Button)findViewById(R.id.go);
        names= new ArrayList<>();
        names.add("baterflay");




        if (null != view) {
            view.setOnUpCallback(new DragRectView.OnUpCallback() {
                @Override
                public void onRectFinished(final Rect rect) {
                    allmagure.setText("Rect is (" + rect.left + ", " + rect.top + ", " + rect.right + ", " + rect.bottom + ")");
                    ArrayList<ClickableArea> clickableAreas = new ArrayList<>();

                    String shimaa =    interNameReact.getText().toString().trim();
                    clickableAreas.add(new ClickableArea(rect.left , rect.top, rect.right, rect.bottom ,
                            new data( names.get(0)+"")));

                    getData=clickableAreas;
                    setSetclickableAreas(clickableAreas);
//      Toast.makeText(getApplicationContext(), "Rect is (" + rect.left + ", " + rect.top + ", " + rect.right + ", " + rect.bottom + ")",
//                            Toast.LENGTH_LONG).show();
                }
            });
        }




        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPrefs.edit();
                Gson gson = new Gson();
                String json = gson.toJson(getData);
                editor.putString("getData", json);
                editor.commit();
    Toast.makeText(getApplicationContext(),  interNameReact.getText().toString().trim(), Toast.LENGTH_SHORT).show(); //
                //               intent.putParcelableArrayListExtra("mylist", (ArrayList<? extends Parcelable>) getData);

                Intent intent = new Intent(MainActivity.this,ShowActivity.class);
//                intent.putExtra("mylist",   getData);
//
                startActivity(intent);

//                Bundle bundle = new Bundle();
////                bundle.putParcelableArrayList("mylist", (ArrayList<? extends Parcelable>) getData);
//                intent.putParcelableArrayListExtra("mylist", (ArrayList<? extends Parcelable>) getData);
//                intent.putExtras(bundle);
//                intent.putExtra("mylist",   getData);
//                Toast.makeText(getApplicationContext(), getData.get(0)+"", Toast.LENGTH_SHORT).show(); //                intent.putParcelableArrayListExtra("mylist", (ArrayList<? extends Parcelable>) getData);


            }
        });

       }



    public ArrayList<ClickableArea> getSetclickableAreas() {
        return setclickableAreas;
    }

    public void setSetclickableAreas(ArrayList<ClickableArea> setclickableAreas) {
        this.setclickableAreas = setclickableAreas;
    }
}
