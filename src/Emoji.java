//Trabalho do Grau A - Tamagotchi
//Nome: Pedro Christmann de Quadros
//Data: 10/10/2022

//Classe em que os emojis que aparecem para expressar os sentimentos do Tmagotchi são configurados e definidos em métodos para serem chamados através da classe Controle.

public class Emoji {

    public static void feliz(Tamagotchi tamagotchi1) {
        int[] feliz = {0xD83D, 0xDE01};
        String emojifeliz = new String(feliz, 0, feliz.length);
        System.out.println(emojifeliz);
    }

    public static void sonolento(Tamagotchi tamagotchi1){
        int[] sono = {0xD83D, 0xDE2A};
        String emojisono = new String(sono, 0, sono.length);
        System.out.println(emojisono);
    }

    public static void dorminhoco(Tamagotchi tamagotchi1) {
        int[] dormindo = {0xD83D, 0xDE34};
        String emojidormindo = new String(dormindo, 0, dormindo.length);
        System.out.println(emojidormindo);
    }

    public static void acorda(Tamagotchi tamagotchi1) {
        int[] acordar = {0xD83D, 0xDE2A};
        String emojiacorda = new String(acordar, 0, acordar.length);
        System.out.println(emojiacorda);
    }

    public static void faminto(Tamagotchi tamagotchi1) {
        int[] fome = {0xD83D, 0xDE16};
        String emojifome = new String(fome, 0, fome.length);
        System.out.println(emojifome);
    }

    public static void morto(Tamagotchi tamagotchi1) {
        int[] morte = {0xD83D, 0xDE35};
        String emojimorte = new String(morte, 0, morte.length);
        System.out.println(emojimorte);
    }

    public static void entediado(Tamagotchi tamagotchi1) {
        int[] tedio = {0xD83D, 0xDE12};
        String emojitedio = new String(tedio, 0, tedio.length);
        System.out.println(emojitedio);
    }

    public static void fadigado(Tamagotchi tamagotchi1){
        int[] cansado = {0xD83D, 0xDE13};
        String emojicansado = new String(cansado, 0, cansado.length);
        System.out.println(emojicansado);
    }

    public static void comendo(Tamagotchi tamagotchi1){
        int[] comer = {0xD83D, 0xDE0B};
        String emojicomer = new String(comer, 0, comer.length);
        System.out.println(emojicomer);
    }


}


