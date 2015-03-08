package com.helinshiah.splunch;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.helinshiah.splunch.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void login(View view) {
        Intent intent = new Intent(this, DisplayLogin.class);
        EditText email = (EditText) findViewById(R.id.edit_email);
        EditText password = (EditText) findViewById(R.id.edit_password);
        if (email.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            intent.putExtra(EXTRA_MESSAGE, email.getText().toString());
            startActivity(intent);
        }
        else {
            TextView errorText = (TextView) findViewById(R.id.login_error);
            errorText.setTextSize(40);
            errorText.setText("try again");
        }
    }
}
