package com.example.calculadora_mvvm_clase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Double> resultado;

    public MyViewModel(){
        resultado = new MutableLiveData<>();
    }

    public void setResultado(double resultado) {
        this.resultado.setValue(resultado);
    }

    public LiveData <Double> getResultado(){
        return resultado;
    }
}
