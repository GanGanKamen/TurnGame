void RanAttack() {

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

void MagmaStorm() {
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
    float damege = (22*100*RanC/GarD/50+2)*random(85, 100)/100*1.5/2;
    if (damege > GarHP) {
      damege = GarHP;
    }
    GH = GH - (damege/GarHP)*100;
    fill(255);
    stroke(1);
    rect(370+GH, 265, 100-GH, 10);
    if (magumaIn == false) {
      float t0 = random(4, 5);
      magumaT = int(t0);
      magumaIn = true;
    }
    RanAction = false;
  }
}

void maguma2() {
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

void FlashCannon() {
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
    float damege = (22*80*RanC/GarD/50+2)*random(85, 100)/100*1.5;
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

void HiddenPower() {
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

void EarthPower() {
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
