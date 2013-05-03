package codigoalvo.droidcalc;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.*;
import android.widget.ListView;

public class DroidCalc extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ListView contatosList = (ListView)findViewById(R.id.valores_list);
		contatosList.setAdapter(new InputAdapter(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_droid_calc, menu);
		return true;
	}

	public void onCalcular(View view) {
		Intent calcIntent = new Intent(this, ResultadoActivity.class);
		startActivity(calcIntent);
	}

}
