package com.example.myapplication;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String TAG = "StartActivity";
        // Вызывается при создании Активности
    private Integer count = 20000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreate");
        // Вызывается после завершения метода onCreate
        // Используется для восстановления состояния UI
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("count")) {
            count = savedInstanceState.getInt("count");
            super.onRestoreInstanceState(savedInstanceState);
            Toast.makeText(this, "onRestoreInstanceState()", Toast.LENGTH_LONG).show();
            Log.d(TAG, "onRestoreInstanceState");
        }}
    private void resetUI() {
        ((TextView) findViewById(R.id.txt_counter)).setText(count.toString());
        Log.d(TAG, "resetUI");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onRestart");
        // Восстановить состояние UI с учетом того,
        // что данная Активность уже была видимой.
        // Вызывается, когда Активность стала видимой
    }
    @Override
    public void onStart() {
        super.onStart();
        resetUI();
        Toast.makeText(this, "onStart()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStart");
        // Проделать необходимые действия для
        // Активности, видимой на экране
        // Должен вызываться в начале видимого состояния.
        // На самом деле Android вызывает данный обработчик только
        // для Активностей, восстановленных из неактивного состояния
    }
    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onResume");
        // Восстановить приостановленные обновления UI,
        // потоки и процессы, замороженные, когда
        // Активность была в неактивном состоянии
        // Вызывается перед выходом из активного состояния,
        // позволяя сохранить состояние в объекте savedInstanceState
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        // Объект savedInstanceState будет в последующем
        // передан методам onCreate и onRestoreInstanceState
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
        Log.d(TAG, "onSaveInstanceState");
        Toast.makeText(this, "onSaveInstanceState()", Toast.LENGTH_LONG).show();
    }
    // Вызывается перед выходом из активного состояния
    @Override
    public void onPause(){
        // «Заморозить» обновления UI, потоки или
        // «трудоемкие» процессы, не нужные, когда Активность
        // не на переднем плане
        super.onPause();
        Log.d(TAG, "onPause");
        Toast.makeText(this, "onPause()", Toast.LENGTH_LONG).show();
        // Вызывается перед выходом из видимого состояния
    }

    @Override
    public void onStop(){
        // «Заморозить» обновления UI, потоки или
        // «трудоемкие» процессы, ненужные, когда Активность
        // не на переднем плане.
        // Сохранить все данные и изменения в UI, так как
        // процесс может быть в любой момент убит системой
        super.onStop();
        Log.d(TAG, "onStop");
        Toast.makeText(this, "onStop()", Toast.LENGTH_LONG).show();
        // Вызывается перед уничтожением активности
    }
    @Override
    public void onDestroy(){
        // Освободить все ресурсы, включая работающие потоки,
        // соединения с БД и т. д.
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_LONG).show();
    }


}