package com.example.calculadora_mvvm_clase;

public class Model {
    private double num1;
    private double num2;
    private double resultado;

    public Model() {
        num1 = 0;
        num2 = 0;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResultado(){
        return  resultado;
    }

    public void sumar() {
        resultado = num1 + num2;
    }

    public void restar() {
        resultado = num1 - num2;
    }

    public void multiplicar() {
        resultado = num1 * num2;
    }

    public  void dividir() {
        resultado = num1 / num2;
    }
}
