#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/time.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h> /* O_RDONLY, O_WRONLY, O_CREAT, O_* */

#include "message.h"

#define MAX_TABLE 256

typedef struct hash_table
{
    Message *table[MAX_TABLE];
} HashTable;
/*
 * Função de Hash
 */
int hash_function(pid_t key);
/*
 * Função que inserere uma mensagem na tabela
 */
void insert_message(HashTable *ht, Message msg);
/*
 * Função que vai buscar uma mensagem
 */
Message get_message(HashTable *ht, pid_t key);
/*
 * Função que vai alterar o estado de uma mensagem para Finish
 */
void end_message(HashTable *ht, Message m);
/*
 * Função que limpa uma tabela caso não estejam processos a correr nesse momento
 */
void check_and_reset_table(HashTable *ht);
/*
 * Função que escreve todos os processos no estado Start no descritor
 */
void print_table(HashTable *ht, int fd);
/*
 * Função que concretiza o comando "stats-time"
 * Reccore à função get_message
 */
void time_table_list(HashTable *ht, char *list, int fd);
/*
 * Função auxiliar que vê se a é substring de b
 */
int isSubstring(char *a, char *b);
/*
 * Função auxiliar que vê se a é substring de b
 */
int showManyTimes(const char *substring, const char *string);
/*
 * Função auxiliar que conta o número de vezes que a substring aparece na string
 */
void command_table_list(HashTable *ht, char *list, int fd);
/*
 * Função auxiliar que vê se a mensagem já esxiste na lista
 */
int checkIfMember(Message *list, Message *check);
/*
 * Função que concretiza o comando "stats-uniq"
 * Reccore à função checkIfMember
 */
void uniq_table_list(HashTable *ht, char *list, int fd);