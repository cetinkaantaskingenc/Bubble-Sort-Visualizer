float [] values;
int i = 0;
int j = 0;
int counter = 0;
int m = millis();

void setup() {
  size(1500, 800);
  values = new float[width];
  
  for (int i = 0; i < values.length; i++) {
    values[i] = random(height);
  }
}


void draw() {
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


void swap (float[] arr, int a, int b) {
  counter++;
  float temp = arr[a];
  arr[a] = arr[b];
  arr[b] = temp;
}
