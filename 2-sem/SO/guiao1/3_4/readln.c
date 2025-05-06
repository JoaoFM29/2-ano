#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include "readln.h"

#define BUFFER_SIZE 10

int readch(int fd, char* buf)
{
    static char buffer[BUFFER_SIZE];
    static int next_position = 0;
    static int last_read_bytes = 0;

    if(next_position==last_read_bytes)
    {
        int bytes = 0;
        if((bytes = read(fd, buffer, BUFFER_SIZE))<1)
        {
            return 1;
        }
        next_position = 0;
        last_read_bytes = bytes;
    }
    *buf = buffer[next_position];
    next_position ++;

    return 0;
}

ssize_t readln(int fd, char *line, size_t size)
{
    int next_pos = 0;
    int read_bytes = 0;

    while(next_pos < size && readch(fd, line + next_pos) > 0) // a[10] = *a + 10
    {
        read_bytes++;
        if(line[next_pos] == '\n')
        {
            break;
        }
        next_pos++;
    }
    return read_bytes;
}

int main (int argc, char** argv)
{
    if (argc > 1)
    {
        printf("ERRO\n");
        return -1;
    }
    size_t size = 20;
    char* line = malloc (sizeof(char)*size);

    readln(0,line,size);

    free(line);
    return 0;
}