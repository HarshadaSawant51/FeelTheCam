package com.example.root.feelthecam;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
Button b1;
ImageButton b2;
ImageView i;
    Bitmap bitmap;
final static int picbycamera=10;
    Intent intent1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    b1=findViewById(R.id.button1);
    b2=findViewById(R.id.button2);
    i=findViewById(R.id.imageView);
    InputStream inputStream=getResources().openRawResource(R.drawable.image_three);
    bitmap= BitmapFactory.decodeStream(inputStream);

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                getApplicationContext().setWallpaper(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(MainActivity.this,"FEEL",Toast.LENGTH_SHORT).show();


        }
    });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent1=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent1,picbycamera);
                Toast.makeText(MainActivity.this,"LOOK",Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return  true;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK)
        {
            Bundle extras=data.getExtras();
            bitmap=(Bitmap)extras.get("data");
            i.setImageBitmap(bitmap);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.item1:
                Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(MainActivity.this, "Exit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
