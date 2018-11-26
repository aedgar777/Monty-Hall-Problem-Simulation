
import java.util.ArrayList;
import java.util.Random;

public class Main {
    Door door1;
    Door door2;
    Door door3;

    int winsWithoutSwitching;
    int winsWithSwitching;
    int totalPlays;




    public static void main(String[] args) {

       new Main().run100000simulations();
    }

    public void run100000simulations() {
        for (int i = 0; i < 100000; i++) {
            runSwitchSimulation();
            runStaySimulation();
            totalPlays++;
        }

        System.out.println("Staying with original door won " + winsWithoutSwitching + " out of " + totalPlays + " times");
        System.out.println("Switching after reveal won " + winsWithSwitching + " out of " + totalPlays + " times");
    }

    private void runSwitchSimulation() {
        assignDoors();


        ArrayList<Door> doorList = new ArrayList<Door>();

        doorList.add(door1);
        doorList.add(door2);
        doorList.add(door3);

        pickDoor();

        //simulates reveal of unchosen door with goat

        for (int i = 0; i < doorList.size(); i++) {
            if (doorList.get(i).hasGoat && !doorList.get(i).isPlayerDoor) {
                doorList.remove(i);
            }
        }

        //simulates the switch of the chosen door after reveal
        for (int i = 0; i < doorList.size(); i++) {

            

            if (doorList.get(i).isPlayerDoor) {
                doorList.get(i).setPlayerDoor(false);
                break;
            }
            if (!doorList.get(i).isPlayerDoor) {
                doorList.get(i).setPlayerDoor(true);
                break;


            }
        }



        // reveals whether player won after switching doors and adds list to count

        for (int i = 0; i < doorList.size(); i++) {
            System.out.println(doorList.get(i).getName()+ "  " + doorList.get(i).isPlayerDoor);

            if (doorList.get(i).isPlayerDoor && doorList.get(i).hasCar) {
                winsWithSwitching++;

            }
        }
    }

    private void runStaySimulation() {
        assignDoors();


        ArrayList<Door> doorList = new ArrayList<Door>();

        doorList.add(door1);
        doorList.add(door2);
        doorList.add(door3);

        pickDoor();

        //simulates reveal of unchosen door with goat

        for (int i = 0; i < doorList.size(); i++) {
            if (doorList.get(i).hasGoat && !doorList.get(i).isPlayerDoor) {
                doorList.remove(i);
                break;
            }
        }

        //reveals if player original choice was correct


        for (int i = 0; i < doorList.size(); i++) {
            if (doorList.get(i).isPlayerDoor && doorList.get(i).hasCar) {
                winsWithoutSwitching++;

            }
        }
    }

    private void assignDoors() {
        Random random = new Random();
        int doorCombo = random.nextInt(3);

        switch (doorCombo) {
            case 0:
                door1 = new Door("Door 1",false, true, false);
                door2 = new Door("Door 2",true, false, false);
                door3 = new Door("Door 3",true, false, false);
                break;
            case 1:
                door1 = new Door("Door 1",true, false, false);
                door2 = new Door("Door 2",false, true, false);
                door3 = new Door("Door 3",true, false, false);
                break;
            case 2:
                door1 = new Door("Door 1",true, false, false);
                door2 = new Door("Door 2",true, false, false);
                door3 = new Door("Door 3",false, true, false);
                break;
        }



    }

    private void pickDoor() {
        Random random = new Random();
        int doorChoice = random.nextInt(3);

        switch (doorChoice) {

            case 0:
                door1.setPlayerDoor(true);
                break;
            case 1:
                door2.setPlayerDoor(true);
                break;
            case 2:
                door3.setPlayerDoor(true);
                break;
        }

    }



}
