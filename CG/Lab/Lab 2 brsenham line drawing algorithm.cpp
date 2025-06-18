#include<stdio.h>
#include<graphics.h>
#include<conio.h>

void drawline(int x0,int y0,int x1,int y1){
    int dx=abs(x1-x0),dy=abs(y1-y0),x=x0,y=y0;
    int xi=(x1>x0)?1:-1,yi=(y1>y0)?1:-1,p;
    
    if(dx>dy){
        for(p=2*dy-dx;x!=x1;x+=xi){
            putpixel(x,y,7);
            if(p>=0)y+=yi,p-=2*dx;
            p+=2*dy;
        }
    }else{
        for(p=2*dx-dy;y!=y1;y+=yi){
            putpixel(x,y,7);
            if(p>=0)x+=xi,p-=2*dy;
            p+=2*dx;
        }
    }
    putpixel(x1,y1,7);
}

int main(){
    int gd=DETECT,gm,x0,y0,x1,y1;
    printf("Enter coordinates (x0 y0 x1 y1): ");
    scanf("%d%d%d%d",&x0,&y0,&x1,&y1);
    initgraph(&gd,&gm,NULL);
    drawline(x0,y0,x1,y1);
    getch();
    closegraph();
    return 0;
}
