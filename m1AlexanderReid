//// Midterm code for 59CST112

/**************************************************************
BE SURE TO CHANGE THE NEXT SEVERAL LINES, USING YOUR REAL NAME.

    MY FIRST NAME IS......Alexander
    MY MIDDLE NAME IS.....Jason
    MY LAST NAME IS.......Reid
    
PICK 3 WORDS THAT START WITH YOUR INITIALS, using lower case letters:

    first word............app
    second word...........jack
    third word............rhin
    
USE THESE 3 WORDS TO NAME ALL VARIABLES FOR 3 POOL BALLS.
(You may abbreviate any words, but start with same letter.)
***************************************************************/


//// GLOBALS FOR 3 colored balls ////
//// (Assume ball diameter is 30.) ////

float appX,  appY,  appDX,  appDY;          //++++ MODIFY THIS.  Don' use "wolf". ++++
float jackX,  jackY,  jackDX,  jackDY;              //++++ MODIFY THIS.  Don' use "ham". ++++
float rhinX,  rhinY,  rhinDX,  rhinDY;      //++++ MODIFY THIS.  Don' use "hippo". ++++

float buttonX = width/4;
float buttonY = height/4;
float buttonW = 80;
float buttonH = 65;

       //++++ MODIFY THESE DECLARATIONS -- Do not use "wolf" or "ham" or "hippo" ++++


//// OTHER GLOBALS:  strings, pool table, etc ////

String title=  "CST112 MIDTERM EXAM";
String news=   "Click any ball to reset it to right half of table.  (r resets all.)";
String author=  "Alexander Reid";

float left=50, right=590, top=110, bottom=400;        // Table boundaries
float middle=250;
boolean wall=true;

int tableRed=150, tableGreen=250, tableBlue=150;      // green pool table
int score=0,m=0,k=0;

    // ADD YOUR OWN DECLARATIONS HERE. ++++


//// SETUP:  size and table
void setup() {
  rectMode(CENTER);  
  size( 640, 480 );          //++++ CHANGE THE SIZE -- see instructions! ++++
  reset();
    //// MODIFY THIS CODE TO MAKE TABLE CENTERED IN WINDOW.  ++++

    // Table boundaries
 }


//// NEXT FRAME:  table, bounce off walls, collisions, show all
void draw() {
  background( 250,250,200 );
  rectMode( CORNERS );
  table( left, top, right, bottom );
  buttons();
  bounce();
  collisions();
  show();
  messages();
}


//// HANDLERS:  keys, click
void keyPressed() {
  if (key == 'q') { exit();  }
  if (key == 'r') {reset(); }
  if (key == 'w') {wall=false;}
  }

void reset() {
 
 //random positions
 
 if(wall=true) {
  appX= random(middle+100, right); appY= random(top, bottom);
  jackX= random(middle+100, right); jackY= random( top,bottom);
  rhinX= random(middle+100, right); rhinY= random( top, bottom);
 }
  appDX= random(1-5); appDY= random(1-5);
  jackDX= random(1-5); jackDY= random(1-5);
  rhinDX= random(1-5); rhinDY= random(1-5);
  
  score=0;
  
  
}

//// SCENE:  draw the table with wall down the middle
void table( float east, float north, float west, float south ) {
  fill( tableRed, tableGreen, tableBlue );    // pool table
  strokeWeight(20);
  stroke( 127, 0, 0 );      // Brown walls
  rect( east-20, north-30, west+20, south+20 );

            //++++ MODIFY THIS CODE, as necessary. ++++

  // Start with a WALL down the middle of the table! 
  if (wall) {
    float middle=  (east+west)/2;    
    stroke( 0, 127, 0 );
    line( middle,north-5, middle,south-10 );
  }
  stroke(0);
  strokeWeight(1);
}

//// ACTION:  bounce off walls, collisions
void bounce() {
  
 
  appX += appDX; if (appX<left || appX>right) appDX *= -1;
   appY += appDY; if (appY<top || appY>bottom) appDY *= -1;
  
   jackX += jackDX; if (jackX<left || jackX>right) jackDX *= -1;
   jackY += jackDY; if (jackY<top || jackY>bottom) jackDY *= -1;
   
   rhinX += rhinDX; if (rhinX<left || rhinX>right) rhinDX *= -1;
   rhinY += rhinDY; if (rhinY<top || rhinY>bottom) rhinDY *= -1;

 
     
   appX += appDX; if (appX<middle+100 || appX>right) appDX *= -1;
   appY += appDY; if (appY<top || appY>bottom) appDY *= -1;

   jackX += jackDX; if (jackX<middle+100 || jackX>right) jackDX *= -1;
   jackY += jackDY; if (jackY<top || jackY>bottom) jackDY *= -1;

   rhinX += rhinDX; if (rhinX<middle+100 || rhinX>right) rhinDX *= -1;
   rhinY += rhinDY; if (rhinY<top || rhinY>bottom) rhinDY *= -1;
   }
}
void collisions() {
   float tmp;
   //velocities swap
   if (dist(appX,appY, jackX,jackY) < 30) {
     tmp=jackDX; jackDX=appDX; appDX=tmp;
     tmp=jackDY; jackDY=appDY; appDY=tmp;
     score = score+1;
}
   if (dist(appX,appY, rhinX,rhinY) < 30) {
     tmp=rhinDX; rhinDX=appDX; appDX=tmp;
     tmp=rhinDY; rhinDY=appDY; appDY=tmp;
      score = score+1;
}
   if (dist(rhinX, rhinY, jackX,jackY) < 30) {
     tmp=jackDX; jackDX=rhinDX; rhinDX=tmp;
     tmp=jackDY; jackDY=rhinDY; rhinDY=tmp;
     score = score+1;
     
   }


}

//// SHOW:  balls, messages, etc.
void show() {
    ellipseMode(CENTER);
    fill(255,0,0); ellipse(appX,appY, 30,30); fill(255); text("1", appX-4, appY+3);
    fill (255,255,0); ellipse(jackX, jackY, 30,30); fill(0); text("2", jackX-4, jackY+3);
    fill (0,0,255); ellipse(rhinX, rhinY, 30,30); fill(255); text("3", rhinX-4, rhinY+3);
    fill(0);
    text(score, 500, 30);
}
void buttons() {
   fill(173, 154, 108);
   rect(buttonX, buttonY, buttonW, buttonH, 5);
   fill(255, 215, 113);
   text("Reset", buttonX+23, buttonY+38);
   fill(206, 153, 17);
}
void messages() {
  fill(0);
  text( title, width/3, 15 );
  text( news, width/6, 30 );
  text( author, 10, height-5 );
}
void mousePressed() {
  if(over_reset()) reset();
  
}

boolean over_reset() {
  return (
  (mouseX < buttonX + buttonW) &&
  (mouseX > buttonX) &&
  (mouseY < buttonY + buttonH) &&
  (mouseY > buttonY) );
  
}
