package com.altnts.abcanimals;

import android.app.ActionBar;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class PageIndicatorActivity extends Activity {
	
	
	private static MediaPlayer mediaPlayer;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("ABC & Animals");
		//getActionBar().setIcon(R.drawable.icon);
		ActionBar actionBar = getActionBar();
		actionBar.setIcon(R.drawable.icon);

		
		ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageArra);
		final ViewPager myPager = (ViewPager) findViewById(R.id.myfivepanelpager);

		myPager.setAdapter(adapter);

		myPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				
				
				
				
				int currentItem = myPager.getCurrentItem();

				mediaPlayer = MediaPlayer.create(getApplicationContext(),
						myMusic_[currentItem]);
				mediaPlayer.setLooping(false);

				mediaPlayer.start();

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

		myPager.setOnTouchListener(new View.OnTouchListener() {
			private boolean moved;

			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
					moved = false;
				}
				if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
					moved = true;
				}
				if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
					if (!moved) {
						view.performClick();
					}
				}

				return false;
			}
		});

		myPager.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
/*
				int currentItem = myPager.getCurrentItem();
				Toast.makeText(getApplicationContext(),
						AnimalText[currentItem], Toast.LENGTH_LONG).show();

				/*
				 * MediaPlayer mPlayer2; mPlayer2 =
				 * MediaPlayer.create(getApplicationContext(),
				 * myMusic[currentItem]); // mPlayer2.stop(); mPlayer2.start();
				 */
			}

		});

		myPager.setCurrentItem(0);
	}
	
	
	//mediaPlayer-object will not we cleaned away since someone holds a reference to it!

	// int[] myMusic ={ R.raw.a, R.raw.b, R.raw.c, R.raw.d, R.raw.e};
	public int[] myMusic_ = { R.raw.ant, R.raw.bear, R.raw.camel, R.raw.dog, R.raw.elephant, R.raw.frog, R.raw.giraffe, R.raw.horse,
			R.raw.iguana, R.raw.jaguar, R.raw.kangaroo, R.raw.lion, R.raw.monkey, R.raw.nurse, R.raw.owl, R.raw.penguin, R.raw.rabbit, R.raw.seal,
			R.raw.turtle,  R.raw.umbrella, R.raw.vulture, R.raw.wolf, R.raw.yak, R.raw.zebra};

	public String AnimalText[] = { "Horse", "Cow", "Dog", "Rabbit", "Cat" };

	private int imageArra[] = { R.drawable.ant, R.drawable.bear,
			R.drawable.camel, R.drawable.dog, R.drawable.elephant,
			R.drawable.frog, R.drawable.giraffe, R.drawable.horse,
			R.drawable.iguana, R.drawable.jaguar, R.drawable.kangaroo,
			R.drawable.lion, R.drawable.monkey,R.drawable.nurse, R.drawable.owl,
			R.drawable.penguin, R.drawable.rabbit, R.drawable.seal,
			R.drawable.turtle, R.drawable.umbrella, R.drawable.vulture, R.drawable.wolf,
			R.drawable.yak, R.drawable.zebra };

}
