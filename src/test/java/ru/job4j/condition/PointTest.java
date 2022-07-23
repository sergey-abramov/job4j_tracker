package ru.job4j.condition;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void when00to20then2() {
        double expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when32to57then5dot38() {
        double expected = 5.38;
        Point a = new Point(3, 2);
        Point b = new Point(5, 7);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when62to22then4() {
        double expected = 4;
        Point a = new Point(6, 2);
        Point b = new Point(2, 2);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when66to22then5dot65() {
        double expected = 5.65;
        Point a = new Point(6, 6);
        Point b = new Point(2, 2);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}