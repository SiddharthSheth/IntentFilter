package ln.intentfilter;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphActivity extends AppCompatActivity {

    EditText edX, edY;
    TextInputLayout inputX, inputY;
    Button btnCreateGraph;
    GraphView graph;
    int x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        edX = (EditText)findViewById(R.id.ed_x);
        edY = (EditText)findViewById(R.id.ed_y);
        inputX = (TextInputLayout) findViewById(R.id.til_x);
        inputX = (TextInputLayout) findViewById(R.id.til_y);
        graph = (GraphView) findViewById(R.id.graph);

        edX.addTextChangedListener(new MyTextWatcher(inputX));
        edX.addTextChangedListener(new MyTextWatcher(inputY));

        btnCreateGraph = (Button) findViewById(R.id.btn_graph);

        btnCreateGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                x = Integer.parseInt(edX.getText().toString());
                y = Integer.parseInt(edY.getText().toString());

                LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                        new DataPoint(1, 5),
                        new DataPoint(2, 10),
                        new DataPoint(4, 15),
                        new DataPoint(6, 20),
                        new DataPoint(x, y)
                });
                graph.addSeries(series);

            }
        });

    }

    private class MyTextWatcher implements TextWatcher {

        private View viewTextWatcher;

        private MyTextWatcher(View view) {
            this.viewTextWatcher = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        public void afterTextChanged(Editable editable) {

        }
    }

}
