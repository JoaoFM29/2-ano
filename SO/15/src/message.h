#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include "util.h"

typedef enum
{

    Break,
    Start,
    Info,
    InfoTime,
    InfoCommand,
    InfoUniq,
    Finish

} Type;

typedef struct message
{

    pid_t pid;
    double timeStamp;
    char progName[260];
    Type state;
    struct message *next;

} Message;

/*
 *
 * Função que imprime no STDOUT uma mensagem
 *
 */
void printMessage(Message msg);
/*
 *
 * Função que imprime no STDOUT uma lista na sua totalidade
 *
 */
void printList(Message *head);
/*
 *
 * Função que realiza um clone de uma instancia de mensagem
 *
 */
Message *cloneMessage(Message *original);
/*
 *
 * Função que imprime para ficheiros uma mensagem
 *
 */
void writeMessageToFile(int fp, Message msg);
/*
 *
 * Função que adciona mensagens com ProgNames não repetidos
 * A inserção é feita no final da lista
 *
 */
void addToList(Message **head, Message *newElement);
/*
 *
 * Retira os Argumentos de um progName deixando apenas o Programa
 *
 */
Message alterArg(Message msg);