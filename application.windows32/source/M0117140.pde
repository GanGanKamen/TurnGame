import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.effects.*;
import ddf.minim.signals.*;
import ddf.minim.spi.*;
import ddf.minim.ugens.*;

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
color Gcol;
color Rcol;
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

void setup() {
  size(512, 768); 
  smooth();
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

void draw() {
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
    if (probability <= 2.5) {
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
