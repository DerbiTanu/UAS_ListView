package com.example.kristo_uas;



import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
   
    static String[] menu = {"Nasi", "Nasi Putih", "Nasi Goreng", 
                            "Mie Ayam", "Mie Goreng", "Ayam Goreng", 
                            "Ayam Gulai", "Ayam Rendang" };
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //membuat menu yang bertipe ListView
        //ListView01 adalah ListView yang kita slide ke layar hitam
        ListView menu = (ListView) findViewById(R.id.ListView01);
        
        menu.setAdapter(new BaseAdapter() {    
            @Override
            public View getView(int posisi, View gantiView, ViewGroup parent) {
            
                
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                
                //memanggil list_menu.xml yang dibuat
                View view = inflater.inflate(R.layout.list_menu, null);
                
                TextView textView = (TextView) view.findViewById(R.id.TextView01);
                
                textView.setText(MainActivity.menu[posisi]);
                return view;
            }
            
            @Override
            public long getItemId(int posisi) {
                // mengembalikan nilai posisi array
                return posisi;
            }
            
            @Override
            public Object getItem(int posisi) {
                return MainActivity.menu[posisi];
            }
            
            @Override
            public int getCount() {
                //mengembalikan jumlah dari menu
                return MainActivity.menu.length;
            }
        });   
    }    
}