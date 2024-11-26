#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>

#define SHM_SIZE 1024

int main() {
    key_t key;
    int shmid;
    char *shm_ptr;
    pid_t pid;

    // Generate a unique key
    if ((key = ftok("shmfile", 65)) == -1) {
        perror("ftok");
        exit(EXIT_FAILURE);
    }

    // Create a shared memory segment
    if ((shmid = shmget(key, SHM_SIZE, 0666 | IPC_CREAT)) == -1) {
        perror("shmget");
        exit(EXIT_FAILURE);
    }

    // Fork a child process
    if ((pid = fork()) < 0) {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    if (pid > 0) { // Parent process
        // Attach to shared memory
        if ((shm_ptr = (char*) shmat(shmid, NULL, 0)) == (char*) -1) {
            perror("shmat");
            exit(EXIT_FAILURE);
        }

        // Write a message to shared memory
        strcpy(shm_ptr, "Hello from parent process");
        printf("Parent process wrote: %s\n", shm_ptr);

        // Detach from shared memory
        if (shmdt(shm_ptr) == -1) {
            perror("shmdt");
        }

        // Wait for the child process to finish
        waitpid(pid, NULL, 0);
    } else { // Child process
        sleep(1); // Ensure parent writes first (simple synchronization)

        // Attach to shared memory
        if ((shm_ptr = (char*) shmat(shmid, NULL, 0)) == (char*) -1) {
            perror("shmat");
            exit(EXIT_FAILURE);
        }

        // Read the message from shared memory
        printf("Child process received: %s\n", shm_ptr);

        // Detach from shared memory
        if (shmdt(shm_ptr) == -1) {
            perror("shmdt");
        }

        // Mark the shared memory segment for deletion
        if (shmctl(shmid, IPC_RMID, NULL) == -1) {
            perror("shmctl");
        }
    }

    return 0;
}

