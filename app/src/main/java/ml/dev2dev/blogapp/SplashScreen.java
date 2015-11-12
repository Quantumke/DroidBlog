package ml.dev2dev.blogapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SplashScreen extends Activity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        TextView textViewa =(TextView) findViewById(R.id.textView);
//        Typeface customfont = Typeface.createFromAsset(getAssets(), "fonts/Windsong.ttf");
//        textViewa.setTypeface(customfont);


        new Handler().postDelayed(new Runnable() {

         /*
          * Showing splash screen with a timer. This will be useful when you
          * want to show case your app logo / company
          */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, SelectButton.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

    }

//    void startAnim(){
//        findViewById(R.id.avloadingIndicatorView).setVisibility(View.VISIBLE);
//    }
//
//    void stopAnim(){
//        findViewById(R.id.avloadingIndicatorView).setVisibility(View.GONE);
//    }
//
//    public  class custview extends TextView{
//
//        public custview(Context context, AttributeSet attrs) {
//            super(context);
//            this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Windsong.ttf"));
//        }
//    }
}
