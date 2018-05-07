package com.usage.whattoeat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 선언부 */
        final RandomPick randomPick = new RandomPick();
        final TextView viewtext = (TextView)findViewById(R.id.viewText);

        findViewById(R.id.createButton).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String randomtext = randomPick.getRandTestString();
                        Toast.makeText(getApplicationContext(), randomtext, Toast.LENGTH_LONG).show();
                        viewtext.setText(randomtext);
                    }
                }
        );
    }


}
