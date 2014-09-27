package com.horizontalscrollviewwithpageindicator;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class PageIndicatorActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageArra);
		final ViewPager myPager = (ViewPager) findViewById(R.id.myfivepanelpager);

		myPager.setAdapter(adapter);

		myPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
/*
				int currentItem = myPager.getCurrentItem();
				

				MediaPlayer mPlayer2;
				mPlayer2 = MediaPlayer.create(getApplicationContext(),
						myMusic_[currentItem]);
				// mPlayer2.stop();
				mPlayer2.start();
				
			//	Toast.makeText(getApplicationContext(),"The name of this animal is "+currentItem, Toast.LENGTH_LONG).show();
			*/
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
		
		

		// then you can simply use the standard onClickListener ...
		myPager.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				int currentItem = myPager.getCurrentItem();
				Toast.makeText(getApplicationContext(), AnimalText[currentItem], Toast.LENGTH_LONG).show();
				
				MediaPlayer mPlayer2;
				mPlayer2 = MediaPlayer.create(getApplicationContext(),
						myMusic[currentItem]);
				// mPlayer2.stop();
				mPlayer2.start();
			}

		});

		myPager.setCurrentItem(0);
	}

	int[] myMusic ={ R.raw.a, R.raw.b, R.raw.c, R.raw.d, R.raw.e};
	int[] myMusic_ = { R.raw.horse_, R.raw.cow_, R.raw.dog_, R.raw.rabbit_, R.raw.cat_};


	public String AnimalText[] = { "Horse", "Cow", "Dog", "Rabbit", "Cat" };

	private int imageArra[] = { R.drawable.bear, R.drawable.camel, R.drawable.elephant, R.drawable.giraffe, R.drawable.penguin, R.drawable.turtle, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j,R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n, R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t,R.drawable.u, R.drawable.v, R.drawable.w, R.drawable.x, R.drawable.y, R.drawable.z };

    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
