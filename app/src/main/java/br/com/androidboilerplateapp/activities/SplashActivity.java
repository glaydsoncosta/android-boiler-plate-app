/*

    Description: This activity is showed while the app is loaded to the device memory.
                 Note that here we're not setting any kind of delay or sleep similar to slow down
                 the loading speed, instead of it we use the time it takes to Android put our app
                 in the device memory, so if we're doing a "hot reloading" the splash screen loads
                 faster else it takes the normal Android app loading time.
    Author: Glaydson Costa (github.com/glaydsoncosta)
    Date: 27-06-2018

 */

package br.com.androidboilerplateapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Just creating our MainActivity and showing it
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
