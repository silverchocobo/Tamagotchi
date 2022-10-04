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

        System.out.println(tamagotchi1.getMood());
        int escolha;

        while (tamagotchi1.isVivo()) {
            tamagotchi1.setMood(1 + (int) (Math.random() * 3));
            //Sono
            if (tamagotchi1.getMood() == 1) {
                System.out.println(tamagotchi1.getNome() + " está com sono, o que deseja fazer?");
                System.out.println("\n1 - Dormir\n2- Permanecer acordado");
                escolha = myObj.nextInt();

                //Dormir
                if (escolha == 1) {
                    tamagotchi1.dormir();
                }

                //Ficar acordado
                else if (escolha == 2) {
                    System.out.println(tamagotchi1.getNome() + " permaneceu acordado!");
                    tamagotchi1.setCont_sono(tamagotchi1.getCont_sono() + 1);
                }
                //Exausto
                if (tamagotchi1.getCont_sono() == 5) {
                    tamagotchi1.dormir();
                }

            }
            //Fome
            if (tamagotchi1.getMood() == 2) {
                //tamagotchi1.sentirfome();
                System.out.println(tamagotchi1.getNome() + " está com fome, o que deseja fazer?");
                System.out.println("\n1 - Comer muito.\n2 - Comer pouco.\n3 - Não comer");
                escolha = myObj.nextInt();
                //Comer muito.
                if (escolha == 1) {
                    tamagotchi1.comer_muito();
                }

                //Morte
                if (tamagotchi1.getIdade() == 15) {
                    tamagotchi1.morrer();
                    System.out.println("Ele já estava muito velhinho.");
                }

                if (tamagotchi1.getPeso() == 20) {
                    tamagotchi1.morrer();
                    System.out.println("Ele comeu até explodir.");
                }

                if (tamagotchi1.getPeso() <= 0) {
                    tamagotchi1.morrer();
                    System.out.println("Ele ficou desnutrido.");
                }

                //Ficar entediado
                if (tamagotchi1.getMood() == 3) {
                    System.out.println(tamagotchi1.getNome() + " está entediado, o que deseja fazer?");
                    System.out.println("\n1 - Correr 10 minutos\n2 - Caminhar 10 minutos");
                    escolha = myObj.nextInt();

                    if (escolha == 1) {
                        System.out.println(tamagotchi1.getNome() + " correu por 10 minutos!");
                        tamagotchi1.setPeso(tamagotchi1.getPeso() - 4);
                        System.out.println("Peso:" + tamagotchi1.getPeso());
                        System.out.println(tamagotchi1.getNome() + " comeu muito!");
                        tamagotchi1.setPeso(tamagotchi1.getPeso() + 5);
                        System.out.println("Peso:" + tamagotchi1.getPeso());
                        tamagotchi1.dormir();
                    }
                    if (escolha == 2) {
                        System.out.println(tamagotchi1.getNome() + " caminhou por 10 minutos!");
                        tamagotchi1.setPeso(tamagotchi1.getPeso() - 1);
                        System.out.println("Peso:" + tamagotchi1.getPeso());
                        tamagotchi1.setMood(2);
                    }
                }

            }


        }
    }
}