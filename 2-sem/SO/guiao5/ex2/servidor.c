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
    int fd, fd2, bytes_read, logfile;

    if((logfile = open ("log.txt", O_CREAT|O_TRUNC|O_WRONLY, 0666))==-1){
        perror("open");
        return -1;
    }

    if((fd = open("fifo", O_RDONLY))==-1){
        perror("open");
        return -1;
    }
    else{
        printf("[DEBUG] opened fifo for reading\n");
    }
    //open fifo for writting
    //to avoid existing when there are no clients
    if((fd2 = open("fifo", O_WRONLY))==-1){
        perror("open");
        return -1;
    }
    else{
        printf("[DEBUG] opened fifo for reading\n");
    }

    while(bytes_read = read(fd, buf, SIZE_LINE_MAX)>0){
        write(logfile, &buf, bytes_read);
        buf[bytes_read] = '\0';
        printf("[DEBUG] wrote %s to file \n", buf);
    }
    write(logfile, "\n\0", 1);
    printf("[DEBUG] EOF\n");
    close(fd);
    close(logfile);
    unlink("fifo");
    return 0;
}