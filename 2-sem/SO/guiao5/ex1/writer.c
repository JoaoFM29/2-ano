#include <unistd.h>/* chamadas ao sistema: defs e decls essenciais */
#include <sys/wait.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>

#define SIZE_LINE_MAX 1024

int main(int argc, char const *argv[]){
    char buf[SIZE_LINE_MAX];
    int bytes_read, fd;

    if (fd = open("fifo", O_WRONLY, 0600)==-1){
        perror("open");
    }
    else{
        printf("opened fifo for writting");
    }
    while((bytes_read = read(0, buf, SIZE_LINE_MAX))>=0){
        write(fd, buf, bytes_read);
    }
    close(fd);
    return 0;
}