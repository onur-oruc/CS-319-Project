package sample.Entities;

import sample.Enums.TroopCardType;
import sample.Mission.Mission;

import java.lang.reflect.Array;
import java.util.*;

public abstract class Challenger {
    // make properties private
    private String imageUrl;

    private int money;
    private ArrayList<TroopCardType> troopCards;
    private boolean isTurn;
    private String name;
    private int id;
    private int regionCount;
    private boolean isEliminated;


    private String color;

    private ArrayList<Integer> eliminatedEnemyIds; // will be used for eliminate color mission

    private ArrayList<Integer> regionIds;
    private int commanderLocation;

    private Mission mission;


    Challenger(String name, int id, String color, String url) {
        this.imageUrl = url;
        this.color = color;
        this.name = name;
        this.id = id;
        this.regionIds = new ArrayList<>();
        this.eliminatedEnemyIds = new ArrayList<>();
        this.troopCards = new ArrayList<>();
        this.isEliminated = false;
        this.isTurn = false;
        this.money = 0;
        this.regionCount = 0;
        this.mission = null;
    }


    public void updateRegionCount( int regionNum){
        regionCount = regionNum;
    }
    public void updateMoney( int money ){
        this.money = money;
    }
    public void updateRegions( int[] regionIds ) {
//        this.regionIds = new int [regionIds.length];
//        for( int i = 0; i < regionIds.length; i++){
//            this.regionIds[i] = regionIds[i];
//        }
    }

    public boolean addRegion(int newRegionID) {
        if (!regionIds.contains(newRegionID)) {
            regionIds.add(newRegionID);
            regionCount++;
            return true;
        }
        return false;
    }

    public boolean removeRegion(int regionIDtoRemove) {
        return regionIds.remove( (Integer) regionIDtoRemove);
    }

    /**
     * This methods checks for the existence of the given continentID in given challenger
     * All continents are also given as a parameter to receive the regions of the continent
     * with continentID. Then, regions of the continent are compared to the regions of
     * challenger
     *
     * @param challenger whose continent will be checked.
     * @param continentID searched in challenger
     * @param continents the array containing all continents with their regions in the game
     * @return true if challenger owns the continent with continentID.
     */
    public boolean hasContinent(Challenger challenger, int continentID, Continent[] continents) {
        int[] regionsInContinent = null;

        // search for the continent with the given continentID (parameter)
        for (int i = 0; i < continents.length; i++) {
            // find the continent with the given continentID (parameter)
            if ( continents[i].getContinentId() == continentID) {
//                int numRegions = continents[i].getRegionCount();
//                regionsInContinent = new int[numRegions];

                // get continent's region array
                regionsInContinent = continents[i].getRegionIds();
            }
        }

        int challengerNumReg = 0;
        // check if the challenger has all regions of the continent with continentID
        for (int i = 0; i < regionsInContinent.length; i++ ) {
            if (challenger.getRegionIds().contains(regionsInContinent[i])) {
                challengerNumReg++;
            }
        }

        // if challenger has all the regions in the continent, return true
        if (challengerNumReg == regionsInContinent.length)
            return true;

        return false;
    }

    /**
     * This methods checks whether the enemy with enemyID
     * was eliminated by the challenger
     *
     * @param enemyID
     * @return
     */
    public boolean hasEliminatedEnemy(int enemyID) {
        return eliminatedEnemyIds.contains(enemyID);
    }

    /**
     * This methods add the eliminated enemy with eliminatedEnemyID
     * to the eliminated enemy list of the challenger
     *
     * @param eliminatedEnemyID eliminated enemy by the challenger
     */
    public void updateEliminatedEnemies(int eliminatedEnemyID) {
        eliminatedEnemyIds.add(eliminatedEnemyID);
    }

    public void combineCards() {
        // TO DO
        // troop cards will be removed from the array after combining
    }

    public int calculateBonusTroop (Continent[] continents) {

        return 0;
    }

    public void setTroopCards(ArrayList<TroopCardType> troopCards) {
        this.troopCards = troopCards;
    }

    public ArrayList<TroopCardType> getTroopCards() {
        return troopCards;
    }

    public void addTroopCard( TroopCardType troopCard) {
        troopCards.add(troopCard);
    }



    public Mission getMission() {
        return mission;
    }

    public void setMission (Mission mission) {
        this.mission = mission;
    }

    public boolean isEliminated() {

        if ( regionCount == 0 ) {
            isEliminated = true;
        }
        return isEliminated;
    }

    public void removeCard(TroopCardType troop) {
        troopCards.remove(troop);
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageurl) {
        this.imageUrl = imageurl;
    }

    public void setEliminated (boolean eliminated) {
        isEliminated = eliminated;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn (boolean turn) {
        isTurn = turn;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney (int money) {
        this.money = money;
    }

    public int getRegionCount() {
        return regionCount;
    }

    public void setRegionCount (int regionCount) {
        this.regionCount = regionCount;
    }

    public ArrayList<Integer> getRegionIds() {
        return regionIds;
    }

    public void setRegionIds (ArrayList<Integer> regionIds) {
        this.regionIds = regionIds;
    }

    public int getCommanderLocation() {
        return commanderLocation;
    }
    public void setCommanderLocation( int commanderLocation) {
        this.commanderLocation = commanderLocation;
    }

    public String getColor() {
        return color;
    }

    public boolean hasRegion( int regionID ) {
        return regionIds.contains(regionID);
    }

    public String getColorHexToStr() {
        if (color.equals("#34abeb"))
            return "blue";
        else if (color.equals("#ee940c"))
            return "orange";
        else if (color.equals("#cf1fff"))
            return "purple";
        else // if color.equals(#1bc64c)
            return "green";
    }

    public void setColor(String color) {
        this.color = color;
    }
}