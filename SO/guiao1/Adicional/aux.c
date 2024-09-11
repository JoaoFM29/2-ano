#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include "readln.h"

ssize_t readln(int fd, char *line, size_t size)
{
    char buf[size];
    ssize_t read_bytes = 0;
    int i;
    
    read_bytes += read(0,buf,size);

    for (i = 0; i < read_bytes && buf[i] != '\n';i++)
    {
        line[i] = buf[i];
    }

    if (i == read_bytes)
    {
        perror("linha inválida");
        return 0 ;
    }
    else 
    {
        line[i] = buf[i];
        i++;
    }
    /*
    else
    {
        printf("Leu %s\n",line);
    }
    */
    return i;
}