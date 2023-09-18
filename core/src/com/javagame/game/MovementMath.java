package com.javagame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Circle;

public class MovementMath {
    //trig
    public static float cosf(float f){
        return (float) Math.cos(f);
    }
    public static float sinf(float f){
        return (float) Math.sin(f);
    }

    //advanced trig
    static public Vector3 lengthDir(float direction, float length){
        return new Vector3(MovementMath.cosf(direction)*length,MovementMath.sinf(direction)*length,0);
    }
    static public float pointDir(Vector3 pointa, Vector3 pointb){
        return (float) Math.atan2((pointb.y-pointa.y),(pointb.x-pointa.x));
    }
    static public float pointDis(Vector3 pointa, Vector3 pointb){
        return (float) Math.sqrt(Math.pow(pointb.y-pointa.y,2)+Math.pow(pointb.x-pointa.x,2));
    }
    static public Vector3 midpoint(Vector3 pointa, Vector3 pointb){
        return new Vector3((pointa.x+pointb.x)/2,(pointa.y+pointb.y)/2,0);
    }

    //input
    static public Vector3 InputDir(int preset){
        Vector3 dir = new Vector3(0, 0, 0);
        switch(preset){
            case 0: {
                if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                    dir.x +=1;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                    dir.x += -1;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                    dir.y += 1;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                    dir.y += -1;
                }
                break;
            }
            case 1: {
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    dir.x +=1;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                    dir.x += -1;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                    dir.y += 1;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                    dir.y += -1;
                }
                break;
            }
        }
        return dir;
    }

    static public boolean overlaps(Circle circ, Rectangle rect){
        float circledistx = Math.abs((circ.x+circ.radius) - (rect.x+rect.width/2));
        float circledisty = Math.abs((circ.y+circ.radius) - (rect.y+rect.width/2));

        if (circledistx > (rect.width/2 + circ.radius)||circledisty > (rect.height/2 + circ.radius)) { return false; }
        else if (circledistx <= (rect.width/2)||(circledisty <= (rect.height/2))) { return true; } 

        float cornerdist = (float) Math.pow(circledistx,2) + (float) Math.pow(circledisty,2);

        return (cornerdist <= Math.pow(circ.radius,2));
    }
}