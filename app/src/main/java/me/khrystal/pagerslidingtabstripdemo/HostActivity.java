package me.khrystal.pagerslidingtabstripdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import me.khrystal.find_new_slidestrip.FifthActivity;
import me.khrystal.find_new_slidestrip.FourthActivity;
import me.khrystal.find_new_slidestrip.ThirdActivity;
import me.khrystal.test.ScrollViewActivity;

public class HostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_host, menu);
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

    public void first(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    public void second(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void third(View view) {
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }

    public void fourth(View view) {
        Intent intent = new Intent(this,FourthActivity.class);
        startActivity(intent);
    }
    public void fifth(View view) {
        Intent intent = new Intent(this,FifthActivity.class);
        startActivity(intent);
    }

    public void scroll(View view) {
        Intent intent = new Intent(this,ScrollViewActivity.class);
        startActivity(intent);
    }
}
