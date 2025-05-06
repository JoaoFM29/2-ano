#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include "readln.h"

int main (int argc, char** argv)
{
    if (argc > 1)
    {
        printf("usage: ./readln\n");
        return -1;
    }
    size_t size = 20;
    char* line = malloc (sizeof(char)*size);

    readln(0,line,size);

    free(line);
    return 0;
}