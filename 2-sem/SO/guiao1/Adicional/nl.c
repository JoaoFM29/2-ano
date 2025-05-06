#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include "readln.h"

int calculate_size(int i, ssize_t bytes_read)
{
    double i2 = i;
    double y;
    int j = 1;
    

    while ((y= i2/10) >= 1)
    {
        i2 = y;
        j++;
    }

    return j;
}

int main (int argc, char** argv)
{
    if (argc > 1)
    {
        printf("usage: ./nl\n");
        return -1;
    }

    size_t size = 20;
    ssize_t bytes_read;
    int i = 1;
    char* line = malloc (sizeof(char)*size);

    while((bytes_read = readln(0,line,size)) != 0)
    {
        if (line[0] == '\n')
        {
            write(1,line,bytes_read);
        }
        else
        {
            int size_w = calculate_size(i,bytes_read) + bytes_read + 8;
            char line_w[size_w];
            snprintf(line_w,size_w,"     %d  %s",i,line);
            write(1,line_w,size_w);
            i++;
        }
    }

    free(line);
    return 0;
}