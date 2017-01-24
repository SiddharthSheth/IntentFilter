package ln.intentfilter;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class CustomActivity extends AppCompatActivity {

    TextView txtDisplayWebsite;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        txtDisplayWebsite = (TextView) findViewById(R.id.txt_displaywebsite);
        Uri url = getIntent().getData();
        txtDisplayWebsite.setText(url.toString());
    }
}
