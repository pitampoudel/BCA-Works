#include<graphics.h>
#include<conio.h>
#include<stdio.h>
int main(){
	printf("� 2025 Pitam Poudel. All rights reserved.\n");
	int gd=DETECT, gm,i;
	float x,y,dx,dy,steps;
	int x0,x1,y0,y1;
	initgraph(&gd,&gm,"");
	setbkcolor(WHITE);
	x0=100,y0=200,x1=500,y1=300;
	dx=(float)(x1-x0);
	dy=(float)(y-y0);
	if(dx>=dy){
		steps=dx;
	}else{
		steps=dy;
	}
	dx=dx/steps;
	dy=dy/steps;
	x=x0;
	y=y0;
	i=1;
	while(i<=steps){
		putpixel(x,y,RED);
		x+=dx;
		y+=dy;
		i=i+1;
	}
	getch();
	closegraph();

}
