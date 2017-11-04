package com.swaqny.differantimages;

import android.annotation.SuppressLint;
import android.app.Application;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.leakcanary.LeakCanary;

import java.util.ArrayList;
import java.util.List;

import at.lukle.clickableareasimage.ClickableArea;
import at.lukle.clickableareasimage.ClickableAreasImage;
import at.lukle.clickableareasimage.OnClickableAreaClickedListener;
import uk.co.senab.photoview.PhotoViewAttacher;

public class ClickableAreasImages extends AppCompatActivity implements OnClickableAreaClickedListener {

//    Application app ;

    int y  ,x;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        LeakCanary.install(app);
        setContentView(R.layout.activity_clickable_areas_images);
        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.austria_map);

        // Create your image
        ClickableAreasImage clickableAreasImage = new ClickableAreasImage(new PhotoViewAttacher(image), this);

        // Define your clickable area (pixel values: x coordinate, y coordinate, width, height) and assign an object to it
        List<ClickableArea> clickableAreas = getClickableAreas();
        clickableAreasImage.setClickableAreas(clickableAreas);





    }




    // Listen for touches on your images:
    @Override
    public void onClickableAreaTouched(Object item) {
        if (item instanceof State) {
            String text = ((State) item).getName();
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(600, 100, 50, 50, new State("Lower Austria")));
        clickableAreas.add(new ClickableArea(440, 125, 50, 50, new State("Upper Austria")));
        clickableAreas.add(new ClickableArea(700, 126, 50, 50, new State("Vienna")));

        clickableAreas.add(new ClickableArea(685, 270, 50, 50, new State("Burgenland")));
        clickableAreas.add(new ClickableArea(420, 350, 50, 50, new State("Carinthia")));
        clickableAreas.add(new ClickableArea(370, 245, 50, 50, new State("Salzburg")));

        clickableAreas.add(new ClickableArea(170, 280, 50, 50, new State("Tyrol")));
        clickableAreas.add(new ClickableArea(30, 280, 50, 50, new State("Vorarlberg")));
        clickableAreas.add(new ClickableArea(570, 250, 50, 50, new State("Styria")));

        return clickableAreas;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
