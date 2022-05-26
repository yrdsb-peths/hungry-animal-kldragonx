import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rhino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rhino extends Actor
{
    GreenfootSound rhinoSound = new GreenfootSound("rhino.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[6];
    GreenfootImage[] idleLeft = new GreenfootImage[6];
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
            facing = ("left");
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
            facing = ("right");
        }
        
        eat();
        
        animateRhino();
    }
    
    public Rhino()
    {
        for (int i = 0; i<idleRight.length; i++)
        {
            idleRight[i]= new GreenfootImage("C:/Users/86153/Downloads/rhinopic/tile" + i + ".png");
            idleRight[i].scale(100,50);
        }
        
        for (int i = 0; i<idleLeft.length; i++)
        {
            idleLeft[i]= new GreenfootImage("C:/Users/86153/Downloads/rhinopic/tile" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100,50);   
        }
        
        animationTimer.mark();
        setImage(idleRight[0]);
    }
    
    int imageIndex = 0;
    public void animateRhino()
    {
        if(animationTimer.millisElapsed() <100)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex= (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex= (imageIndex + 1) % idleLeft.length;   
        }
    }
    
    public void eat()
    {
        if(isTouching(Apple.class))
        {
        removeTouching(Apple.class);
        MyWorld world = (MyWorld) getWorld();
        world.createApple();
        world.increaseScore();
        rhinoSound.play();
        }
        
        
    }
}
