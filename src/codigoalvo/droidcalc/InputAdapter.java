package codigoalvo.droidcalc;

import java.util.List;
import android.content.Context;
import android.view.*;
import android.widget.*;
import codigoalvo.common.Coordenadas;

public class InputAdapter extends ArrayAdapter<Coordenadas> {

	private List<Coordenadas> coordenadasLst;

	public InputAdapter(Context context, int textViewResourceId, List<Coordenadas> coordenadasLst) {
		super(context, textViewResourceId, coordenadasLst);
		this.coordenadasLst = coordenadasLst;
	}

	@Override
	public int getCount() {
		return coordenadasLst.size();
	}

	@Override
	public Coordenadas getItem(int position) {
		return coordenadasLst.get(position);
	}

	@Override
	public int getPosition(Coordenadas item) {
		return coordenadasLst.indexOf(item);
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View row = convertView;
		final Coordenadas coord = getItem(position);
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.input_item, parent, false);
		}
		EditText edtX = (EditText)row.findViewById(R.id.edtX);
		edtX.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View view, boolean isGetFocus) {
				if (!isGetFocus)
					coord.setX(Double.parseDouble(((EditText)view).getText().toString()));
			}
		});
		EditText edtY = (EditText)row.findViewById(R.id.edtY);
		edtY.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View view, boolean isGetFocus) {
				if (!isGetFocus)
					coord.setY(Double.parseDouble(((EditText)view).getText().toString()));
			}
		});
		edtX.setText(Double.toString(coord.getX()));
		edtY.setText(Double.toString(coord.getY()));
		Button btnAdd = (Button)row.findViewById(R.id.btnAdd);
		btnAdd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				insert(new Coordenadas(0.0d, 0.0d), position+1);
				notifyDataSetChanged();
			}
		});
		Button btnRmv = (Button)row.findViewById(R.id.btnRmv);
		btnRmv.setEnabled(getCount() > 1);
		btnRmv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				remove(coord);
				notifyDataSetChanged();
			}
		});
		return row;
	}

	@Override
	public void insert(Coordenadas object, int index) {
		coordenadasLst.add(index, object);
	}

	@Override
	public void remove(Coordenadas object) {
		coordenadasLst.remove(object);
	}
	
	

}
