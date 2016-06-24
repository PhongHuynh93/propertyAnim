package dhbk.android.a24propertyanim;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.sun)
    ImageView mSun;
    @BindView(R.id.cloud1)
    ImageView mCloud1;
    @BindView(R.id.cloud2)
    ImageView mCloud2;
    @BindView(R.id.ground)
    ImageView mGround;
    @BindView(R.id.window)
    ImageView mWindow;
    @BindView(R.id.wheel)
    ImageView mWheel;
    @BindView(R.id.car_layout)
    RelativeLayout mCarLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animated);
        ButterKnife.bind(this);

        // TODO: 6 apply anim
        applyAnim();

    }

    private void applyAnim() {
        // make wheel anim
        AnimatorSet wheelSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.wheel_spin);
        wheelSet.setTarget(mWheel);
        wheelSet.start();

        // make sun anim
        AnimatorSet sunSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.sun_swing);
        sunSet.setTarget(mSun);
        sunSet.start();

//        anim sky, tu mau xanh nhat chuyen sang mau xanh dam
        ObjectAnimator skyAnim = ObjectAnimator.ofInt(mCarLayout, "backgroundColor", Color.rgb(0x66, 0xcc, 0xff), Color.rgb(0x00, 0x66, 0x99));
        skyAnim.setDuration(3000);
        skyAnim.setRepeatCount(ValueAnimator.INFINITE);
        skyAnim.setRepeatMode(ValueAnimator.REVERSE);
        skyAnim.setEvaluator(new ArgbEvaluator());
        skyAnim.start();

//        sky anim
//        cloud 1
        ObjectAnimator cloudAnim = ObjectAnimator.ofFloat(mCloud1, "x", -350);
        cloudAnim.setDuration(3000);
        cloudAnim.setRepeatCount(ValueAnimator.INFINITE);
        cloudAnim.setRepeatMode(ValueAnimator.REVERSE);
        cloudAnim.start();

//        cloud 2
        ObjectAnimator cloudAnim2 = ObjectAnimator.ofFloat(mCloud2, "x", -300);
        cloudAnim2.setDuration(3000);
        cloudAnim2.setRepeatCount(ValueAnimator.INFINITE);
        cloudAnim2.setRepeatMode(ValueAnimator.REVERSE);
        cloudAnim2.start();
    }
}
