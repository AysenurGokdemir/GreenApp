package com.gokdemir.aysenur.greenapp;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
 EditText edtBoy,edtKilo,edtName;
    Button btnHesapla;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id alma kısmı
        config.android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        context = this;

        edtBoy= (EditText) findViewById(R.id.boytxt);
        edtKilo= (EditText) findViewById(R.id.kilotxt);
        edtName= (EditText) findViewById(R.id.editTextName);
        btnHesapla= (Button) findViewById(R.id.hesapla);
         btnHesapla.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 // Bu kısımda boş olup olmadıklarını kontrol ettirdik. (isempty fonksiyonu)
                 if(edtBoy.getText().toString().isEmpty()||edtName.getText().toString().isEmpty()||edtKilo.getText().toString().isEmpty())
                 {

                     AlertDialog.Builder alert = new AlertDialog.Builder(context);
                     alert.setTitle("Uyarı").setMessage("Lütfen tüm alanları doldurunuz").show();

                 }else {
                     double boy = Double.parseDouble(edtBoy.getText().toString()) / 100;
                     double kilo = Double.parseDouble(edtKilo.getText().toString());
                     double sonuc = hesapla(kilo, boy);

                     Intent intent = new Intent(MainActivity.this, SonucActivity.class);
                     intent.putExtra("sonucum", sonuc);
                      /*

                      Aldığım id'yi firebaseın en üstteki parentına ekliyorum
                     çünkü bu uygulamayı herkese açtığımızda veriler birbirine karışmasın

                      */
                     DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child(config.android_id);
                     Model model = new Model();
                     model.isim = edtName.getText().toString();
                     model.boy = String.valueOf(boy);
                     model.kilo = String.valueOf(kilo);
                     model.sonuc = String.valueOf(sonuc);
                     dbRef.push().setValue(model);
                     startActivity(intent);
                 }
             }
         });
         }
    public double hesapla(double kilo,double boy){
        double islem=kilo/(boy*boy);
        return islem;

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(R.id.gecmisMenu==id){
            Intent intent=new Intent(MainActivity.this,GecmisActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }
}
