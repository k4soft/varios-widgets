package co.com.otroswidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    AutoCompleteTextView autocomplete;
    ListView listView;
    String[] dias = new String[5];
    String [] items = new String[1000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        loadInformation();
        loadListViewInformation();
        onItemSelectedSpinner();
        setinfoAutocomplete();
        setInfoListView();
    }

    private void loadListViewInformation() {
        for(int i = 0; i < items.length; i++){
            items[i] = "Ítem ".concat((i+1)+"");
        }
    }

    private void setInfoListView() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item,items);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(MainActivity.this, getItem(i), Toast.LENGTH_SHORT).show();
        });
    }

    private void showToast(int i) {
        Toast.makeText(MainActivity.this, getDia(i), Toast.LENGTH_SHORT).show();
    }

    private void setinfoAutocomplete() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item,dias);
        autocomplete.setAdapter(arrayAdapter);
    }

    private void onItemSelectedSpinner() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,dias);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                showToast(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initComponents() {
        spinner =  findViewById(R.id.spinner);
        autocomplete = findViewById(R.id.autoComplete);
        listView = findViewById(R.id.listView);
    }

    private void loadInformation() {
        dias[0] = getString(R.string.lunes);
        dias[1] = getString(R.string.martes);
        dias[2] = getString(R.string.miercoles);
        dias[3] = getString(R.string.jueves);
        dias[4] = getString(R.string.viernes);
    }


    private String getDia(int index){
        return dias[index];
    }

    private String getItem(int index){
        return items[index];
    }
}