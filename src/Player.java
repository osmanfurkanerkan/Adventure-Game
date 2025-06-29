import java.util.Scanner;

public class Player {
    Scanner scan =new Scanner(System.in);
    private int damage, healthy ,money,rHealthy;
    private String name,cName;
    private Inventory inv;

    public Player(String cName) {
        this.cName = cName;
        this.inv=new Inventory();
    }

    public int getrHealthy() {
        return rHealthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }

    public void selectCha(){
        switch (chaMenu()){

            case 1:
                initPlayer("Samuray" , 5 ,21,15);
                break;
            case 2:
                initPlayer("Okçu " , 7,18,20);
                break;
            case 3:
                initPlayer("Şövalye",8,24,5);
                break;
            default:
                initPlayer("Samuray" , 5 ,21,15);
                break;

        }
        System.out.println("Karekteriniz Oluştu.");
        System.out.println("Karakter : " +getcName() +" , Hasar : " + getDamage() +" ,Sağlık : "+getHealthy() + ", Para : " +getMoney() );

    }
    public int chaMenu(){

        System.out.println("Lütfen bir karakter seçiniz : ");
        System.out.println();
        System.out.println("1 - TÜRÜ : Samuray   ,        HASAR : 5   ,       SAĞLIK : 21    ,     PARA :15 ");
        System.out.println("2 - TÜRÜ : Okçu      ,        HASAR : 7   ,       SAĞLIK : 18    ,     PARA :20 ");
        System.out.println("3 - TÜRÜ : Şövalye   ,        HASAR : 8   ,       SAĞLIK : 24    ,     PARA :5 ");
        System.out.println();
        System.out.print("Karakter Seçiminiz : ");
        int chaID=scan.nextInt();
        while(chaID<1 || chaID>3){
            System.out.print("Lütfen Gçeerli bir karakter seçiniz :");
            chaID=scan.nextInt();
        }
        return chaID;

    }

    public int getTotalDamage(){
        return this.getDamage()+this.getInv().getDamage();
    }
    public void initPlayer(String cName,int dmg, int healthy,int money){
        setcName(cName);
        setDamage(dmg);
        setHealthy(healthy);
        setMoney(money);
        setrHealthy(healthy);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }
}
