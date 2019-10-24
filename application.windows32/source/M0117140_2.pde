void GarHP() {
  if(GH > 50){
  Gcol = color(0, 128, 0);
  }
  else if(GH > 25&&GH<=50){
  Gcol = color(255, 255, 0);
  }
  else if(GH<=25){
  Gcol = color(255, 0, 0);
  }
  fill(Gcol);
  stroke(1);
  if (GH < 0) {
    GH = 0;
  }
  rect(370, 265, GH, 10);
}

void RanHP() {
  if(RH > 50){
  Rcol = color(0, 128, 0);
  }
  else if(RH > 25&&RH<=50){
  Rcol = color(255, 255, 0);
  }
  else if(RH<=25){
  Rcol = color(255, 0, 0);
  }
  fill(Rcol);
  stroke(1);
  if (RH < 0) {
    RH = 0;
  }
  rect(80, 50, RH, 10);
}

void RanDown() {
  if (waitR < 320) {
    waitR++;
  }
  if (waitR == 319) {
    fill(255);
    noStroke();
    rect(50, 320, 410, 60);
    fill(0);
    textSize(24);
    text("あいてのヒードランは たおれた \n", 50, 320, 500, 100);
    SE4.trigger();
  }
}

void GarDown() {
  if (waitR < 320) {
    waitR++;
  }
  if (waitR == 319) {
    fill(255);
    noStroke();
    rect(50, 320, 410, 60);
    fill(0);
    textSize(24);
    text("ガブリアスは たおれた \n", 50, 320, 500, 100);
    SE4.trigger();
  }
}

class Pokemon {
  int H;
  float h;
  boolean act;
  color c;

  Pokemon(int HP, float hp, boolean action, color HPcol) {
    H = HP;
    h = hp;
    act = action;
    c = HPcol;
  }
}
