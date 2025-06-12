public class Information  {
    public void getInformation(Player player){
        System.out.println("Oyuncu Bilgileri");
        System.out.println();
        System.out.println("==================================");
        System.out.println();
        System.out.println("Karakter İsmi : "+player.getcName());
        System.out.println();
        System.out.println("Bakiye      : "+player.getMoney());
        System.out.println();
        System.out.println("Hasar       : "+player.getDamage());
        System.out.println();
        System.out.println("Can         : "+player.getHealthy());
        System.out.println();
        System.out.println("Armor       : "+player.getInv().getArmor());


    }


}
