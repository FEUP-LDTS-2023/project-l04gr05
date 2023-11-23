package com.ldts.ForwardWarfare.Playable.Ground;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts.ForwardWarfare.Element;
import com.ldts.ForwardWarfare.Playable.Playable;
import com.ldts.ForwardWarfare.Position;

public class HeavyPerson extends Playable {
    public HeavyPerson(Position pos) {
        super(3);
        position = pos;
    }
    @Override
    public void draw(TextGraphics textGraphics, TextColor textColor) {
        textGraphics.setForegroundColor(textColor != null ? textColor : new TextColor.RGB(80, 80, 80));
        textGraphics.putString(position.toTPos(), "");
    }
    protected boolean canMove(Element element) {
        return false;
    }
}