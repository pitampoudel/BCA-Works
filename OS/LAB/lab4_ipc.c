#include <stdio.h>
#include <windows.h>

int main() {
    HANDLE hPipe;
    char writeMsg[] = "Hello from Parent!";
    char readMsg[100];
    DWORD bytesRead, bytesWritten;

    // Create a named pipe
    hPipe = CreateNamedPipe(
        "\\\\.\\pipe\\MyPipe",           // Pipe name
        PIPE_ACCESS_DUPLEX,             // Read/Write access
        PIPE_TYPE_BYTE | PIPE_WAIT,     // Byte-type pipe, blocking mode
        1,                              // Max number of instances
        1024,                           // Output buffer size
        1024,                           // Input buffer size
        0,                              // Timeout
        NULL);                          // Default security attributes

    if (hPipe == INVALID_HANDLE_VALUE) {
        printf("Failed to create named pipe. Error: %ld\n", GetLastError());
        return 1;
    }

    // Create a child process using CreateProcess
    STARTUPINFO si = { sizeof(si) };
    PROCESS_INFORMATION pi;
    BOOL processCreated = CreateProcess(
        NULL, "child_process.exe",  // Replace with the actual child program
        NULL, NULL, TRUE, 0, NULL, NULL, &si, &pi);

    if (processCreated) {
        // Parent process writes to the pipe
        if (ConnectNamedPipe(hPipe, NULL) || GetLastError() == ERROR_PIPE_CONNECTED) {
            WriteFile(hPipe, writeMsg, strlen(writeMsg) + 1, &bytesWritten, NULL);
            printf("Parent sent: %s\n", writeMsg);
        }

        // Wait for the child process to finish
        WaitForSingleObject(pi.hProcess, INFINITE);
        CloseHandle(pi.hProcess);
        CloseHandle(pi.hThread);
    } else {
        // Child process reads from the pipe
        if (ConnectNamedPipe(hPipe, NULL) || GetLastError() == ERROR_PIPE_CONNECTED) {
            ReadFile(hPipe, readMsg, sizeof(readMsg) - 1, &bytesRead, NULL);
            readMsg[bytesRead] = '\0'; // Null-terminate the string
            printf("Child received: %s\n", readMsg);
        }
    }

    // Close the pipe
    CloseHandle(hPipe);

    // Copyright
    printf("\n© 2025 Pitam. All rights reserved.\n");

    return 0;
}

