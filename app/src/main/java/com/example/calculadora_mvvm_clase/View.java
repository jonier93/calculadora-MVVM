package com.example.calculadora_mvvm_clase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class View extends AppCompatActivity {
    private EditText txtNum1;
    private EditText txtNum2;
    private TextView txvResultado;
    private RadioButton rdSumar;
    private RadioButton rdRestar;
    private  RadioButton rdMultiplicar;
    private RadioButton rdDividir;
    private Button btnCalcular;
    private Model objModel;
    private MyViewModel objViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();

        btnCalcular.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                objModel.setNum1(Double.parseDouble(txtNum1.getText().toString()));
                objModel.setNum2(Double.parseDouble(txtNum2.getText().toString()));
                operacion();
                objViewModel.setResultado(objModel.getResultado());
            }
        });

        Observer<Double> objObserver = new Observer<Double>() {
            @Override
            public void onChanged(Double resultado) {
                txvResultado.setText(String.valueOf(resultado));
            }
        };

        objViewModel.getResultado().observe(this, objObserver);

    }

    private void inicializar() {
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        txvResultado = findViewById(R.id.txvResultado);
        rdSumar = findViewById(R.id.rdSumar);
        rdRestar = findViewById(R.id.rdRestar);
        rdMultiplicar = findViewById(R.id.rdMultiplicar);
        rdDividir = findViewById(R.id.rdDividir);
        btnCalcular = findViewById(R.id.btnCalcular);
        objModel = new Model();
        objViewModel = new ViewModelProvider(this).get(MyViewModel.class);
    }

    private void operacion(){
        if (rdSumar.isChecked()) {
            objModel.sumar();
        }
        else if (rdRestar.isChecked()) {
            objModel.restar();
        }
        else if (rdMultiplicar.isChecked()) {
            objModel.multiplicar();
        }
        else if (rdDividir.isChecked()) {
            objModel.dividir();
        }
        else {
            Toast.makeText(this, "Seleccione una operación", Toast.LENGTH_SHORT).show();
        }
    }
}