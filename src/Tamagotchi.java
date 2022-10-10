//Trabalho do Grau A - Tamagotchi
//Nome: Pedro Christmann de Quadros
//Data: 10/10/2022

//Classe em que os atributos do Tamagotchi são definidos e os métodos de alterá-los também.

import lombok.*;

import java.util.Scanner;
import java.util.Locale;


@Data
public class Tamagotchi {
    private String nome;
    private int idade;
    private double peso;
    private int cont_sono;
    private boolean vivo;
    private int mood;
    Scanner myObj = new Scanner(System.in).useLocale(Locale.US);

    public Tamagotchi(String nome, int idade, double peso, boolean vivo) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.vivo = vivo;
    }
    //Método dormir
    public void dormir() {
        this.idade++;
        this.cont_sono = 0;
    }
    //Método morrer
    public void morrer() {
        this.vivo = false;
    }

    //Método comer muito
    public void comer_muito () {
        this.peso += 5;
        if (peso < 20) {
            dormir();
        }
    }

    //Método status
    public void status () {
        System.out.println("---------------\nNome: " + nome + "\nIdade: " + idade + "\nPeso: " + peso+"\n---------------");
    }

}




