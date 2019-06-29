package com.example.jakin.twoflair.chart;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.jakin.twoflair.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ClothDetails extends AppCompatActivity {

    TextView cloth_name,cloth_price,cloth_description;
    ImageView cloth_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;

    String clothId="";
    FirebaseDatabase database;

    DatabaseReference mcloth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_details);

        database = FirebaseDatabase.getInstance();
        mcloth = database.getReference("Photos");


        numberButton = (ElegantNumberButton)findViewById(R.id.number_button);
        btnCart=(FloatingActionButton)findViewById(R.id.btnCart);

        cloth_description = (TextView)findViewById(R.id.Cloth_description);
        cloth_name = (TextView)findViewById(R.id.cloth_name);
        cloth_price = (TextView)findViewById(R.id.cloth_Price);
        cloth_image = (ImageView)findViewById(R.id.img_cloth);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        //collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        //collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        //get id from intent
        if(getIntent() != null)
            clothId= getIntent().getStringExtra("clothId");

        if(!clothId.isEmpty())
        {
            getDetailCloth(clothId);
        }



    }

    private void getDetailCloth(String clothId) {
        mcloth.child(clothId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                 //upload Upload = dataSnapshot.getValue(upload.class);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
