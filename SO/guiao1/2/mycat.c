#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int mycat()
{
    int size = 10;
    char* buf = malloc (sizeof(char)* size);

    ssize_t write_bytes = 0;
    ssize_t read_bytes = 0;
    ssize_t bytes;

    while ((bytes = read(0,buf,size)) > 0)
    {
        read_bytes += bytes;
        write_bytes += write(1,buf,size);
    }

    free(buf);

    return 0;
}

int main(int argc, char** argv)
{
    if (argc>1)
    {
        printf("usage: ./mycat\n");
        return -1;
    }
    mycat();
    return 0;
}