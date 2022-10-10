//Trabalho do Grau A - Tamagotchi
//Nome: Pedro Christmann de Quadros
//Data: 10/10/2022

//Classe em que o comportamento do Tamagotchi é controlado a partir dos comandos do usuário.

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Locale;
import java.util.Scanner;

@Data
@NoArgsConstructor
public class Controle {
    private static int escolha;
    private static Scanner myObj = new Scanner(System.in).useLocale(Locale.US);

    public static void sentirSono(Tamagotchi tamagotchi1) {
        tamagotchi1.status();
        System.out.println(tamagotchi1.getNome() + " está com sono, o que deseja fazer?");
        Emoji.sonolento(tamagotchi1);
        System.out.println("\n1 - Dormir\n2- Permanecer acordado");
        escolha = myObj.nextInt();

        //Dormir
        if (escolha == 1) {
            tamagotchi1.dormir();
            verificaIdade(tamagotchi1);
            System.out.println(tamagotchi1.getNome() + " dormiu!");
            Emoji.dorminhoco(tamagotchi1);
        }

        //Ficar acordado
        else if (escolha == 2) {
            System.out.println(tamagotchi1.getNome() + " permaneceu acordado!");
            Emoji.acorda(tamagotchi1);
            tamagotchi1.setCont_sono(tamagotchi1.getCont_sono() + 1);
        }
        //Exausto
        if (tamagotchi1.getCont_sono() == 5) {
            tamagotchi1.dormir();
            System.out.println(tamagotchi1.getNome() + " ficou exausto e dormiu!");
            Emoji.dorminhoco(tamagotchi1);
            verificaIdade(tamagotchi1);
        }
    }

    public static void sentirFome(Tamagotchi tamagotchi1) {
        //tamagotchi1.sentirfome();
        tamagotchi1.status();
        System.out.println(tamagotchi1.getNome() + " está com fome, o que deseja fazer?");
        Emoji.faminto(tamagotchi1);
        System.out.println("\n1 - Comer muito.\n2 - Comer pouco.\n3 - Não comer");
        escolha = myObj.nextInt();
        //Comer muito.
        if (escolha == 1) {
            System.out.println(tamagotchi1.getNome() + " comeu muito!");
            Emoji.comendo(tamagotchi1);
            tamagotchi1.comer_muito();
            verificaPeso(tamagotchi1);
            if(tamagotchi1.isVivo()){
                System.out.println(tamagotchi1.getNome() + " dormiu!");
                Emoji.dorminhoco(tamagotchi1);
            }
        }
        if (escolha == 2) {
            System.out.println(tamagotchi1.getNome() + " comeu pouco.");
            Emoji.comendo(tamagotchi1);
            tamagotchi1.setPeso(tamagotchi1.getPeso() + 1);
            verificaPeso(tamagotchi1);
        }
        if (escolha == 3) {
            System.out.println(tamagotchi1.getMood() + " não comeu nada");
            Emoji.faminto(tamagotchi1);
            tamagotchi1.setPeso(tamagotchi1.getPeso() - 2);
            verificaPeso(tamagotchi1);
        }
    }


    public static void ficarEntediado(Tamagotchi tamagotchi1) {
        tamagotchi1.status();
        System.out.println(tamagotchi1.getNome() + " está entediado, o que deseja fazer?");
        Emoji.entediado(tamagotchi1);
        System.out.println("\n1 - Correr 10 minutos\n2 - Caminhar 10 minutos");
        escolha = myObj.nextInt();

        if (escolha == 1) {
            System.out.println(tamagotchi1.getNome() + " correu por 10 minutos!");
            Emoji.fadigado(tamagotchi1);
            tamagotchi1.setPeso(tamagotchi1.getPeso() - 4);
            verificaPeso(tamagotchi1);
            if (tamagotchi1.isVivo()) {
                System.out.println(tamagotchi1.getNome() + " comeu muito!");
                Emoji.comendo(tamagotchi1);
                tamagotchi1.comer_muito();
                verificaPeso(tamagotchi1);
                if (tamagotchi1.isVivo()) {
                    tamagotchi1.dormir();
                    System.out.println(tamagotchi1.getNome() + " dormiu!");
                }
            }
        }
        if (escolha == 2) {
            System.out.println(tamagotchi1.getNome() + " caminhou por 10 minutos!");
            Emoji.fadigado(tamagotchi1);
            tamagotchi1.setPeso(tamagotchi1.getPeso() - 1);
            verificaPeso(tamagotchi1);
            if (tamagotchi1.isVivo()) {
                sentirFome(tamagotchi1);
            }
        }
    }

    public static void verificaIdade(Tamagotchi tamagotchi1) {
        if (tamagotchi1.getIdade() >= 15) {
            tamagotchi1.morrer();
            System.out.println(tamagotchi1.getNome()+" morreu.\nEle já estava muito velhinho.");
            Emoji.morto(tamagotchi1);
        }
    }

    public static void verificaPeso(Tamagotchi tamagotchi1) {
        if (tamagotchi1.getPeso() >= 20) {
            tamagotchi1.morrer();
            System.out.println(tamagotchi1.getNome()+" morreu.\nEle comeu até explodir.");
            Emoji.morto(tamagotchi1);
        }

        else if (tamagotchi1.getPeso() <= 0) {
            tamagotchi1.morrer();
            System.out.println(tamagotchi1.getNome()+" morreu.\nEle ficou desnutrido.");
            Emoji.morto(tamagotchi1);
        }
    }
}
