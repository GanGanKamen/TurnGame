void mouseClicked() {
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

void Earthquake() {
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
  float damege = (22*100*GarA*GarAup/RanB/50+2)*random(85, 100)/100*1.5*2*2;
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

void Outrage() {
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
  float damege = (22*120*GarA*GarAup/RanB/50+2)*random(85, 100)/100*1.5/2;
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
    gekirinT = int(t0);
    GarAction = false;
  } else if (GarAction == false) {
    gekirinT = gekirinT - 1;
    if (gekirinT == 0) {
      GarAction = true;
      if (Confused == false) {
        Confused = true;
        float t0 = random(1, 5);
        confusionT = int(t0);
        GarBetoCon = true;
      }
    }
  }
}

void SwordsDance() {
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

void SwordsDance2() {
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

void RockTomb() {
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

void RockTomb2() {
  if (t6 + 120>t&&t6+60<t) {
    fill(255);
    noStroke();
    rect(50, 320, 400, 60);
    fill(0);
    textSize(24);
    text("あいてのヒードランの　すばやさが　さがった", 50, 320, 400, 100);
  }
}
