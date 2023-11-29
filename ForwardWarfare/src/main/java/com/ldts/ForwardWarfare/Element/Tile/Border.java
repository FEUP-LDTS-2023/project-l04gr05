package com.ldts.ForwardWarfare.Element.Tile;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts.ForwardWarfare.Element.Element;
import com.ldts.ForwardWarfare.Element.Position;

public class Border extends Element {
    private TextColor background;
    public Border(Position position)
    {
        this.position = position;
    }

    public void setBackground(TextColor background) {
        this.background = background;
    }

    @Override
    public void draw(TextGraphics graphics,TextColor textColor) {
        graphics.setForegroundColor(textColor);
        graphics.setBackgroundColor(background);
        graphics.putString(position.toTPos(),"*");
    }
}
