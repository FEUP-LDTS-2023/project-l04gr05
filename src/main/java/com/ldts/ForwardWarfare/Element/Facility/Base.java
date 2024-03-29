package com.ldts.ForwardWarfare.Element.Facility;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts.ForwardWarfare.Element.Position;

public class Base implements Facility {
    private TextColor textColor;
    private boolean attackedLastTurn = false;
    private int lives = 2;
    private boolean used = false;

    @Override
    public void draw(TextGraphics graphics, Position position) {
            graphics.setForegroundColor(textColor);
            graphics.putString(position.toTPos(), ";");
    }

    @Override
    public void setTextColor(TextColor color) {
        this.textColor = color;
    }

    @Override
    public void execute() {
        used =! used;
    }

    @Override
    public Boolean getUsed() {
        return used;
    }

    public void takeDamage() {
        lives--;
    }
    public int getLives() {
        return lives;
    }
    public boolean getAttackedLastTurn() {
        return attackedLastTurn;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setAttackedLastTurn(boolean attackedLastTurn) {
        this.attackedLastTurn = attackedLastTurn;
    }


    public void setUsed(boolean used) {
        this.used = used;
    }
}
