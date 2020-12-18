package entities;

import enums.MotivationLevel;

import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.lang.reflect.Array;
        import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Region {

    // properties
    private int continentID;
    private String regionName;
    private int regionID;
    private int ownerID;
    private int numTroops;
    private boolean hasCommander;
    private int[] neighbors;
    private int locX;
    private int locY;
    private boolean hasGoldMine;
    private MotivationLevel motivation;

    private boolean plague, drought, frost;

    // constructors
    public Region() {

    }

    /*public entities.Region(int regionId) {
        this.regionID = regionId;
        this.ownerID = -1;
        BufferedReader rdr;

        try {
            rdr = new BufferedReader(new FileReader("data/region.txt"));
            for(int i = 0; i < regionId; i++){
                rdr.readLine();
            }
            Scanner scan = new Scanner(rdr.readLine());
            locX = scan.nextInt();
            locY = scan.nextInt();

            int neighborCount = scan.nextInt();

            neighbors = new int[neighborCount];
            for(int i = 0; i < neighborCount; i++){
                neighbors[i] = scan.nextInt();
            }

            scan.close();
            rdr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    // methods


    public void setRegionID(int regionID) {this.regionID = regionID;}

    public int getRegionID() {return regionID;}

    public void setNumTroops(int numTroops){
        this.numTroops = numTroops;
    }

    public int getNumTroops(){
        return this.numTroops;
    }

    public void increaseNumTroopsBy(int numNewTroops){
        numTroops = numTroops + numNewTroops;
    }

    public void setOwnerID(int ownerID){
        this.ownerID = ownerID;
    }

    public int getOwnerID(){
        return this.ownerID;
    }

    public void setHasCommander(boolean hasCommander){
        this.hasCommander = hasCommander;
    }

    public boolean hasCommander(){
        return this.hasCommander;
    }

    public void setMotivation(MotivationLevel motivation){
        this.motivation = motivation;
    }

    public MotivationLevel getMotivation(){
        return this.motivation;
    }

    public void setHasGoldMine(boolean hasGoldMine){
        this.hasGoldMine = hasGoldMine;
    }

    public boolean hasGoldMine(){
        return this.hasGoldMine;
    }

    public int[] getNeighbors(){ return neighbors; }
    public void setNeighbors(int[] neighbors) {this.neighbors = neighbors;}

    public int getLocX(){
        return this.locX;
    }
    public int getLocY(){
        return this.locY;
    }

    public int getContinentID() {
        return continentID;
    }
    public void setContinentID(int continentID) {
        this.continentID = continentID;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public boolean hasDrought() { return drought; }
    public void setDrought( boolean drought ) { this.drought = drought; }

    public boolean hasPlague() { return plague; }
    public void setPlague( boolean plague ) { this.plague = plague; }

    public boolean hasFrost() { return frost; }
    public void setFrost( boolean frost ) { this.frost = frost; }


    public List<Integer> getConnectedOwnedRegions( Region[] allRegions, List<Integer> ownedRegionsByID ) {
        // todo
        return null;
    }


    public void printRegion() {

        System.out.println();
        System.out.println("regionID: " + regionID);
        System.out.println("regionName: " + regionName);
        System.out.println("continentID: " + continentID);
        System.out.println("ownerID: " + ownerID);
        System.out.println("numTroops: " + numTroops);
        System.out.println("hasCommander: " + hasCommander);
        System.out.println("hasGoldMine: " + hasGoldMine);
        System.out.println("troopMotivation: " + motivation);
        System.out.println("locX: " + locX);
        System.out.println("locY: " + locY);

        System.out.print("neighbors: ");
        for (int neighbor : neighbors) {
            System.out.print(neighbor + ", ");
        }
        System.out.println();
    }
}