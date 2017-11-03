package com.example.mario219.alkanza.presentation.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mario219.alkanza.R;
import com.example.mario219.alkanza.presentation.presenter.MainPresenter;
import com.example.mario219.alkanza.presentation.view.contract.MainView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.imageButton2)
    ImageView image1;
    @BindView(R.id.imageButton)
    ImageView image2;
    @BindView(R.id.tvCounter1)
    TextView counter1;
    @BindView(R.id.tvCounter2)
    TextView counter2;

    /**
     * State
     */
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this);
        mainPresenter.generateImagesUrl();
        setListeners();
    }

    private void setListeners() {
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.generateImagesUrl();
                mainPresenter.countOne();
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.generateImagesUrl();
                mainPresenter.countTwo();
            }
        });
    }

    @Override
    public void loadFirstImage(String imageUrl) {
        Log.i(TAG, "First Url: " + imageUrl);
        Picasso
                .with(this)
                .load(imageUrl)
                .placeholder(R.mipmap.ic_launcher_round)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(image1);
    }

    @Override
    public void loadSecondImage(String imageUrl) {
        Log.i(TAG, "Second Url: " + imageUrl);
        Picasso
                .with(this)
                .load(imageUrl)
                .placeholder(R.mipmap.ic_launcher_round)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(image2);
    }

    @Override
    public void update1(int counter) {
        counter1.setText(valueOf(counter));
    }

    @Override
    public void update2(int counter) {
        counter2.setText(valueOf(counter));
    }
}
