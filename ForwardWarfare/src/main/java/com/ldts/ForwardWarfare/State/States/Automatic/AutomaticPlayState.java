package com.ldts.ForwardWarfare.State.States.Automatic;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts.ForwardWarfare.Controller.Controller;
import com.ldts.ForwardWarfare.Element.Element;
import com.ldts.ForwardWarfare.Map.Map;
import com.ldts.ForwardWarfare.State.Action;
import com.ldts.ForwardWarfare.State.State;
import com.ldts.ForwardWarfare.State.States.BaseState;
import com.ldts.ForwardWarfare.State.States.Player.Selection.NoSelectionState;

public class AutomaticPlayState extends BaseState {
    public AutomaticPlayState(Controller p1, Controller p2, Map map) {
        super(p1, p2, map);

        for (Element i : p1.getFacilities()) {

        }

        for (Element i : p1.getTroops()) {

        }
    }

    @Override
    public State play(Action action) {
        return new NoSelectionState(p2, p1, map);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.ANSI.BLACK);
        graphics.setForegroundColor(TextColor.ANSI.WHITE_BRIGHT);
        graphics.putString(1, 11, "Automatic");
    }

    @Override
    public boolean requiresInput() {
        return false;
    }
}
