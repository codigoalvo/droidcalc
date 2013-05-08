package codigoalvo.droidcalc;

import java.util.*;
import codigoalvo.common.Coordenadas;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class ResultadoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultado);
		Intent intent = getIntent();
		List<Coordenadas> coords = (List<Coordenadas>)intent.getSerializableExtra("coordenadas");
		StringBuilder sb = new StringBuilder();
		Map<Double, Double> xyMap = new HashMap<Double, Double>();
		for (Coordenadas coord : coords) {
			xyMap.put(coord.getX(), coord.getY());
			sb.append("(").append(coord.getX()).append(", ").append(coord.getY()).append("); ");
		}
		codigoalvo.calcnumcomp.common.MinQuadradosResp resp = codigoalvo.calcnumcomp.service.MinimosQuadradosPearson.calculaMinQuadradoP(xyMap);
		TextView lblResultado = (TextView)findViewById(R.id.lblResultado);
		lblResultado.setText(sb.toString()+"\n\n"+resp.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_resultado, menu);
		return true;
	}

}
