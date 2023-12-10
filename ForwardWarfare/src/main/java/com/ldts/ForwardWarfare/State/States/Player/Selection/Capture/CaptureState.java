package com.ldts.ForwardWarfare.State.States.Player.Selection.Capture;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts.ForwardWarfare.Controller.Controller;
import com.ldts.ForwardWarfare.Element.Element;
import com.ldts.ForwardWarfare.Element.Facility.Base;
import com.ldts.ForwardWarfare.Element.Position;
import com.ldts.ForwardWarfare.Element.Tile.Fields;
import com.ldts.ForwardWarfare.Element.Tile.Tile;
import com.ldts.ForwardWarfare.Map.Map;
import com.ldts.ForwardWarfare.State.Action;
import com.ldts.ForwardWarfare.State.State;
import com.ldts.ForwardWarfare.State.States.BaseState;
import com.ldts.ForwardWarfare.State.States.EndGameState;
import com.ldts.ForwardWarfare.State.States.Player.Selection.NoSelectionState;


public class CaptureState extends BaseState {
    private Position pos;
    private boolean endgame=false;
    public CaptureState(Controller p1, Controller p2, Map map) {
        super(p1, p2, map);
        capture(p1.getSelection1().getPosition());
    }

    @Override
    public State play(Action action) {
        if (endgame)
            return new EndGameState(p1, p2, map);
        return new NoSelectionState(p1, p2, map);
    }

    @Override
    public void draw(TextGraphics graphics) {
    }

    private void capture(Position pos){
        if(map.at(pos).getFacility().getClass()== Base.class)
        {
            if (p2.getBase().getPosition().equals(pos) && !((Base) ((Tile) p2.getBase()).getFacility()).getAtackedlastturn()) {
                System.out.println("Base");
                Base basep1 = (Base) map.at(pos).getFacility();
                basep1.takeDamage();
                basep1.setAtackedlastturn(true);
                if(!basep1.getUsed())
                    basep1.execute();
                map.set(pos, new Fields(pos,basep1));
                p2.setBase((Element) map.at(pos));
                System.out.println(basep1.getLives());
                if (basep1.getLives() <= 0)
                {
                    endgame = true;
                }
            }
        }
        else {
            if (p2.getFacilities().stream().anyMatch(facility -> facility.getPosition().equals(pos)))
                p2.getFacilities().removeIf(facility -> facility.getPosition().equals(pos));
            if (!p1.getFacilities().stream().anyMatch(facility -> facility.getPosition().equals(pos))) {
                map.at(pos).getFacility().execute();
                p1.addFacility((Element) map.at(pos));
            }
        }
    }
    @Override
    public boolean requiresInput() {
        return false;
    }
}
