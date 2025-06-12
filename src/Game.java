import java.util.Scanner;

public class Game {
    Scanner scan=new Scanner(System.in);
    Player player;
    Location location;
    Information info=new Information();
    Chance chance=new Chance();
    public void login(){

        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.print("Oyuna Başlamadan Önce İsminizi Giriniz : ");
        String playerName =scan.nextLine();
        player=new Player(playerName);
        player.selectCha();
        start();

    }
    public void start(){
        while(true){
            System.out.println();
            System.out.println("======================================");
            System.out.println();
            System.out.println("Eylem gerçekleştirmek için bir yer seçiniz : ");
            System.out.println("1- Güvenli Ev --> Size ait güvenli bir mekan , düşman yok");
            System.out.println("2- Mağara     --> Karşınıza belki zombi çıkabilir !");
            System.out.println("3- Orman      --> Karşınıza belki vampir çıkabilir !");
            System.out.println("4- Nehir      --> Karşınıza belki ayı çıkabilir !");
            System.out.println("5- Mağaza     --> Silah veya zırh alabilirsiniz !");
            System.out.println("6- Bilgiler   --> Karakteriniz hakkında bilgi alabilirsiniz !");
            System.out.println("7- Restart    --> Oyunu yeniden başlatabilirsiniz !");
            System.out.println("8- Şans Oyunu --> Paranızı şansınızı kullanarak katlayabilirsiniz !");
            System.out.println();

            System.out.print("Gitmek istediğiniz yer : ");
            int selloc =scan.nextInt();
            while (selloc<0||selloc>8){
                System.out.println("Lütfen geçerli bir yer seçiniz : ");
                selloc =scan.nextInt();

            }
            switch (selloc){
                case 1:
                    location= new SaveHouse(player);
                    break;
                case 2:
                    location=new Cave(player);
                    break;
                case 3:
                    location=new Forest(player);
                    break;
                case 4:
                    location=new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                case 6:
                    info.getInformation(player);
                    continue;
                case 7:
                    login();
                    break;
                case 8:
                    System.out.println("----------- Şans Oyunları -----------");
                    System.out.println("1 - Kırmızı mı Mavi mi (Lose or Win)");
                    System.out.println("2 - Rastgele Zırh");
                    System.out.println("3 - Rastgele Silah");
                    System.out.println("4 - Çıkış");
                    System.out.print("Bir oyun seçiniz: ");
                    int gameChoice = scan.nextInt();

                    switch (gameChoice) {
                        case 1:
                            chance.loseOrWin(player);
                            break;
                        case 2:
                            chance.randomArmor(player);
                            break;
                        case 3:
                            chance.randomGun(player);
                            break;
                        case 4:
                            System.out.println("Şans oyunlarından çıkılıyor.");
                            break;
                        default:
                            System.out.println("Geçersiz seçim.");
                            break;
                    }
                    continue;
                default:
                    location= new SaveHouse(player);
                    break;
            }
            if(location.getClass().getName().equals("SaveHouse")){
                if(player.getInv().isFirewood()&&player.getInv().isFood()&&player.getInv().isWater()){
                    System.out.println("Tebrikler oyunu kazandınız ! ");
                    break;
                }
            }
            if(!location.getLocation()){
                System.out.println("oyun bitti");
                break;
            }

        }
    }
}
