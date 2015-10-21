// M1 Stoddard
//Garrett SansSouci Stoddard
// g - Green
// s - sangria
// s - sapphire
//Midterm One

//buttons, reset to right side
//remove the wall
//turn the table pink

//globals
float h = 480, w = 640;
float tableY = h/2+50, tableX = w/2, tableW = w-100, tableH = h-200;
float tableLeft , tableRight;
float tableTop, tableBot;
color t = #054307;// color of the table
float green1X, green1Y, green1DX, green1DY;
float sangria2X, sangria2Y, sangria2DX, sangria2DY;
float sapphire3X, sapphire3Y, sapphire3DX, sapphire3DY;
float button1X = w/4, button1Y = 50, button1q = 50, button1p = 20;
float button2X = w/2, button2Y = 50, button2q = 50, button2p = 20;
float button3X = 3*w/4, button3Y = 50, button3q = 50, button3p = 20;
float friction = .986;
//counter for the wall variable
int l = 1;
void setup()
{
  size(640, 480);
  reset();
  tableLeft = tableX - tableW/2;
  tableRight = tableX + tableW/2; 
  tableTop = tableY - tableH/2; 
  tableBot = tableY + tableH/2;
}
// updates the screen
void draw()
{
  background(250,250,200);
  rectMode(CENTER);
  table();
  wall();
  show();
  bounce();
  collisions();
  textAlign(CENTER,CENTER);
  drawButton(button1X, button1Y, button1q, button1p, 255, 0, 0 );
  fill(0);
  text("one", button1X, button1Y);
  drawButton(button2X, button2Y, button2q,button2p, 0, 255, 0 );
  fill(0);
  text("two", button2X, button2Y);
  drawButton(button3X, button3Y, button3q, button3p, 0, 0, 255 );
  fill(0);
  text("three", button3X, button3Y);
}
// draws the table
void table()
{
  fill(#392601);
  rect(tableX, tableY, w-50, h-150);
  fill(t);
  rect(tableX, tableY, tableW, tableH);
}
//draws the wall
void wall()
{
  rectMode(CENTER);
  if(l == 1)
  {
  fill(0);
  rect(tableX, tableY, 10, tableH);
  }
}


//bouncing against the edges
//also controlls the wall bounces
void bounce()
{
  //wall control
  if(l == 1)
  {
      if (green1X < tableX)
    {
      green1X = tableX + 15;
      green1DX *= -1;
    }
   
     if (sangria2X < tableX)
    {
      sangria2X = tableX + 15;
      sangria2DX *= -1;
    }
      if (sapphire3X < tableX)
    {
      sapphire3X = tableX + 15;
      sapphire3DX *= -1;
    }
  }
  
  //green ball speend and hitting the wall
  green1X += green1DX;
  green1Y += green1DY;
  if (green1X < tableLeft + 15)
    {
      green1X = tableLeft + 15;
      green1DX *= -1;
    }
  if (green1X > tableRight - 15)
    {
      green1X = tableRight - 15;
      green1DX *= -1;
    }
  if (green1Y < tableTop + 15)
    {
      green1Y = tableTop + 15;
      green1DY *= -1;
    }
  if (green1Y > tableBot - 15)
    {
      green1Y = tableBot - 15;
      green1DY *= -1;
    }
  //sangria ball 
  sangria2X += sangria2DX;
  sangria2Y += sangria2DY;
   if (sangria2X < tableLeft + 15)
    {
      sangria2X = tableLeft + 15;
      sangria2DX *= -1;
    }
  if (sangria2X > tableRight - 15)
    {
      sangria2X = tableRight - 15;
      sangria2DX *= -1;
    }
  if (sangria2Y < tableTop + 15)
    {
      sangria2Y = tableTop + 15;
      sangria2DY *= -1;
    }
  if (sangria2Y > tableBot - 15)
    {
      sangria2Y = tableBot - 15;
      sangria2DY *= -1;
    }
  
  //sapphire ball
  sapphire3X += sapphire3DX;
  sapphire3Y += sapphire3DY;
   if (sapphire3X < tableLeft + 15)
    {
      sapphire3X = tableLeft + 15;
      sapphire3DX *= -1;
    }
  if (sapphire3X > tableRight - 15)
    {
      sapphire3X = tableRight - 15;
      sapphire3DX *= -1;
    }
  if (sapphire3Y < tableTop + 15)
    {
      sapphire3Y = tableTop + 15;
      sapphire3DY *= -1;
    }
  if (sapphire3Y > tableBot - 15)
    {
      sapphire3Y = tableBot - 15;
      sapphire3DY *= -1;
    }
  
  
}

// draws the balls
void show()
{
  textAlign(CENTER,CENTER);
  fill(#11F71A);// green
  ellipse( green1X, green1Y, 30,30 );
  fill(0);
  text(1, green1X, green1Y);
  fill(#92000A);// sangria
  ellipse( sangria2X,sangria2Y, 30,30 );
  fill(0);
  text(2, sangria2X, sangria2Y);
  fill(#0F52BA);// sapphire
  ellipse( sapphire3X,sapphire3Y, 30,30 );
  fill(0);
  text(3, sapphire3X, sapphire3Y);
}

void reset()
{
  green1X = random(tableX + 15, tableRight - 15);
  green1Y = random(tableTop + 15, tableBot - 15);
  sangria2X = random(tableX + 15, tableRight - 15);
  sangria2Y = random(tableTop + 15, tableBot - 15);
  sapphire3X = random(tableX + 15, tableRight - 15);
  sapphire3Y = random(tableTop + 15, tableBot - 15);
  l = 1;
  green1DX = random(1,3); green1DY = random(1,3);
  sangria2DX = random(1,3); sangria2DY = random(1,3);
  sapphire3DX = random(1,3); sapphire3DY = random(1,3);
}

//handelers
void keyPressed()
{
  if(key == 'r')
  {
    reset();
  }
  if(key == 'w')
  {
    l--;
  }
}

void mousePressed()
{
  //Hitting the red button
  if( hit( mouseX, mouseY,  button1X, button1Y, button1q, button1p) )
  {
    reset();
  }
  //Hitting the green button
  else if ( hit( mouseX, mouseY,  button2X, button2Y, button2q, button2p) == true)
   {
     l = 0;
   }
   //Hitting the blue button
  else if ( hit( mouseX, mouseY,  button3X, button3Y, button3q, button3p) == true)
   {
     t = #F26EC4; 
   }
}

//controlls the bouncing balls
void collisions()
{
  float temp;
  // swapping velocities
  //1 and 2
  if ( dist( green1X, green1Y, sangria2X, sangria2Y) < 30)
  {
    temp = sangria2DX; sangria2DX = green1DX; green1DX = temp;
    temp = sangria2DY; sangria2DY = green1DY; green1DY = temp; 
  }
  //1 and 3
  if ( dist( green1X, green1Y, sapphire3X, sapphire3Y) < 30)
  {
    temp = sapphire3DX; sapphire3DX = green1DX; green1DX = temp;
    temp = sapphire3DY; sapphire3DY = green1DY; green1DY = temp; 
  }
  // 2 and 3
  if ( dist( sangria2X, sangria2Y, sapphire3X, sapphire3Y) < 30)
  {
    temp = sapphire3DX; sapphire3DX = sangria2DX; sangria2DX = temp;
    temp = sapphire3DY; sapphire3DY = sangria2DY; sangria2DY = temp; 
  }
}


// drawing the button
void drawButton(float x, float y, float q, float p, float rr, float rg, float rb)
{
  // color of the rectangle
  fill(rr, rg, rb);
  //Changes the mode of the rectangle to the center
  rectMode(CENTER);
  rect(x,y,q,p);
}

// hitting the button
boolean hit( float x1, float y1, float x2, float y2, float w, float h ) 
{
  boolean result;
  if ( abs(x1-x2) < w && abs(y1-y2)<h ) {
    result=  true;
  } else {
    result=false;
  }

  return result;
}
