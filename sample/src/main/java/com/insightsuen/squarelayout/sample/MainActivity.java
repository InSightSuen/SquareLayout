package com.insightsuen.squarelayout.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.insightsuen.squarelayout.SquareLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeMatchType(View view) {
        if (view instanceof SquareLayout) {
            SquareLayout squareLayout = (SquareLayout) view;
            int matchType = squareLayout.getMatchType();
            switch (matchType) {
                case SquareLayout.MATCH_WIDTH:
                    squareLayout.setMatchType(SquareLayout.MATCH_HEIGHT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    break;

                case SquareLayout.MATCH_HEIGHT:
                    squareLayout.setMatchType(SquareLayout.MATCH_LENGTH, 300);
                    break;

                case SquareLayout.MATCH_LENGTH:
                    squareLayout.setMatchType(SquareLayout.MATCH_WIDTH, ViewGroup.LayoutParams.WRAP_CONTENT);
                    break;
            }
        }
    }
}
