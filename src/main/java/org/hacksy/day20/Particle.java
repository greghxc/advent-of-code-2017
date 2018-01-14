package org.hacksy.day20;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Particle {
    @Getter Position p;
    Position v;
    Position a;

    Long distance() {
        return p.distance();
    }

    void tick() {
        // Increase the X velocity by the X acceleration.
        v.setX(v.getX() + a.getX());
        // Increase the Y velocity by the Y acceleration.
        v.setY(v.getY() + a.getY());
        // Increase the Z velocity by the Z acceleration.
        v.setZ(v.getZ() + a.getZ());
        // Increase the X position by the X velocity.
        p.setX(p.getX() + v.getX());
        // Increase the Y position by the Y velocity.
        p.setY(p.getY() + v.getY());
        // Increase the Z position by the Z velocity.
        p.setZ(p.getZ() + v.getZ());
    }

    public String toString() {
        return String.format("p=%s, v=%s, a=%s", p, v, a);
    }
}
