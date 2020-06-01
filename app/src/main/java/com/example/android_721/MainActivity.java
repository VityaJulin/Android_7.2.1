package com.example.android_721;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText address;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        address = findViewById(R.id.edTxt_enter_address);
        search = findViewById(R.id.btn_search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userSearch = address.getText().toString();
                if (userSearch.equals("")) {
                    Toast.makeText(MainActivity.this, R.string.hint_enter_address, Toast.LENGTH_SHORT).show();
                    return;
                }

                Uri uri;
                if (isAddress(userSearch)) {
                    uri = Uri.parse("geo:?q=" + userSearch);
                } else {
                    uri = Uri.parse("geo:" + userSearch);
                }
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    public boolean isAddress(String string) {
        return Character.isLetter(string.charAt(0));
    }
}