#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include "string.h"
#include "person.h"


int new_person(char* name, int age)
{
    
    int FILE = open(FILENAME, O_RDWR | O_CREAT | O_APPEND, 0600);
    Person person;
    strcpy(person.name, name);
    person.age = age;
    int linhas_read = 0;

    write(FILE, &person, sizeof(struct Person));

    lseek(FILE, 0, SEEK_SET);
    while(read(FILE, &person, sizeof(struct Person))>0)
    {
        linhas_read ++;
    }
    close(FILE);

    printf("Registo %d\n", linhas_read);
    return 0;
}

int person_change_age(char* name, int age)
{
    int FILE = open(FILENAME, O_RDWR | O_CREAT, 0666); 
    Person person;

    while(read(FILE, &person, sizeof(struct Person))>0)
    {
        if(!strcmp(person.name, name))
        {
            person.age = age;
            lseek(FILE, -sizeof(struct Person), SEEK_CUR); // volta para lugar onde encontraram o nome
            write(FILE, &person, sizeof(struct Person)); // reesrever a struct atualizada
        }
    }
    close(FILE);
    return 0;
}

int person_change_age_v2(long pos, int age)
{
    int FILE = open(FILENAME, O_RDWR | O_CREAT, 0666); 
    ssize_t bytes;
    Person person;
    person.age = age;

    lseek(FILE, (pos-1)*sizeof(struct Person), SEEK_CUR); // volta para lugar atrás onde vai ser alterado
    write(FILE, &person, sizeof(struct Person)); // reesrever o nome a atualiza a data com a dada no argumento
    
    close(FILE);
    return 0;
}

int main (int argc, char** argv)
{
    if(!strcmp(argv[1], "-i"))
        {
            new_person(argv[2], atoi(argv[3]));
        }
    else 
    {
        if(!strcmp(argv[1], "-u"))
            {
                person_change_age(argv[2], atoi(argv[3]));
            }
        if(!strcmp(argv[1], "-o"))
            {
                person_change_age_v2(atoi(argv[2]), atoi(argv[3]));
            }
    }
    return 0;
}
