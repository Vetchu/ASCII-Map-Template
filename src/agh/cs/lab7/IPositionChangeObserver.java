package agh.cs.lab7;

public interface IPositionChangeObserver {
    boolean positionChanged(Position oldPosition, Position newPosition);
}
