package net.cheltsov.sphere.manager;

import net.cheltsov.sphere.entity.Sphere;

public final class SphereProperties {
    private double square;
    private double volume;
    private double ratio; //выбрана ближайшая к центру сферы плоскость
    SphereProperties(Sphere sphere) {
        calculateProperties(sphere);
    }
    void calculateProperties(Sphere sphere) {
        double r = sphere.getRadius();
        square = 4 * r * r;
        volume = 4. / 3 * r * r * r;
        double min = Math.min(sphere.getPoint().getX(), Math.min(sphere.getPoint().getY(), sphere.getPoint().getZ()));
        if(min < r) {
            ratio = (2. * r * r * r - 3 * r * r * min + min * min * min) /
                    (2 * r * r * r + 3 * r * r * min - min * min * min);
        } else {
            ratio = 0;
        }
    }
    public double getSquare() {
        return square;
    }
    public double getVolume() {
        return volume;
    }
    public double getRatio() {
        return ratio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SphereProperties that = (SphereProperties) o;

        if (Double.compare(that.square, square) != 0) return false;
        if (Double.compare(that.volume, volume) != 0) return false;
        return Double.compare(that.ratio, ratio) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(square);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ratio);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "SphereProperties{" +
                "square=" + square +
                ", volume=" + volume +
                '}';
    }
}
