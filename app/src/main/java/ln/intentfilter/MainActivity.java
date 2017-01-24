package ln.intentfilter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnBrowser, btnActionLaunch, btnException;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBrowser = (Button)findViewById(R.id.btn_start_browser);
        btnActionLaunch= (Button)findViewById(R.id.btn_start_browserwithlaunch);
        btnException = (Button)findViewById(R.id.btn_exception);

        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBrowser = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.example.com"));
                startActivity(intentBrowser);
            }
        });

        btnActionLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentActionLaunch = new Intent("ln.intentfilter.CustomActivity.LAUNCH",
                        Uri.parse("http://www.example.com"));
                startActivity(intentActionLaunch);
            }
        });

        btnException.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentException = new Intent("ln.intentfilter.CustomActivity.LAUNCH",
                        Uri.parse("https://www.example.com"));
                startActivity(intentException);
            }
        });
    }
}
