#include <unistd.h>/* chamadas ao sistema: defs e decls essenciais */
#include <sys/wait.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>

#define SIZE_LINE_MAX 1024

int main(int argc, char const *argv[]){
    int fd;
    if(argc<1){
        printf("missing arguments\n");
        _exit(0);
    }

    if((fd = open("fifo", O_WRONLY, 0600))==-1){
        perror("open");
    }
    else{
        printf("[DEBUG] opened fifo for writting\n");
    }
    write(fd, argv[1], strlen(argv[1]));
    close(fd);
    return 0;

}