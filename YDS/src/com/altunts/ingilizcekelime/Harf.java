package com.altunts.ingilizcekelime;

import com.altunts.ingilizcekelime.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Harf extends Activity {

	public Button Start;
	public Button BtnA;
	public Button BtnB;
	public Button BtnC;
	public Button BtnD;
	public Button BtnE;
	public Button BtnF;
	public Button BtnG;
	public Button BtnH;
	public Button BtnI;
	public Button BtnJ;
	public Button BtnK;
	public Button BtnL;
	public Button BtnM;
	public Button BtnN;
	public Button BtnO;
	public Button BtnP;
	public Button BtnR;
	public Button BtnS;
	public Button BtnT;
	public Button BtnU;
	public Button BtnV;
	public Button BtnW;
	public Button BtnY;
	public Button BtnZ;

	public void init() {
		BtnA = (Button) findViewById(R.id.ButtonA);
		BtnB = (Button) findViewById(R.id.ButtonB);
		BtnC = (Button) findViewById(R.id.ButtonC);
		BtnD = (Button) findViewById(R.id.ButtonD);
		BtnE = (Button) findViewById(R.id.ButtonE);
		BtnF = (Button) findViewById(R.id.ButtonF);
		BtnG = (Button) findViewById(R.id.ButtonG);
		BtnH = (Button) findViewById(R.id.ButtonH);
		BtnI = (Button) findViewById(R.id.ButtonI);
		BtnJ = (Button) findViewById(R.id.ButtonJ);
		BtnK = (Button) findViewById(R.id.ButtonK);
		BtnL = (Button) findViewById(R.id.ButtonL);
		BtnM = (Button) findViewById(R.id.ButtonM);
		BtnN = (Button) findViewById(R.id.ButtonN);
		BtnO = (Button) findViewById(R.id.ButtonO);
		BtnP = (Button) findViewById(R.id.ButtonP);
		BtnR = (Button) findViewById(R.id.ButtonR);
		BtnS = (Button) findViewById(R.id.ButtonS);
		BtnT = (Button) findViewById(R.id.ButtonT);
		BtnU = (Button) findViewById(R.id.ButtonU);
		BtnV = (Button) findViewById(R.id.ButtonV);
		BtnW = (Button) findViewById(R.id.ButtonW);
		BtnY = (Button) findViewById(R.id.ButtonY);
		BtnZ = (Button) findViewById(R.id.ButtonZ);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.harf);
		init();
		setTitle(" YDS KPDS Kelime Rehberi");
		//getActionBar().setIcon(R.drawable.icon);

		BtnA.setOnClickListener(onClickListener);
		BtnB.setOnClickListener(onClickListener);
		BtnC.setOnClickListener(onClickListener);
		BtnD.setOnClickListener(onClickListener);
		BtnE.setOnClickListener(onClickListener);
		BtnF.setOnClickListener(onClickListener);
		BtnG.setOnClickListener(onClickListener);
		BtnH.setOnClickListener(onClickListener);
		BtnI.setOnClickListener(onClickListener);
		BtnJ.setOnClickListener(onClickListener);
		BtnK.setOnClickListener(onClickListener);
		BtnL.setOnClickListener(onClickListener);
		BtnM.setOnClickListener(onClickListener);
		BtnN.setOnClickListener(onClickListener);
		BtnO.setOnClickListener(onClickListener);
		BtnP.setOnClickListener(onClickListener);
		BtnR.setOnClickListener(onClickListener);
		BtnS.setOnClickListener(onClickListener);
		BtnT.setOnClickListener(onClickListener);
		BtnU.setOnClickListener(onClickListener);
		BtnV.setOnClickListener(onClickListener);
		BtnW.setOnClickListener(onClickListener);
		BtnY.setOnClickListener(onClickListener);
		BtnZ.setOnClickListener(onClickListener);
	}

	private OnClickListener onClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.ButtonA:

				Intent a = new Intent(getApplicationContext(), Kelime.class);
				a.putExtra("harf", "a");
				startActivity(a);

				break;
			case R.id.ButtonB:
				Intent b = new Intent(getApplicationContext(), Kelime.class);
				b.putExtra("harf", "b");
				startActivity(b);

				break;
			case R.id.ButtonC:

				Intent c = new Intent(getApplicationContext(), Kelime.class);
				c.putExtra("harf", "c");
				startActivity(c);

				break;
			case R.id.ButtonD:

				Intent d = new Intent(getApplicationContext(), Kelime.class);
				d.putExtra("harf", "d");
				startActivity(d);

				break;

			case R.id.ButtonE:
				Intent e = new Intent(getApplicationContext(), Kelime.class);
				e.putExtra("harf", "e");
				startActivity(e);

				break;
			case R.id.ButtonF:

				Intent f = new Intent(getApplicationContext(), Kelime.class);
				f.putExtra("harf", "f");
				startActivity(f);

				break;
			case R.id.ButtonG:

				Intent g = new Intent(getApplicationContext(), Kelime.class);
				g.putExtra("harf", "g");
				startActivity(g);

				break;
			case R.id.ButtonH:
				Intent h = new Intent(getApplicationContext(), Kelime.class);
				h.putExtra("harf", "h");
				startActivity(h);

				break;
			case R.id.ButtonI:

				Intent i = new Intent(getApplicationContext(), Kelime.class);
				i.putExtra("harf", "i");
				startActivity(i);

				break;
			case R.id.ButtonJ:

				Intent j = new Intent(getApplicationContext(), Kelime.class);
				j.putExtra("harf", "j");
				startActivity(j);

				break;

			case R.id.ButtonK:
				Intent k = new Intent(getApplicationContext(), Kelime.class);
				k.putExtra("harf", "k");
				startActivity(k);

				break;
			case R.id.ButtonL:

				Intent l = new Intent(getApplicationContext(), Kelime.class);
				l.putExtra("harf", "l");
				startActivity(l);

				break;
			case R.id.ButtonM:

				Intent m = new Intent(getApplicationContext(), Kelime.class);
				m.putExtra("harf", "m");
				startActivity(m);

				break;
			case R.id.ButtonN:
				Intent n = new Intent(getApplicationContext(), Kelime.class);
				n.putExtra("harf", "n");
				startActivity(n);

				break;
			case R.id.ButtonO:

				Intent o = new Intent(getApplicationContext(), Kelime.class);
				o.putExtra("harf", "o");
				startActivity(o);

				break;
			case R.id.ButtonP:

				Intent p = new Intent(getApplicationContext(), Kelime.class);
				p.putExtra("harf", "p");
				startActivity(p);

				break;

			case R.id.ButtonR:
				Intent r = new Intent(getApplicationContext(), Kelime.class);
				r.putExtra("harf", "r");
				startActivity(r);

				break;
			case R.id.ButtonS:

				Intent s = new Intent(getApplicationContext(), Kelime.class);
				s.putExtra("harf", "s");
				startActivity(s);

				break;
			case R.id.ButtonT:
				Intent t = new Intent(getApplicationContext(), Kelime.class);
				t.putExtra("harf", "t");
				startActivity(t);

				break;
			case R.id.ButtonU:

				Intent u = new Intent(getApplicationContext(), Kelime.class);
				u.putExtra("harf", "o");
				startActivity(u);

				break;
			case R.id.ButtonV:

				Intent vn = new Intent(getApplicationContext(), Kelime.class);
				vn.putExtra("harf", "v");
				startActivity(vn);

				break;

			case R.id.ButtonW:
				Intent w = new Intent(getApplicationContext(), Kelime.class);
				w.putExtra("harf", "w");
				startActivity(w);

				break;
			case R.id.ButtonY:
				Intent y = new Intent(getApplicationContext(), Kelime.class);
				y.putExtra("harf", "y");
				startActivity(y);

				break;
			case R.id.ButtonZ:

				Intent z = new Intent(getApplicationContext(), Kelime.class);
				z.putExtra("harf", "z");
				startActivity(z);

				break;

			}

		};

	};

}
