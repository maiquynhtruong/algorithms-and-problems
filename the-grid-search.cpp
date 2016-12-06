/**
https://www.hackerrank.com/challenges/the-grid-search
**/
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int R, C, r, c;

int gridSearch(char large[R][C+1], char small[r][c+1]){
    int row, counter, distance;
    char *occurrance;
    for (int i = 0; i < R; i++){
        occurrance = strstr(large[i], small[0]);
        if (occurrance != 0){
            row = i+1;
            counter = 1;
            distance = occurrance - large[i];
            for (int j = 1; j < r && row < R; j++, row++){
                if ((occurrance = strstr(large[row], small[j])) != 0) {
                    if (occurrance - large[row] == distance)
                        counter++;
                }
            }
            if (counter == r)
                return 1;
        }
    }
    return 0;
}

int main() {

    FILE *fin = stdin;
    int testCase = 0;

    fscanf(fin,"%d", &testCase);
    int test, row;
    for (test = 0; test < testCase; test++){
        fscanf(fin,"%d %d ", &R, &C);
        char largeGrid[R][C+1];
        char temp[C*2];
        for (row = 0; row < R; row++){
            if (fgets(temp, C*2, fin))
                for (int ind = 0; ind < C; ind++)
                    largeGrid[row][ind] = temp[ind];
                largeGrid[row][C] = '\0';

        }
        fscanf(fin, "%d %d ", &r, &c);
        char smallGrid[r][c+1];
        char temp2[c*2];
        for (row = 0; row < r; row++){
            if (fgets(temp2, c*2, fin))
                for (int ind = 0; ind < c; ind++)
                    smallGrid[row][ind] = temp2[ind];
                smallGrid[row][c] ='\0';

        }
        if (gridSearch(largeGrid, smallGrid)){
            printf("YES\n");
        } else {
            printf("NO\n");
        }
    }
    return 0;
}

/**
Solution was based on this code
http://dhivyavelu.blogspot.com/2015/06/hackerrank-grid-search.html
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
int main()
{
    int t,r,c,R,C,i,j,count,pos,k;
    char *ptr;
    scanf("%d",&t);
    while(t--)
    {
        scanf("%d %d",&R,&C);
        char mat[R+2][C+2];
        for(i=0; i<R; i++)
            scanf("%s",mat[i]);
        scanf("%d %d",&r,&c);
        char smat[r+2][c+2];
        for(i=0; i<r; i++)
            scanf("%s",smat[i]);
        for(i=0; i<R; i++)
        {
            count=1;
            ptr=strstr(mat[i],smat[0]);
            if(ptr!=0)
            {
                pos=ptr-mat[i];
                k=i+1;
                for(j=1; j<r&&k<R; j++,k++)
                {
                    ptr=strstr(mat[k],smat[j]);
                    if(pos==ptr-mat[k])
                        count++;
                }
                if(count==r)
                {
                    printf("YES\n");
                    break;
                }
            }
        }
        if(i==R)
            printf("NO\n");
    }
    return 0;
}
**/
