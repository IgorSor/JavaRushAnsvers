package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by MadHarry on 09.08.2017.
 */
public class Model {
    private static final int FIELD_WIDTH =4;
    private Tile[][] gameTiles;
    protected int score;
    protected int maxTile;

    public Model() {
        resetGameTiles();
        this.score = 0;
        this.maxTile = 2;
    }
    private void addTile(){
        List<Tile> list = getEmptyTiles();
            int randomTile =(int)(list.size()*Math.random());
            int randomColor = Math.random() < 0.9 ? 2 : 4;
            list.get(randomTile).value = randomColor;
    }
    private List<Tile> getEmptyTiles(){
        List<Tile> list = new ArrayList<>();
        for (int i = 0;i<FIELD_WIDTH;i++){
            for(int j = 0;j<FIELD_WIDTH;j++){
                if(this.gameTiles[i][j].value == 0){
                    list.add(this.gameTiles[i][j]);
                }
            }
        }
        return list;
    }
    protected void resetGameTiles(){
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0;i<FIELD_WIDTH;i++){
            for(int j = 0;j<FIELD_WIDTH;j++){
                this.gameTiles[i][j] = new Tile();
            }
        }

        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isCompressed = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            for (int j = 0; j < tiles.length - 1; j++) {
                if (tiles[j].isEmpty() && !tiles[j + 1].isEmpty()) {
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = new Tile();
                    isCompressed = true;
                }
            }
        }
        return isCompressed;
    }
    private boolean mergeTiles(Tile[] tiles){

        boolean isMerges = false;
        for (int j = 0; j < tiles.length - 1; j++) {
            if (tiles[j].value == tiles[j + 1].value && !tiles[j].isEmpty() && !tiles[j + 1].isEmpty()) {
                tiles[j].value = tiles[j].value * 2;
                isMerges = true;
                score += tiles[j].value;
                maxTile = maxTile > tiles[j].value ? maxTile : tiles[j].value;
                tiles[j + 1] = new Tile();
                compressTiles(tiles);
            }
        }
        return isMerges;
    }
    public void left(){
        for (int i=0;i<gameTiles.length;i++){

        }
    }

}
