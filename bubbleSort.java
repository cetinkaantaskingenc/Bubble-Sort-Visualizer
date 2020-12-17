import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class bubbleSort extends PApplet {

float [] values;
int i = 0;
int j = 0;
int counter = 0;
int m = millis();

public void setup() {
  
  values = new float[width];
  
  for (int i = 0; i < values.length; i++) {
    values[i] = random(height);
  }
}


public void draw() {
  int m = millis();
  //int savedTime = millis();
  
  background(0);
  
  textSize(36);
  text("BUBBLE SORT", 20, 40);
  
  textSize(26);
  text("Elements: "+values.length, 20, 80);
  
  textSize(26);
  text("Swapped: "+counter, 20, 120);
  
  textSize(26);
  text("Time: "+m+"ms", 20, 160);

  IntList  swapped = new IntList();

  float len = values.length;
  
  //do this for the entire array 
  if (i < len) {
      
      for (j = 0; j < len-i-1; j++) {
          float a = values[j];
          float b = values[j + 1];
          
          if (a > b) {
              swapped.append(j);
              swapped.append(j+1);
              swap(values, j, j+1);
          }
      }
  } else {
      noLoop();
      background(0,128,0);
      
      textSize(36);
      text("BUBBLE SORT", 20, 40);
      
      textSize(26);
      text("Elements: "+values.length, 20, 80);
        
      textSize(26);
      text("Swapped: "+counter, 20, 120);
        
      textSize(26);
      text("Time: "+m+"ms", 20, 160);
  }
  i++; //without this the program does not end

  for (int i = 0; i < len; i++) {
        if ( swapped.hasValue(i) )
            stroke(255, 0, 0);
        else
            stroke(255);
            line(i, height, i, height - values[i]);
    }     
}


public void swap (float[] arr, int a, int b) {
  counter++;
  float temp = arr[a];
  arr[a] = arr[b];
  arr[b] = temp;
}
  public void settings() {  size(1500, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "bubbleSort" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
