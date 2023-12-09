package com.ldts.ForwardWarfare.Element.Playable;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts.ForwardWarfare.Element.Element;

public abstract class Playable extends Element {
    private int hp = 100;
    private int maxMoves;
    private int damage;
    private boolean hasMoved = false;
    public Playable(int maxMoves, int hp, int damage) {
        this.maxMoves = maxMoves;
        this.hp = hp;
        this.damage = damage;
    }
    public void takeHP(int damage) {
        hp -= damage;
    }
    public void setHP(int hp) {
        this.hp = hp;
    }

    public abstract boolean canMove(Element element);
    public abstract String getType();
    public abstract boolean canAttack(Playable playable);
    public int getAttackRadius() {
        return 1;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public int getMaxMoves() {
        return maxMoves;
    }
    public int getDamage() {return damage;};
}
