public class SaveHouse extends NormalLoc {
    public SaveHouse(Player player) {
        super(player, "Güvenli Ev");

    }
    public boolean getLocation(){
        player.setHealthy(player.getrHealthy());
        System.out.println("İyileştiniz...");
        System.out.println("Şuan Güvenli Ev adlı yerdesiniz");
        return true;
    }
}
