package com.ldts.ForwardWarfare.Playable.Water;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts.ForwardWarfare.Playable.Playable;
import com.ldts.ForwardWarfare.Tile;

public class WaterCarry extends Playable {
    public WaterCarry() {
        super("Water");
    }
    public void draw(TextGraphics graphics) {

    }
    public boolean canMove(Tile tile) {
        return false;
    }
}
