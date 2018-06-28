# android-boiler-plate-app
A simple Android boilerplate app to do splash screens the right way


# Purpose
This is a simple Android app with some boilerplate coding and designs to help people on how to do a splash screen without using any kind of forced delays and sleeps.

# Basic explaining
When creating splash screens, the common approach is almost always:

1. Create an activity with some XML layout to represent the splash screen.
2. Before calling the main Activity put some kind (two or three seconds) of delay or sleep to show the splash screen to user. Simple, but bad!
3. After this forced delay (while you were merely doing nothing than causing the process to delay), call the main activity.

#### Question: Why is that approach bad?

#### Answer: Well, your're just delaying the user to enjoy the app. (IMHO)

# This approach

When Android loads an app to the memory this often takes a little amount of time, due to some internal operating system related things and it will depend of your device hadware configuration, this approach uses this time to show the splash screen, simple. More: When you finish your app, it is not totally unloaded from the memory, Android and iOS both work like this, to accelerate the next loading in case it occurs.

So, what we're doing here is just using this space of time (when the app is really being loaded to the memory) to show our splash screen. When it is loading from the first time, it could be a little bit fast, when hot reloading it will be very fast, so we will not do any kind of delaying, an this is an advantage and a more "professional approaching".

# Steps you need to follow

### 1. Create a layout layer which represents our splash screen content (in "drawable" folder):

```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:drawable="@color/splashBackground"/>
    <item>
        <bitmap
            android:gravity="center"
            android:src="@drawable/splash_icon" />
    </item>
</layer-list>
````

### 2. Modify our "styles.xml" to contain an Android Theme and point it to the drawable we just created:

```xml
<resources>
    <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>

    <!-- Theme we are using to our splash screen -->
    <style name="SplashTheme" parent="Theme.AppCompat.NoActionBar">
        <!-- Our pre-defined drawable which draw the splash background screen -->
        <item name="android:windowBackground">@drawable/splash_background</item>
    </style>
</resources>
```

### 3. Modify our "AndroidManifest.xml" to make a "detour", pointing our launcher screen to be our splash not the main activity:

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="br.com.androidboilerplateapp">
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <!-- Setting our launcher activity to be our splash screen activity -->
        <activity
            android:name=".activities.SplashActivity"
            android:theme="@style/SplashTheme">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity android:name=".activities.MainActivity"></activity>
    </application>
</manifest>
````
### 4. Create a new activity (i.e. "SplashActivity") wich will be loaded automatically and then it will call the main activity:

```java
...
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
```

### Following this steps the final result should be this:



Thanks for reading fell welcome to modify, extend or improve this source.

