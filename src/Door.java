public class Door {
    String name;
    boolean hasGoat;
    boolean hasCar;
    boolean isPlayerDoor;

    public Door(String name,boolean hasGoat, boolean hasCar,boolean isPlayerDoor) {
        this.name = name;
        this.hasGoat = hasGoat;
        this.hasCar = hasCar;
        this.isPlayerDoor = isPlayerDoor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasCar() {
        return hasCar;
    }

    public void setHasCar(boolean hasCar) {
        this.hasCar = hasCar;
    }

    public boolean isHasGoat() {
        return hasGoat;
    }

    public void setHasGoat(boolean hasGoat) {
        this.hasGoat = hasGoat;
    }

    public boolean isPlayerDoor() {
        return isPlayerDoor;
    }

    public void setPlayerDoor(boolean playerDoor) {
        isPlayerDoor = playerDoor;
    }
}


