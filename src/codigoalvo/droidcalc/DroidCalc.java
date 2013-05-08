package codigoalvo.droidcalc;

import java.io.Serializable;
import java.util.*;
import codigoalvo.common.Coordenadas;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.*;
import android.widget.ListView;

public class DroidCalc extends Activity {

	private List<Coordenadas> coord = new ArrayList<Coordenadas>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ListView contatosList = (ListView)findViewById(R.id.valores_list);
		
		coord.add(new Coordenadas(1,5));
		coord.add(new Coordenadas(3,3));
		coord.add(new Coordenadas(5,2));
		coord.add(new Coordenadas(7,-1));
		coord.add(new Coordenadas(8,-4));
		contatosList.setAdapter(new InputAdapter(this, R.layout.input_item, coord));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_droid_calc, menu);
		return true;
	}

	public void onCalcular(View view) {
		Intent calcIntent = new Intent(this, ResultadoActivity.class);
		calcIntent.putExtra("coordenadas", (Serializable)coord);
		startActivity(calcIntent);
	}

}
