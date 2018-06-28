/*

    Description: Empty activity for tests purposes only and to appear after the aplash screen
    Author: Glaydson Costa (github.com/glaydsoncosta)
    Date: 27-06-2018

 */

package br.com.androidboilerplateapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.androidboilerplateapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
