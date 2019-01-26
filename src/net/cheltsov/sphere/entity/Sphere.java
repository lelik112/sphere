package net.cheltsov.sphere.entity;

import net.cheltsov.sphere.manager.SphereObserver;
import net.cheltsov.sphere.manager.SphereProperties;

public class Sphere {
    private Point point;
    private int radius;
    public SphereObserver observer = SphereObserver.getSphereObserver();
    //классические методы интерфейча Observable addObserver() и RemoteObserver() не определены
    //так как шаблон Observer применен для решение узкой спецеффичной задачи и наличие этих методов
    //мешало бы ее выполнению
    public Sphere() {
        point = new Point();
        notifyObserver();
    }

    public Sphere(int radius) {
        point = new Point();
        setRadius(radius);
    }

    public Sphere(Point point, int radius) {
        this.point = point;
        setRadius(radius);
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
        notifyObserver();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        //Если тут выбросить проверяемо есключение, то создание каждого экземпляра сферы
        //я должен лиюо оборачивать в try/catch с недостижимым catch (в чем нет смысла),
        //либо передавать на верх исключение, которое никогда не будет выбрашено
        //(в чем смыла тоже нет)
        //Остается 2 варианта, либо выбросить RunTime либо ни делать ничего. Выброшу пожалуй...
        if(radius < 0) {
            throw new IllegalArgumentException("radius < 0");
        }
        this.radius = radius;
        notifyObserver();
    }

    private void notifyObserver() {
        observer.handleEvent(this);
    }

    public SphereProperties getSpereProperties() {
        return observer.getSphereProperties(this);
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "point=" + point +
                ", radius=" + radius +
                '}';
    }

    //equals() и hashCode() не переопределены, так как объкты этого класса
    //используются в качестве ключей в HashMap
}







