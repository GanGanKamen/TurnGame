void Return() {
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

void batugun() {
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

void imahitotu() {
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

void Confusion() {
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


  void Confusion0() {
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
