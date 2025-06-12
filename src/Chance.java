import java.util.Scanner;
import java.util.Random;

public class Chance {
    public void loseOrWin(Player player){
        int money = player.getMoney();
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.println(" ----------- Lose or Win Oyununa Hoşgeldiniz ! ----------- ");
        System.out.println();

        System.out.println("Şans oyununun içinde kırmızının mı mavinin mi kazandıracağını bul yatırdığın paranın 2 katı hesabına yüklensin !");
        System.out.println("UYARI : Oyuna maksimum paranızın yarısı kadar katılabilirsiniz");
        System.out.println();
        System.out.println("Bakiyeniz: " + player.getMoney() + " TL");
        System.out.print("Oyuna kaç para yüklemek istiyorsunuz : ");

        double yatMoney = scan.nextDouble();

        while (yatMoney <= 0 || yatMoney > money / 2.0) {
            System.out.print("Geçersiz miktar! Lütfen tekrar giriniz (Max: " + (player.getMoney() / 2) +" tutarında işlem yapabilirsiniz.");
            yatMoney = scan.nextDouble();
        }

        scan.nextLine();
        System.out.print("Kırmızı mı, Mavi mi? (kırmızı/mavi) : ");
        String secim = scan.nextLine().toLowerCase();

        while (!(secim.equals("kırmızı") || secim.equals("mavi"))) {
            System.out.print("Sadece 'kırmızı' ya da 'mavi' yazabilirsiniz: ");
            secim = scan.nextLine().toLowerCase();
        }


        String[] renkler = {"kırmızı", "mavi"};
        String dogruRenk = renkler[rand.nextInt(2)];

        System.out.println("Çekiliş yapılıyor...");
        System.out.println("Seçilen renk: " + dogruRenk);

        if (secim.equals(dogruRenk)) {
            System.out.println("Tebrikler! Kazandınız.");
            player.setMoney(player.getMoney() + (int) yatMoney);
        } else {
            System.out.println("Üzgünüm, kaybettiniz.");
            player.setMoney(player.getMoney() - (int) yatMoney);
        }

        System.out.println("Yeni bakiyeniz : " + player.getMoney()  );
    }

    public void randomArmor(Player player){
        System.out.println(" ----------- Random Armor Oyununa Hoşgeldiniz ! ----------- ");
        System.out.println(" Oyuna giriş ücreti 25 'tir ");
        System.out.println(" Bakiyenizdeki 25 lira sayesinde rastgele bir zırha sahip olabilirsiniz !");
        System.out.println();

        if (player.getMoney() < 25) {
            System.out.println("Yetersiz bakiye! Şu an paranız: " + player.getMoney());
            return;
        }

        player.setMoney(player.getMoney() - 25);

        Random rand = new Random();
        int chance = rand.nextInt(3);

        int avoid = 0;
        String aName = "";

        switch (chance) {
            case 0:
                avoid = 1;
                aName = "Hafif Zırh";
                break;
            case 1:
                avoid = 3;
                aName = "Orta Zırh";
                break;
            case 2:
                avoid = 5;
                aName = "Ağır Zırh";
                break;
        }

        player.getInv().setArmor(avoid);
        player.getInv().setaName(aName);

        System.out.println("Tebrikler! " + aName + " kazandınız. Engellenen hasar: " + avoid);
        System.out.println("Kalan Para : " + player.getMoney());


    }
    public void randomGun(Player player) {
        System.out.println(" ----------- Random Silah Oyununa Hoşgeldiniz ! ----------- ");
        System.out.println(" Oyuna giriş ücreti 35 'tir ");
        System.out.println(" Bakiyenizdeki 35 lira sayesinde rastgele bir silah sahibi olabilirsiniz !");
        System.out.println();

        if (player.getMoney() < 35) {
            System.out.println("Yetersiz bakiye! Şu an paranız: " + player.getMoney());
            return;
        }

        player.setMoney(player.getMoney() - 35);

        Random rand = new Random();
        int chance = rand.nextInt(3);

        int damage = 0;
        String wName = "";

        switch (chance) {
            case 0:
                damage = 2;
                wName = "Tabanca";
                break;
            case 1:
                damage = 3;
                wName = "Kılıç";
                break;
            case 2:
                damage = 7;
                wName = "Tüfek";
                break;
        }

        player.getInv().setDamage(damage);
        player.getInv().setwName(wName);

        System.out.println("Tebrikler! " + wName + " kazandınız. Hasar: " + damage);
        System.out.println("Kalan Para : " + player.getMoney());
    }

}
