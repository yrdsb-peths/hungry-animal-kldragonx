import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels
        
        
        super(600, 400, 1, false);
        Rhino rhino = new Rhino();
        addObject(new Rhino(), 300, 200);
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        
        
        createApple();
        
       
        
        
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over",100);
        addObject(gameOverLabel,300,200);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        
    }
    
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple,300,0);
        
    }
} 
