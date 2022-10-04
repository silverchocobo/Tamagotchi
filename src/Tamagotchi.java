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

    public void dormir(){
        System.out.println(nome + " dormiu!");
        this.idade++;
        System.out.println("Idade: " + idade);
    }

    public void morrer(){
        this.vivo = false;
        System.out.println(nome +" morreu! :(");
    }

    public void sentirfome(){
        int escolha;
        System.out.println(nome + " está com fome, o que deseja fazer?");
        System.out.println("\n1 - Comer muito.\n2 - Comer pouco.\n3 - Não comer");
        escolha = myObj.nextInt();
        //Comer muito.
        if (escolha == 1) {
            comer_muito();
        }

        //Comer pouco
        if (escolha == 2) {
            System.out.println(nome + "comeu pouco.");
            setPeso(peso + 1);
            System.out.println("Peso:" + peso);
        }
        //Não comer
        if (escolha == 3) {
            System.out.println(nome + "não comeu nada");
            setPeso(peso - 2);
            System.out.println("Peso: " + peso);
        }

    }
    //Método comer muito
    public void comer_muito() {
        System.out.println(nome + " comeu muito!");
        this.peso += 5;
        System.out.println("Peso:" + peso);
        dormir();
    }
}



