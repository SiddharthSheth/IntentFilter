package ln.intentfilter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import app.minimize.com.seek_bar_compat.SeekBarCompat;

public class SliderActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBarCompat seekBarCompat;
    GraphView graph;
    public static int yAxis = 1;
    int temp=0,temp2=0;
    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        seekBarCompat = (SeekBarCompat) findViewById(R.id.materialSeekBar);
        graph = (GraphView) findViewById(R.id.graph);

        seekBarCompat.setThumbColor(Color.RED);
        seekBarCompat.setProgressColor(Color.CYAN);
        seekBarCompat.setProgressBackgroundColor(Color.BLUE);
        seekBarCompat.setThumbAlpha(128); //you can also set alpha value for the thumb


        seekBarCompat.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        yAxis = yAxis + 5;

        displayGraph(progress,yAxis);

    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        graph.addSeries(series);
    }

    public void displayGraph(int x, int y)
    {

        series = new LineGraphSeries<DataPoint>(new DataPoint[]{

                new DataPoint(temp,temp2),
                new DataPoint(x+1,y+3)
        });
        graph.addSeries(series);

        temp = x;
        temp2 = y;
    }

}
