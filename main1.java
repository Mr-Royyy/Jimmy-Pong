import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Pong
 * @author Jimmy Roy
 * @Version January 23, 2023
 */
public class main1 extends Application
{

    AnimationTimer timer2; //declares timer
    AnimationTimer timer1;//declares timer


    static final int MAX_WIDTH = 1350; // static variables so I can use it anywhere
    static final int MAX_HEIGHT = 700;// static variables so I can use it anywhere

    ball square; //imports the method and names it square
    paddle paddlemain;//declares a paddle to be used as a field
    paddleOPP theopp;//declares a paddle (paddleOPP) to be used as a field
    int score = 0; //score counter
    int score1 = 0;
    Text t2 = new Text(610, 50, score+""); // shows score
    Text t3 = new Text(780, 50, score1+"");//shows score



    AnimationTimer timer = new AnimationTimer()
    {
        /**
         * Movement updates and ball reset if point awarded
         * @param now
         *            The timestamp of the current frame given in nanoseconds. This
         *            value will be the same for all {@code AnimationTimers} called
         *            during one frame.
         */
        @Override
        public void handle(long now)
        {
            if (ball.x + 25 >= 1349) //ball his edge (right side)
            {
                System.out.println("hit");
                score = score+1;
                t2.setText(score+""); //updates score each time a point is earned

                ball.x=550; //resets the ball
                ball. y=250;//resets the ball
                ball.deltaX=7;//resets the ball speed
                ball.deltaY=4;//resets the ball speed

            }

            square.move(); //square ball moves
            if (ball.x <=1)
            {
                score1 = score1+1; // if hits wall score updated
                t3.setText(score1+"");
                ball.x=550; // resets the ball
                ball. y=250;// resets the ball
                ball.deltaX=7; //resets te speed
                ball.deltaY=4;//resets te speed
            }

            checkForCollision(); //collision always get updated incase collision happens
        }

    };

    public void checkForCollision()
    {
        if (paddlemain.getRectangle().intersects(square.getRectangle().getBoundsInLocal()))
        {
            System.out.println("bam"); //checks for collision and prints in terminal, ment for checking if game works

        }
        if (paddlemain.getRectangle().intersects(square.getRectangle().getBoundsInLocal()))// Ball deflection and speed code
        {
            ball.deltaX *= -1; //ball deflects
            ball.deltaX += 2;//ball deflects with speed change

            if (ball.deltaY>=12) //speed cap, if more than 12 it stops at 12
            {
                ball.deltaY+=12;
            }
            if (ball.deltaX>=12)//speed cap, if more than 12 it stops at 12
            {
                ball.deltaX+=12;
            }
        }
        if (theopp.getRectangle().intersects(square.getRectangle().getBoundsInLocal()))//makes ball move back after hitting paddle
        {

            ball.deltaX *= -1; //deflection
            ball.deltaX -= 2;

        }
    }

    /**
     *
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set. The primary stage will be embedded in
     * the browser if the application was launched as an applet.
     * Applications may create other stages, if needed, but they will not be
     * primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage)
    {
        Group root = new Group();
        Scene scene = new Scene(root, MAX_WIDTH, MAX_HEIGHT); //sets width and height of game
        scene.setFill(Color.BLACK);//makes background black
        //adding text
        Text t1 = new Text(680, 50, "Pong"); //pong title
        t1.setFont(new Font("Arial", 30)); //font and sizing
        t1.setFill(Color.WHITE);
        root.getChildren().add(t1);


        t2.setFont(new Font("Arial", 30)); //score. font and sizing
        t2.setFill(Color.WHITE);
        root.getChildren().add(t2); //creates score on game

        t3.setFont(new Font("Arial", 30)); //score,  font and sizing
        t3.setFill(Color.WHITE);
        root.getChildren().add(t3); //creates score on game


        square = new ball(100,200); //starting cords of ball
        paddlemain = new paddle(80, 250);//starting cords of paddle
        theopp = new paddleOPP(1205,250);//starting cords of paddle


        root.getChildren().add(square.getRectangle()); //creates square ball
        root.getChildren().add(paddlemain.getRectangle()); //creates paddle
        root.getChildren().add(theopp.getRectangle());//creates paddle


        EventHandler<KeyEvent> keyPressedEventHandler = new EventHandler<KeyEvent>() //when pressed paddle goes up or down at speed of 11 pixels
        {
            /**
             * checks if movement key pressed
             * @param event the event which occurred
             */
            @Override

            public void handle(KeyEvent event)
            {
                //this code will run whenever a key is pressed down
                switch (event.getCode()) {
                    case W:
                        paddle.deltaY = -11; //moves up
                        break;
                    case S:
                        paddle.deltaY = 11;//moves down
                        break;
                    case UP:
                            paddleOPP.deltaY = -11;//moves up
                            break;
                    case DOWN:
                            paddleOPP.deltaY = 11;//moves down
                            break;
                }

            }
        };

        EventHandler<KeyEvent> keyReleasedEventHandler = new EventHandler<KeyEvent>() //when released the speed is 0
        {/**
         * checks if movement key pressed
         * @param event the event which occurred
         */
            @Override
            public void handle(KeyEvent event)
            {
                switch (event.getCode())
                {
                    case W:
                        paddle.deltaY = 0; //stops movement
                        break;
                    case S:
                        paddle.deltaY = 0; //stops movement
                        break;
                    case UP:
                        paddleOPP.deltaY = 0;//stops movement
                        break;
                    case DOWN:
                        paddleOPP.deltaY = 0; //stops movement
                        break;
                }

            }

        };


        timer1 = new AnimationTimer()
        {
            /**
             * Animates paddles and caps boundries
             * @param now
             *            The timestamp of the current frame given in nanoseconds. This
             *            value will be the same for all {@code AnimationTimers} called
             *            during one frame.
             */
            @Override
            public void handle(long now)

            {

                paddle.y += paddle.deltaY;
                paddle.rectangle.setY(paddle.y);

                if (paddle.y+paddle.paddleheight>=MAX_HEIGHT) //caps the paddle from going out of bounce
                {
                    paddle.y=MAX_HEIGHT-paddle.paddleheight;
                }
                if (paddle.y <=0 )//caps the paddle from going out of bounce
                {
                    paddle.y=0;
                }
            }

        };

       timer2 = new AnimationTimer()
        {
            /**
             * Animates paddle and caps boundries
             * @param now
             *            The timestamp of the current frame given in nanoseconds. This
             *            value will be the same for all {@code AnimationTimers} called
             *            during one frame.
             */
            @Override
            public void handle(long now)
            {
                timer2.start();
                paddleOPP.y += paddleOPP.deltaY;
                paddleOPP.rectangle1.setY(paddleOPP.y);

                if (paddleOPP.y+paddleOPP.paddleoppheight>=MAX_HEIGHT)//caps the paddle from going out of bounce
                {
                    paddleOPP.y=MAX_HEIGHT-paddleOPP.paddleoppheight;
                }
                if (paddleOPP.y <=0 )//caps the paddle from going out of bounce
                {
                    paddleOPP.y=0;
                }
            }

        };

        primaryStage.setTitle("pong game");
        primaryStage.setScene(scene); //shows primary stage and scene
        primaryStage.show();//shows primary stage and scene
        timer.start(); //starts animation timers
        timer1.start();//starts animation timers
        timer2.start();//starts animation timers
        scene.setOnKeyPressed(keyPressedEventHandler); //starts movement handlers
        scene.setOnKeyReleased(keyReleasedEventHandler);//starts movement handlers

//Attempted to make game over screen, did not work, removed code as things didn't move
    }
}
