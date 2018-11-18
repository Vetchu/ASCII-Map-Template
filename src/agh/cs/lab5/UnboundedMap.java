package agh.cs.lab5;

import java.util.List;

public class UnboundedMap extends AbstractWorldMap {
    UnboundedMap(List<HayStack> hays){
        this.elements.addAll(hays);
    }


    @Override
    public String toString() {
        this.lowerLeft=this.upperRight=elements.get(0).getPosition();
        for (IMapElement vehicle : elements) {
            if (vehicle.getPosition().smaller(lowerLeft)) this.lowerLeft =vehicle.getPosition();
            if (vehicle.getPosition().larger(upperRight)) this.upperRight =vehicle.getPosition();
        }
        return super.toString();
    }

}
