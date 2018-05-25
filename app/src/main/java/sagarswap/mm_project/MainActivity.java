package sagarswap.mm_project;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private static int SPLASH_TIME_OUT=4000;
    private TextView splash_text1, splash_text2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splash_text1=findViewById(R.id.ModulusMotors);
        splash_text2=findViewById(R.id.Welcome);
        handleAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent homeIntent=new Intent(MainActivity.this, Main_Page.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    public void handleAnimation()
    {
        ObjectAnimator fadeIn1=ObjectAnimator.ofFloat(splash_text1, "alpha", 0.1f, 1f);
        fadeIn1.setDuration(1000);
        fadeIn1.setRepeatCount(5);
        ObjectAnimator fadeIn2=ObjectAnimator.ofFloat(splash_text2, "alpha", 0.1f, 1f);
        fadeIn2.setDuration(1000);
       fadeIn2.setRepeatCount(5);
        /*ObjectAnimator fadeOut = ObjectAnimator.ofFloat(splash_text1, "alpha",  1f, .3f);
        fadeOut.setDuration(2000);*/
        AnimatorSet aSet=new AnimatorSet();
        aSet.play(fadeIn1).with(fadeIn2);
        aSet.start();
    }
}
