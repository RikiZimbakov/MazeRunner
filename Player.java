import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class Player extends Actor
{
    private final int NORTH = 270;
    private final int EAST = 0;
    private final int SOUTH = 90;
    private final int WEST = 180;

    public Player()
    {
        GreenfootImage playerImage = new GreenfootImage(40, 40);

        playerImage.setColor(Color.BLUE);
        playerImage.fillRect(0, 0, 40, 40);

        setImage(playerImage);
        setRotation(WEST);
    }

    /**
     * checkWin checks if the player is touching the winning space and tells 
     * the player he is the winning by displaying text that says "you are 
     * a champion" and stops the program
     * @param There are no parameters
     * @return nothing is returned
     */
    private void checkWin()
    {
        if( isTouching(WinningSpace.class) )
        {
            getWorld().showText("You are A WINNER", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }

    /**
     * movement lets the player move by first checking if a certain key is pressed 
     * then if there is not a wall in front of the player and if both of those are true then you are able
     * to move forward
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void movement()
    {
        if( Greenfoot.isKeyDown("right") )
        {
            setRotation(EAST);
            if( canMoveForward() == true)
            {
                move(1);
            }

        }
        if( Greenfoot.isKeyDown("left") )
        {
            setRotation(WEST);
            if( canMoveForward() == true)
            {
                move(1);
            }

        }
        if( Greenfoot.isKeyDown("down") )
        {
            setRotation(SOUTH);
            if( canMoveForward() == true)
            {
                move(1);
            }

        } 
        if( Greenfoot.isKeyDown("up") )
        {
            setRotation(NORTH);
            if( canMoveForward() == true)
            {
                move(1);
            }

        } 
    }

    /**
     * canMoveForward checks if there is a wall infront of the player in
     * whatever direction it is facing
     * @param There are no parameters
     * @return a boolean that decides whether or not the player can move forward is returned
     */
    private boolean canMoveForward()
    {
        int xOffset = 0;
        int yOffset= 0;
        boolean moveForward = false;

        if (getRotation() == NORTH)
        {
            yOffset = -1;
        }
        else if (getRotation() == SOUTH)
        {
            yOffset = 1;
        }
        else if (getRotation() == EAST)
        {
            xOffset = 1;
        }
        else if (getRotation() == WEST)
        {
            xOffset = -1;
        }

        if( getOneObjectAtOffset(xOffset, yOffset, Wall.class ) == null )
        {
            moveForward = true;
        }

        return moveForward;
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkWin();
        canMoveForward();
        movement();
    }    
}
