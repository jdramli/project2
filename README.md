# project2

For project 2, this is an attempt to make widgets that draw lines and/or shapes on screen.  The initial focus is to create the drawing of an image
in response to some user input, such as an on screen click or a button/widget interaction. 

The first few days involve familiarization with how to set up a canvas onto a Linear or Constraint layout, and what properties are available
when this attachment is made.  Understanding more about canvas locks, and custom surface methods.  The first day was predominantly reading the 
tutorials, and setting up the project outline.

The next few days, the focus is on setting up the activity_main, the title screen, and adjusting the canvas size for what will be drawn on screen.
Buttons were added again, and the layout is partway complete.

After many failed attempts at getting proper interaction between onclick listeners and some images to display on screen, I have resorted to testing the app
over the next few days by using seekBar inputs from the tutorial to experiment with output of images.  The seekBar is handy, because it will respond
in 3 different events, including "start seek" "stop seek" and "progress changed", allowing for any generated functions to be tested and run on any of
those conditions.  This creates enough to test the user activity input vs. the expected output variations of the shapes/lines.

Using the seek bar for the next few days, more functions have been generated to manipulate and draw different circles and lines while changing the
background color of the custom surface on the app.  The functions "drawRed()", drawGreen, drawYellow, drawRandomLine, and drawEquation have been added.
These functions were created and tested in a separate project titled "seekBarJoe", and have their source code copied into text files in this repository.
The focus over these days is expanding and modifying these functions and assimilating their concepts and design into this repository.

The following days have been about adding fields to the DrawingSurface object such as those to graph a y = mx + b line.  I have added a float "m" (slope) 
and a float "b"(y intercept).  I experimented with adding a "power" field in order to create exponential lines like x^2 and x^3 but they grow too fast
to have good appreciation of what is happening, and generally just don't look good for my current implementation, so I am sticking with powers of 1.
Many getter and setter methods have been added for power and slope, and their status is updated and displayed in the slope TextView button onscreen.
Finally, there is now an ability to draw lines starting from the upper left 0,0 corner of the DrawingSurface (SurfaceView object) and in the direction
of the x,y coordinates of an on-screen click of the finger.  This line is changed to a "blue" color in order to show that a user has made this with
the free-hand click that has occurred.  The slope is then saved and the line remains on screen when the user releases the click.
In addition, any existing line on the screen can be adjusted in length using the seekbar.  The seekbar changes the color of the line to yellow,
and technically doesn't save the existing line, but draws a new line off of the existing slope of the drawing surface that was saved from 
drawing the blue line from the user-click (the slope that is set in the DrawingSurface).  There is also a "Rand" TextView Button on the bottom
right corner of the app screen that will generate a random slope and random x and y coordinates as an enpoint to draw a line.  This is done in 
yellow as well, and that line can then be adjusted by the seekbar as well (because the seekbar is just using the slope and the b value). 

Next step is to add a "b" value to the Rand line and maybe a "b" adjustment button as well to the app screen.  Also, speed parameter was experimented with
in the "drawEquation" method that was used to draw the yellow lines with the seekbar and "Rand", and this may be removed for clarity.  Much code
may need to be deleted as these programs were written to gain familiarity and understanding with many android studio SurfaceView and listener functions.

Speed option has been moved to separate function called "drawEquation", and simple y = mx+b non-exponential and only using two coordinate pairs is
now implemented as function "drawSimpleEquation".  Plus and minus buttons on the app-screen will adjust the slope by 0.1, allowing for small and
more more aesthetically pleasing adjustments in line angle.  Next step is to maybe add a button to increase or decrease "b", or maybe create a way
to invoke the method "drawLineOnClicks" which would hopefully get the X and Y coordinate pairs of a start-click and an end-click as the basis for
drawing a line on screen.

Some adjustments have been made to indicate that the buttons on-screen work with the Seekbar, whereas just clicking on the canvas activates a 
separate "draw a line from 0,0 to the pointer's x,y location" function.