//// Midterm code for 59CST112

/**************************************************************
 BE SURE TO CHANGE THE NEXT SEVERAL LINES, USING YOUR REAL NAME.
 
 MY FIRST NAME IS......Alexander
 MY MIDDLE NAME IS.....Jason
 MY LAST NAME IS.......Reid
 
 PICK 3 WORDS THAT START WITH YOUR INITIALS, using lower case letters:
 
 first word............Apple
 second word...........Jackal
 third word............Rhino
 
 USE THESE 3 WORDS TO NAME ALL VARIABLES FOR 3 POOL BALLS.
 (You may abbreviate any words, but start with same letter.)
 ***************************************************************/


//// GLOBALS FOR 3 colored balls ////
//// (Assume ball diameter is 30.) ////

float appX, appY, appDX, appDY;          
float jackX, jackY, jackDX, jackDY;             
float rhinX, rhinY, rhinDX, rhinDY;      
float ballW = 30;
float ballH = 30;
float ratX, ratY;
boolean ratShow;

//reset button floats
float buttonX = 85;
float buttonY = 50;
float buttonW = 60;
float buttonH = 40;

//wall button floats
float buttonX1 = 150;
float buttonY1 = 50;
float buttonW1 = 60;
float buttonH1 = 40;

//pink button floats
float buttonX2 = 215;
float buttonY2 = 50;
float buttonW2 = 60;
float buttonH2 = 40;

//rat button floats
float buttonX3 = 280;
float buttonY3 = 50;
float buttonW3 = 60;
float buttonH3 = 40;
//// OTHER GLOBALS:  strings, pool table, etc ////

String title=  "CST112 MIDTERM EXAM";
String news=   "Click any ball to reset it to right half of table.  (r resets all.)";
String author=  "Alexander Reid";

float left=50, right=590, top=110, bottom=400;        // Table boundaries
float middle=250;
boolean wall=true;

int tableRed=150, tableGreen=250, tableBlue=150;      // green pool table
int score=0, m=0, k=0;


//// SETUP:  size and table
void setup() {
  rectMode(CENTER);  
  size( 640, 480 );          
  reset();
  //// MODIFY THIS CODE TO MAKE TABLE CENTERED IN WINDOW.  ++++

  // Table boundaries
}


//// NEXT FRAME:  table, bounce off walls, collisions, show all
void draw() {
  background( 250, 250, 200 );
  rectMode( CORNERS );
  table( left, top, right, bottom );
  buttons();
  rat();
  bounce();
  collisions();
  show();
  messages();
}


//// HANDLERS:  keys, click
void keyPressed() {
  if (key == 'q') { 
    exit();
  }
  if (key == 'r') {
    reset();
  }
  if (key == 'w') {
    wall=false;
  }
  if (key == 'p') {
    tableRed = 191;
    tableGreen =75;
    tableBlue = 119;
  }
  if (key == '1') {
    appX= random(middle+300, right); 
    appY= random(top, bottom);
  }
  if (key == '2') {
    jackX= random(middle+300, right); 
    jackY= random( top, bottom);
  }
  if (key == '3') {
    rhinX= random(middle+300, right); 
    rhinY= random( top, bottom);
  }
  if (key == 'm') ratShow =! ratShow;
}

void reset() {

  //random positions

  if (wall=true) {
    appX= random(middle+100, right); 
    appY= random(top, bottom);
    jackX= random(middle+100, right); 
    jackY= random( top, bottom);
    rhinX= random(middle+100, right); 
    rhinY= random( top, bottom);
  }
  appDX= random(1-9); 
  appDY= random(1-9);
  jackDX= random(1-9); 
  jackDY= random(1-9);
  rhinDX= random(1-9); 
  rhinDY= random(1-9);
  //resets the collision counter
  score=0;
  //restores original table color
  tableRed=150;
  tableGreen=250;  
  tableBlue=150;
  ratX=1;
  ratY=height - 50;
  ratShow = false;
}

//// SCENE:  draw the table with wall down the middle
void table( float east, float north, float west, float south ) {
  fill( tableRed, tableGreen, tableBlue );    // pool table
  strokeWeight(20);
  stroke( 201, 160, 57 );      // Brown walls
  rect( east-20, north-30, west+20, south+20, 2 );


  // Start with a WALL down the middle of the table! 
  if (wall) {
    float middle=  (east+west)/2;    
    stroke( 113, 104, 79 );
    line( middle, north-5, middle, south-10 );
  }
  stroke(0);
  strokeWeight(1);
}

//// ACTION:  bounce off walls, collisions
void bounce() {


  appX += appDX; 
  if (appX<left || appX>right) appDX *= -1;
  appY += appDY; 
  if (appY<top || appY>bottom) appDY *= -1;

  jackX += jackDX; 
  if (jackX<left || jackX>right) jackDX *= -1;
  jackY += jackDY; 
  if (jackY<top || jackY>bottom) jackDY *= -1;

  rhinX += rhinDX; 
  if (rhinX<left || rhinX>right) rhinDX *= -1;
  rhinY += rhinDY; 
  if (rhinY<top || rhinY>bottom) rhinDY *= -1;

  //collisions for the wall
  if (wall==true) {
    appX += appDX; 
    if (appX<middle+100 || appX>right) appDX *= -1;
    appY += appDY; 
    if (appY<top || appY>bottom) appDY *= -1;

    jackX += jackDX; 
    if (jackX<middle+100 || jackX>right) jackDX *= -1;
    jackY += jackDY; 
    if (jackY<top || jackY>bottom) jackDY *= -1;

    rhinX += rhinDX; 
    if (rhinX<middle+100 || rhinX>right) rhinDX *= -1;
    rhinY += rhinDY; 
    if (rhinY<top || rhinY>bottom) rhinDY *= -1;
  }
}
void collisions() {
  float tmp;
  //velocities swap
  if (dist(appX, appY, jackX, jackY) < 30) {
    tmp=jackDX; 
    jackDX=appDX; 
    appDX=tmp;
    tmp=jackDY; 
    jackDY=appDY; 
    appDY=tmp;
    score = score+1;
  }
  if (dist(appX, appY, rhinX, rhinY) < 30) {
    tmp=rhinDX; 
    rhinDX=appDX; 
    appDX=tmp;
    tmp=rhinDY; 
    rhinDY=appDY; 
    appDY=tmp;
    score = score+1;
  }
  if (dist(rhinX, rhinY, jackX, jackY) < 30) {
    tmp=jackDX; 
    jackDX=rhinDX; 
    rhinDX=tmp;
    tmp=jackDY; 
    jackDY=rhinDY; 
    rhinDY=tmp;
    score = score+1;
  }
}

