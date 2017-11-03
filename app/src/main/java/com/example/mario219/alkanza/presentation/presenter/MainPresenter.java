package com.example.mario219.alkanza.presentation.presenter;

import android.util.Log;

import com.example.mario219.alkanza.presentation.view.contract.MainView;

import java.util.Random;

import static com.example.mario219.alkanza.BuildConfig.BASE_URL;

/**
 * Created by mario219 on 2/11/17.
 */

public class MainPresenter {

    private static final String TAG = MainPresenter.class.getSimpleName();

    private MainView view;
    private int counter1 = 0;
    private int counter2 = 0;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void generateImagesUrl() {
        int random = generateRandom();
        String firstImageUrl = BASE_URL.concat(String.valueOf(random));
        view.loadFirstImage(firstImageUrl);
        random = generateRandom();
        String secondImageUrl = BASE_URL.concat(String.valueOf(random));
        view.loadSecondImage(secondImageUrl);
    }

    private int generateRandom() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(1000);
    }

    public void countOne() {
        counter1++;
        view.update1(counter1);
    }

    public void countTwo() {
        counter2++;
        view.update2(counter2);
    }
}
