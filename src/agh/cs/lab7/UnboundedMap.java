package agh.cs.lab7;

import java.util.List;

public class UnboundedMap extends AbstractWorldMap {
    UnboundedMap(List<HayStack> hays){
        if(hays!=null)
            for (HayStack hay : hays) {
                elements.put(hay.getPosition(), hay);
            }
    }
    @Override
    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
    }

    @Override
    public String toString() {
        this.lowerLeft=this.upperRight=elements.values().iterator().next().getPosition();
        for (IMapElement vehicle : elements.values()) {
            if (vehicle.getPosition().smaller(lowerLeft)) this.lowerLeft =vehicle.getPosition();
            if (vehicle.getPosition().larger(upperRight)) this.upperRight =vehicle.getPosition();
        }
        return super.toString();
    }

}
