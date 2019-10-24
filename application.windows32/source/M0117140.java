import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 
import ddf.minim.analysis.*; 
import ddf.minim.effects.*; 
import ddf.minim.signals.*; 
import ddf.minim.spi.*; 
import ddf.minim.ugens.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class M0117140 extends PApplet {








Minim minim;         
AudioPlayer audio;
AudioSample SE1, SE2, SE3, SE4, CT;
Pokemon garchomp, heatran;
PImage bg;
PImage Garchomp;
PImage Heatran;
int GarHP, GarA, GarB, GarC, GarD, GarS;
int RanHP, RanA, RanB, RanC, RanD, RanS;
int GarAup=1;
boolean turn;
boolean RanAction = true;
boolean GarAction = true;
boolean Confused;
boolean GarBetoCon = false;
int confusionT;
boolean magumaIn = false;
float GH;
float RH; 
int Gcol;
int Rcol;
int waitR = 0;
int wait1 = 0;
int  t1;
int t = 500;
int t2 = -900;
int t3 = -800;
int t4 = -600;
int t5 = -700;
int t6 = -500;
float RA;
int magumaT;
int gekirinT;
float bgmSwitch = random(1, 7);
float probability;
int GA,RA0;

public void setup() {
   
  
  background(0);
  Garchomp = loadImage("445_3.png");
  Heatran = loadImage("485.png");
  bg = loadImage("bg.png");
  minim = new Minim(this);  // Minimの本体を生成
  if (bgmSwitch >=1&&bgmSwitch <2) { 
    audio = minim.loadFile("battle1.mp3");
  } else if (bgmSwitch >=2&&bgmSwitch <3) { 
    audio = minim.loadFile("battle2.mp3");
  } else if (bgmSwitch >=3&&bgmSwitch <4) { 
    audio = minim.loadFile("battle3.mp3");
  } else if (bgmSwitch >=4&&bgmSwitch <5) { 
    audio = minim.loadFile("battle4.mp3");
  } else if (bgmSwitch >=5&&bgmSwitch <6) { 
    audio = minim.loadFile("battle5.mp3");
  } else if (bgmSwitch >=6&&bgmSwitch <=7) { 
    audio = minim.loadFile("battle6.mp3");
  }
  SE1 = minim.loadSample("nc114901.mp3");
  SE2 = minim.loadSample("nc114900.mp3");
  SE3 = minim.loadSample("nc114899.mp3");
  SE4 = minim.loadSample("nc114902.mp3");
  CT = minim.loadSample("ColorTimer.mp3");
  audio.loop();
  garchomp = new Pokemon(GarHP, GH, GarAction, Gcol);
  heatran = new Pokemon(RanHP, RH, RanAction, Rcol);
  GarHP = 183; 
  GarA = 182; 
  GarB = 115; 
  GarC = 90; 
  GarD = 106; 
  GarD = 169;
  RanHP = 197; 
  RanA = 99; 
  RanB = 126; 
  RanC = 126; 
  RanD = 165;
  turn = true;
  Confused = false;
  PFont font = createFont("MS Gothic", 28, true);
  textFont (font);
  image(bg, 2, 0);
  image(Garchomp, 30, 110);
  image(Heatran, 280, 0);
  GH = 100;
  RH = 100;
}

public void draw() {
  println(GH, RA0, turn, RanAction, "混乱"+Confused, "うず"+magumaT, "逆鱗"+gekirinT, 
    "wait1"+wait1, t, t1, t2, t3, t4, t5);

  GarHP();
  RanHP();
  if (RH == 0) {
    turn = false;
    RanAction = false;
    RanDown();
  }
  if (GH == 0) {
    turn =false;
    GarDown();
  }
  if (turn == true) {
    wait1++;
    if (GarBetoCon == true) { 
      if (wait1 ==10) {
        fill(255);
        noStroke();
        rect(50, 320, 400, 60);
        fill(0);
        textSize(24);
        text("ガブリアスは つかれはてて こんらんした", 50, 320, 420, 90);
      }
    }

    if (wait1 == 200) {
      fill(255);
      noStroke();
      rect(50, 320, 400, 60);
      fill(0);
      textSize(24);
      text("ガブリアスは どうする？", 60, 320, 400, 100);
    }
  }
  if (turn == false&&RanAction == true) {
    RanAttack();
  }
  if (turn == true&&GarAction == false) {
    Outrage();
  }
  if (turn == false&&Confused == true) {
    if (probability <= 2.5f) {
      Confusion();
    } else {
      if (t4+120>t &&t4+60<t) {
        switch(GA) {
          case 1:
          Earthquake();
          break;
          case 2:
          Outrage();
          break;
          case 3:          
          SwordsDance();
          break;
          case 4:
          RockTomb();
          break;
        }
      }
    }
  }
  t++;
  if (turn == false) {
    batugun();
    imahitotu();
    SwordsDance2();
    RockTomb2();
  }
  Return();
}
public void Return() {
  maguma2();
  if (t2 > -900) {
    t1++;
    if (t1 > 300) {
      turn = true;
      RanAction = true;
      t1 = 0;
      t2 = -900;
      t3 = -800;
      t4 = -600;
      t5 = -700;
      t6 = -500;
    }
  } 
  if (t3 > -800) {
    t1++;
    if (t1 > 600) {
      turn = true;
      RanAction = true;
      t1 = 0;
      t2 = -900;
      t3 = -800;
      t4 = -600;
      t5 = -700;
      t6 = -500;
    }
  }
  if (t5 > -700) {
    t1++;
    if (t1 > 600) {
      turn = true;
      RanAction = true;
      t1 = 0;
      t2 = -900;
      t3 = -800;
      t4 = -600;
      t5 = -700;
      t6 = -500;
    }
  }
  if (t4 >-600) {
    t1++;
    if (t1 > 600) {
      turn = true;
      RanAction = true;
      t1 = 0;
      t2 = -900;
      t3 = -800;
      t4 = -600;
      t5 = -700;
      t6 = -500;
    }
  }
  if (t6 >-500) {
    t1++;
    if (t1 > 600) {
      turn = true;
      RanAction = true;
      t1 = 0;
      t2 = -900;
      t3 = -800;
      t4 = -600;
      t5 = -700;
      t6 = -500;
    }
  }
}

public void batugun() {
  if ((t2+240>t&&t2+120<t)|| (((t3+480>t&&t3+240<t)
    ||(t5+480>t&&t5+240<t)||(t4+480>t &&t4+240<t)||(t6+480>t&&t6+240<t))&&RA0 == 3)){
    fill(255);
    noStroke();
    rect(50, 320, 400, 60);
    fill(0);
    textSize(24);
    text("こうかは　ばつぐんだ!", 50, 320, 500, 100);
  }
}

public void imahitotu() {
  if ((t3+120>t&&t3+60<t)
  ||(((t3+480>t&&t3+240<t)||(t5+480>t&&t5+240<t)||(t4+480>t &&t4+240<t)||(t6+480>t&&t6+240<t))&& RA0 == 1)) {
    fill(255);
    noStroke();
    rect(50, 320, 400, 60);
    fill(0);
    textSize(24);
    text("こうかは　いまひとつ　のようだ", 50, 320, 500, 100);
  }
}

public void Confusion() {
  if (t4+120>t &&t4+60<t) {
    fill(255);
    noStroke();
    rect(50, 320, 400, 60);
    fill(0);
    textSize(24);
    text("ガブリアスはわけもわからず　じぶんを　こうげきした", 50, 320, 400, 80);
    SE3.trigger();
    float damege = (22*40*GarA/GarB/50+2)/100;
    if (damege > GarHP) {
      damege = GarHP;
    }
    GH = GH - (damege/GarHP)*100;
     if (GH <0) {
    GH =0;
  }
    fill(255);
    stroke(1);
    rect(370+GH, 265, 100-GH, 10);
  }
}


  public void Confusion0() {
  turn = false;
  wait1 = 0;
  fill(255);
  noStroke();
  rect(50, 320, 400, 60);
  fill(0);
  textSize(24);
  text("ガブリアスは　こんらんしている", 50, 320, 500, 100);
  t4 = t;
}
public void GarHP() {
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

public void RanHP() {
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

public void RanDown() {
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

public void GarDown() {
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
  int c;

  Pokemon(int HP, float hp, boolean action, int HPcol) {
    H = HP;
    h = hp;
    act = action;
    c = HPcol;
  }
}
public void mouseClicked() {
  if (mouseX >= 20 && mouseX <= 250 &&
    mouseY >=424 && mouseY <= 524 && turn == true && GarAction == true) {
    GA = 1;
    if (Confused == false) {
      Earthquake();
    } else {
      Confusion0();
      probability = random(0, 10);
    }
  } else if (mouseX >= 260 && mouseX <= 482 && 
    mouseY >=424 && mouseY <= 524 && turn == true&& GarAction == true) {
    GA = 2;
    if (Confused == false) {
      Outrage();
    } else {
      Confusion0();
      probability = random(0, 10);
    }
  } else if (mouseX >= 20 && mouseX <= 250 && 
    mouseY >=574 && mouseY <= 674 && turn == true && GarAction == true) {
    GA = 3;
    if (Confused == false) {
      SwordsDance();
    } else {
      Confusion0();
      probability = random(0, 10);
    }
  } else if (mouseX >= 260 && mouseX <= 482 &&
    mouseY >=574 && mouseY <= 674 && turn == true && GarAction == true) {
    GA = 4;
    if (Confused == false) {
      RockTomb();
    } else {
      Confusion0();
      probability = random(0, 10);
    }
  }
}

public void Earthquake() {
  RA = random(1, 5);
  turn = false;
  wait1 = 0;
  fill(255);
  noStroke();
  rect(50, 320, 400, 60);
  fill(0);
  textSize(24);
  text("ガブリアスは じしんを　つかった", 50, 320, 400, 100);
  SE1.trigger();
  t2= t;
  float damege = (22*100*GarA*GarAup/RanB/50+2)*random(85, 100)/100*1.5f*2*2;
  if (damege > RanHP) {
    damege = RanHP;
  }
  RH = RH - (damege/RanHP)*100;
  if (RH <0) {
    RH =0;
  }
  fill(255);
  stroke(1);
  rect(180, 50, RH-100, 10);
}

public void Outrage() {
  RA = random(1, 5);
  turn = false;
  wait1 = 0;
  fill(255);
  noStroke();
  rect(50, 320, 400, 60);
  fill(0);
  textSize(24);
  text("ガブリアスは げきりんを つかった", 50, 320, 420, 90);
  SE2.trigger();
  t3 = t;
  float damege = (22*120*GarA*GarAup/RanB/50+2)*random(85, 100)/100*1.5f/2;
  if (damege > RanHP) {
    damege = RanHP;
  }
  RH = RH - (damege/RanHP)*100;
  if (RH <0) {
    RH =0;
  }
  fill(255);
  stroke(1);
  rect(180, 50, RH-100, 10);
  if (GarAction == true) {
    float t0 = random(1, 3);
    gekirinT = PApplet.parseInt(t0);
    GarAction = false;
  } else if (GarAction == false) {
    gekirinT = gekirinT - 1;
    if (gekirinT == 0) {
      GarAction = true;
      if (Confused == false) {
        Confused = true;
        float t0 = random(1, 5);
        confusionT = PApplet.parseInt(t0);
        GarBetoCon = true;
      }
    }
  }
}

public void SwordsDance() {
  RA = random(1, 5);
  turn = false;
  wait1 = 0;
  fill(255);
  noStroke();
  rect(50, 320, 400, 60);
  fill(0);
  textSize(24);
  text("ガブリアスは つるぎのまい　をつかった", 50, 320, 400, 100);
  t5 = t;
}

public void SwordsDance2() {
  if (t5+120>t && t5+60<t) {
    fill(255);
    noStroke();
    rect(50, 320, 400, 60);
    fill(0);
    textSize(24);
    text("ガブリアスの　こうげきが　ぐーんと　あがった!", 50, 320, 400, 100);
    GarAup=2;
  }
}

public void RockTomb() {
  RA = random(1, 5);
  turn = false;
  wait1 = 0;
  fill(255);
  noStroke();
  rect(50, 320, 400, 50);
  fill(0);
  textSize(24);
  text("ガブリアスは がんせきふうじを　つかった", 50, 320, 400, 100);
  SE3.trigger();
  t6 = t;
  float damege = (22*60*GarA*GarAup/RanB/50+2)*random(85, 100)/100;
  if (damege > RanHP) {
    damege = RanHP;
  }
  RH = RH - (damege/RanHP)*100;
  if (RH <0) {
    RH =0;
  }
  fill(255);
  stroke(1);
  rect(180, 50, RH-100, 10);
}

public void RockTomb2() {
  if (t6 + 120>t&&t6+60<t) {
    fill(255);
    noStroke();
    rect(50, 320, 400, 60);
    fill(0);
    textSize(24);
    text("あいてのヒードランの　すばやさが　さがった", 50, 320, 400, 100);
  }
}
public void RanAttack() {

    if (RA >= 1&& RA < 2) {
    MagmaStorm();
  }
  else if(RA >= 2&& RA < 3) {
    FlashCannon();
  }
  else if(RA >= 3&& RA < 4){
  HiddenPower();
  }
  else if(RA >= 4&& RA < 5){
  EarthPower();
  }
}

public void MagmaStorm() {
  RA0 = 1;
  if ((t3+320>t &&t3+160<t)||(t5+320>t &&t5+160<t)||(t4+320>t &&t4+160<t)||
  (t6+320>t &&t6+160<t)) {
    fill(255);
    noStroke();
    rect(50, 320, 400, 60);
    fill(0);
    textSize(24);
    text("あいてのヒードランは マグマストームを つかった", 50, 320, 420, 100);
    SE2.trigger();
    float damege = (22*100*RanC/GarD/50+2)*random(85, 100)/100*1.5f/2;
    if (damege > GarHP) {
      damege = GarHP;
    }
    GH = GH - (damege/GarHP)*100;
    fill(255);
    stroke(1);
    rect(370+GH, 265, 100-GH, 10);
    if (magumaIn == false) {
      float t0 = random(4, 5);
      magumaT = PApplet.parseInt(t0);
      magumaIn = true;
    }
    RanAction = false;
  }
}

public void maguma2() {
  if (magumaIn == true&&GH > 0) {
    if (t1 == 500) {
      fill(255);
      noStroke();
      rect(50, 320, 400, 58);
      fill(0);
      textSize(24);
      text("ガブリアスは マグマの　うずに　とじこめられた", 60, 320, 400, 100);
      float damege = GarHP/8;
      GH = GH - (damege/GarHP)*100;
      fill(255);
      stroke(1);
      rect(370+GH, 265, 100-GH, 10);
      magumaT = magumaT -1;
      if (magumaT==0) {
        magumaIn = false;
      }
      RanAction = false;
    }
  }
}

public void FlashCannon() {
  RA0 = 2;
  if ((t3+320>t &&t3+160<t)||(t5+320>t &&t5+160<t)||(t4+320>t &&t4+160<t)||
  (t6+320>t &&t6+160<t)) {
    fill(255);
    noStroke();
    rect(50, 320, 400, 60);
    fill(0);
    textSize(24);
    text("あいてのヒードランは ラスターカノンを つかった", 50, 320, 420, 100);
    SE3.trigger();
    float damege = (22*80*RanC/GarD/50+2)*random(85, 100)/100*1.5f;
    if (damege > GarHP) {
      damege = GarHP;
    }
    GH = GH - (damege/GarHP)*100;
    fill(255);
    stroke(1);
    rect(370+GH, 265, 100-GH, 10);
    RanAction = false;
  }
}

public void HiddenPower() {
  RA0 = 3;
  if ((t3+320>t &&t3+160<t)||(t5+320>t &&t5+160<t)||(t4+320>t &&t4+160<t)||
  (t6+320>t &&t6+160<t)) {
    fill(255);
    noStroke();
    rect(50, 320, 400, 60);
    fill(0);
    textSize(24);
    text("あいてのヒードランは めざめるパワーを つかった", 50, 320, 420, 100);
    SE1.trigger();
    float damege = (22*90*RanC/GarD/50+2)*random(85, 100)/100*4;
    if (damege > GarHP) {
      damege = GarHP;
    }
    GH = GH - (damege/GarHP)*100;
    if (GH <0) {
    GH =0;
  }
    fill(255);
    stroke(1);
    rect(370+GH, 265, 100-GH, 10);
    RanAction = false;
  }
}

public void EarthPower() {
  RA0 = 4;
  if ((t3+320>t &&t3+160<t)||(t5+320>t &&t5+160<t)||(t4+320>t &&t4+160<t)||
  (t6+320>t &&t6+160<t)) {
    fill(255);
    noStroke();
    rect(50, 320, 400, 60);
    fill(0);
    textSize(24);
    text("あいてのヒードランは だいちのちからを つかった", 50, 320, 420, 100);
    SE3.trigger();
    float damege = (22*60*RanC/GarD/50+2)*random(85, 100)/100;
    if (damege > GarHP) {
      damege = GarHP;
    }
    GH = GH - (damege/GarHP)*100;
    fill(255);
    stroke(1);
    rect(370+GH, 265, 100-GH, 10);
     if (GH <0) {
    GH =0;
  }
    RanAction = false;
  }
}
  public void settings() {  size(512, 768);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "M0117140" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
