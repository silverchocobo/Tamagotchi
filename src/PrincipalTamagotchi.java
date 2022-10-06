import java.lang.Math;
import java.util.Locale;
import java.util.Scanner;

public class PrincipalTamagotchi {
    public static void main(String[] args) {
        Tamagotchi tamagotchi1 = new Tamagotchi("", 0, 1, true);
        Scanner myObj = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("---Bem-vindo!---\nDigite o nome do seu Tamagotchi!");
        String x;
        x = myObj.nextLine();
        tamagotchi1.setNome(x);
        System.out.println("O nome dele é " + tamagotchi1.getNome() + "!");

        //int escolha;

        while (tamagotchi1.isVivo()) {
            tamagotchi1.setMood(1 + (int) (Math.random() * 3));
            System.out.println(tamagotchi1.getMood());
            //Sono
            if (tamagotchi1.getMood() == 1) {
                Controle.sentirSono(tamagotchi1);
            }

            //Fome
            else if (tamagotchi1.getMood() == 2) {
                Controle.sentirFome(tamagotchi1);
            }

            //Ficar entediado
            else if (tamagotchi1.getMood() == 3) {
                Controle.ficarEntediado(tamagotchi1);

            }
        }
    }
}