#include <unistd.h>/* chamadas ao sistema: defs e decls essenciais */
#include <sys/wait.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <fcntl.h>

#define SIZE_LINE_MAX 1024

int main(int argc, char const *argv[]){
    int fd;
    int bytes_read;
    char buf[SIZE_LINE_MAX];
    if(fd = open("fifo", O_RDONLY, 0600)==-1){
        perror("open");
        return -1;
    }
    else{
        printf("opened fifo for reading\n");
    }
    while((bytes_read = read(fd, &buf, SIZE_LINE_MAX))>0){
        write(1, &buf, bytes_read);
    }
    printf("Done\n");
    close(fd);
    unlink("fifo");
    return 0;

}