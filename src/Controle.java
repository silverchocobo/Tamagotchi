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
        System.out.println("\n1 - Dormir\n2- Permanecer acordado");
        escolha = myObj.nextInt();

        //Dormir
        if (escolha == 1) {
            tamagotchi1.dormir();
            verificaIdade(tamagotchi1);
            System.out.println(tamagotchi1.getNome() + " dormiu!");
        }

        //Ficar acordado
        else if (escolha == 2) {
            System.out.println(tamagotchi1.getNome() + " permaneceu acordado!");
            tamagotchi1.setCont_sono(tamagotchi1.getCont_sono() + 1);
        }
        //Exausto
        if (tamagotchi1.getCont_sono() == 5) {
            tamagotchi1.dormir();
            verificaIdade(tamagotchi1);
        }
    }

    public static void sentirFome(Tamagotchi tamagotchi1) {
        //tamagotchi1.sentirfome();
        tamagotchi1.status();
        System.out.println(tamagotchi1.getNome() + " está com fome, o que deseja fazer?");
        System.out.println("\n1 - Comer muito.\n2 - Comer pouco.\n3 - Não comer");
        escolha = myObj.nextInt();
        //Comer muito.
        if (escolha == 1) {
            tamagotchi1.comer_muito();
            verificaPeso(tamagotchi1);
        }
        if (escolha == 2) {
            System.out.println(tamagotchi1.getNome() + " comeu pouco.");
            tamagotchi1.setPeso(tamagotchi1.getPeso() + 1);
            verificaPeso(tamagotchi1);
        }
        if (escolha == 3) {
            System.out.println(tamagotchi1.getMood() + " não comeu nada");
            tamagotchi1.setPeso(tamagotchi1.getPeso() - 2);
            verificaPeso(tamagotchi1);
        }
    }

    public static void ficarEntediado(Tamagotchi tamagotchi1) {
        tamagotchi1.status();
        System.out.println(tamagotchi1.getNome() + " está entediado, o que deseja fazer?");
        System.out.println("\n1 - Correr 10 minutos\n2 - Caminhar 10 minutos");
        escolha = myObj.nextInt();

        if (escolha == 1) {
            System.out.println(tamagotchi1.getNome() + " correu por 10 minutos!");
            tamagotchi1.setPeso(tamagotchi1.getPeso() - 4);
            if (tamagotchi1.getPeso() <= 0) {
                tamagotchi1.morrer();
            }
            System.out.println(tamagotchi1.getNome() + " comeu muito!");
            tamagotchi1.comer_muito();
            verificaPeso(tamagotchi1);
            if (tamagotchi1.isVivo()) {
                tamagotchi1.dormir();
            }
        }
        if (escolha == 2) {
            System.out.println(tamagotchi1.getNome() + " caminhou por 10 minutos!");
            tamagotchi1.setPeso(tamagotchi1.getPeso() - 1);
            verificaPeso(tamagotchi1);
            if (tamagotchi1.isVivo()) {
                tamagotchi1.setMood(2);
            }
        }
    }

    public static void verificaIdade(Tamagotchi tamagotchi1) {
        if (tamagotchi1.getIdade() >= 15) {
            tamagotchi1.morrer();
            System.out.println("Ele já estava muito velhinho.");
        }
    }

    public static void verificaPeso(Tamagotchi tamagotchi1) {
        if (tamagotchi1.getPeso() >= 20) {
            tamagotchi1.morrer();
            System.out.println("Ele comeu até explodir.");
        }

        else if (tamagotchi1.getPeso() <= 0) {
            tamagotchi1.morrer();
            System.out.println("Ele ficou desnutrido.");
        }
    }
}
