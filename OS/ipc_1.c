#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main() {
    int fd[2];
    pid_t pid;
    char write_msg[] = "Hello from parent process";
    char read_msg[100] = {0}; // Initialize buffer to zero

    // Create a pipe
    if (pipe(fd) == -1) {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    // Fork a new process
    pid = fork();
    if (pid < 0) {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    if (pid > 0) { // Parent process
        close(fd[0]); // Close unused read end

        // Write to the pipe
        if (write(fd[1], write_msg, strlen(write_msg) + 1) == -1) {
            perror("write");
            close(fd[1]);
            exit(EXIT_FAILURE);
        }

        close(fd[1]); // Close write end after writing
    } else { // Child process
        close(fd[1]); // Close unused write end

        // Read from the pipe
        if (read(fd[0], read_msg, sizeof(read_msg)) == -1) {
            perror("read");
            close(fd[0]);
            exit(EXIT_FAILURE);
        }

        printf("Child process received: %s\n", read_msg);

        close(fd[0]); // Close read end after reading
    }

    return 0;
}