//// SHOW:  balls, messages, etc.
void show() {
  ellipseMode(CENTER);
  fill(255, 0, 0); 
  ellipse(appX, appY, ballW, ballH); 
  fill(255); 
  text("1", appX-4, appY+3);
  fill (255, 255, 0); 
  ellipse(jackX, jackY, ballW, ballH); 
  fill(0); 
  text("2", jackX-4, jackY+3);
  fill (0, 0, 255); 
  ellipse(rhinX, rhinY, ballW, ballH); 
  fill(255); 
  text("3", rhinX-4, rhinY+3);
  fill(0);
  text(score, 500, 30);
}

void buttons() {
  rectMode(CENTER);
  //SHOW the reset button
  fill(173, 154, 108);
  rect(buttonX, buttonY, buttonW, buttonH, 5);
  fill(255, 215, 113);
  text("Reset", buttonX-15, buttonY+5);
  fill(206, 153, 17);

  //SHOW the wall button
  fill(173, 154, 108);
  rect(buttonX1, buttonY1, buttonW1, buttonH1, 5);
  fill(255, 215, 113);
  text("Wall", buttonX+53, buttonY+5);
  fill(206, 153, 17);

  //SHOW the pink button
  fill(173, 154, 108);
  rect(buttonX2, buttonY2, buttonW2, buttonH2, 5);
  fill(255, 215, 113);
  text("Pink", buttonX+118, buttonY+5);
  fill(206, 153, 17);

  //SHOW the mouse button
  fill(173, 154, 108);
  rect(buttonX3, buttonY3, buttonW3, buttonH3, 5);
  fill(255, 215, 113);
  text("Mouse", buttonX+175, buttonY+5);
  fill(206, 153, 17);
}

void rat() {
  fill(255);
  ratX+=4;
  if (ratShow == true) {
    if (frameCount % 30 > 15) {
      line(ratX, ratY, ratX-20, ratY-10);
    } else {
      line(ratX, ratY, ratX-20, ratY+10);
    }
  }
  if (ratX > width) {
    ratX = 1;
  }
}
void messages() {
  fill(0);
  text( title, width/3, 15 );
  text( news, width/6, 30 );
  text( author, 10, height-5 );
}
void mousePressed() { 
  // reset method
  if (over_reset()) reset();

  // second button; removes WALL
  if ((mouseX < buttonX1 + buttonW1/2) &&
    (mouseX > buttonX1 - buttonW1/2) &&
    (mouseY < buttonY1 + buttonH1/2) &&
    (mouseY > buttonY1 - buttonH1/2))
    wall = false; 

  //turns the pool table pink
  if ((mouseX < buttonX2 + buttonW2/2) &&
    (mouseX > buttonX2 - buttonW2/2) &&
    (mouseY < buttonY2 + buttonH2/2) &&
    (mouseY > buttonY2 - buttonH2/2)) 
  { 
    tableRed = 191;
    tableGreen =75;
    tableBlue = 119;
 //toggles running mouse on/off
    if ((mouseX < buttonX3 + buttonW3/2) &&
    (mouseX > buttonX3 - buttonW3/2) &&
    (mouseY < buttonY3 + buttonH3/2) &&
    (mouseY > buttonY3 - buttonH3/2))
    
    {ratShow =! ratShow;}
    
    //mouseclicks reset each ball's position to right half of the table.
  }
  if ((mouseX < appX + ballW/2) &&
    (mouseX > appX - ballW/2) &&
    (mouseY < appY + ballH/2) &&
    (mouseY > appY - ballH/2))

  { 
    appX= random(middle+300, right); 
    appY= random(top, bottom);
  }

  if ((mouseX < jackX + ballW/2) &&
    (mouseX > jackX - ballW/2) &&
    (mouseY < jackY + ballH/2) &&
    (mouseY > jackY - ballH/2))
  { 
    jackX= random(middle+300, right); 
    jackY= random(top, bottom);
  }

  if ((mouseX < rhinX + ballW/2) &&
    (mouseX > rhinX - ballW/2) &&
    (mouseY < rhinY + ballH/2) &&
    (mouseY > rhinY - ballH/2))
  { 
    rhinX= random(middle+300, right); 
    rhinY= random(top, bottom);
  }
}
/*boolean reset method for first button. 
 THIS was pretty difficult to figure out.*/
boolean over_reset() {
  return (
    (mouseX < buttonX + buttonW) &&
    (mouseX > buttonX) &&
    (mouseY < buttonY + buttonH) &&
    (mouseY > buttonY) );
}
